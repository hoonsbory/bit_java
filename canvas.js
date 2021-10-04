import { throttling } from '../../utils/throttling'
import FaceBoard from './FaceBoard'
import getColorData from './getColorData'
import axios from 'axios'
import colorAvg from './colorAvg'
import store from '../../store'
import '@tensorflow/tfjs-backend-cpu';
import { model } from '../../pages/_app'
import MaskDraw from './MaskDraw'
import { actionCreators } from '../../store/colorStore'
import getDeviceType from './getDeviceType'
import { canvasToImg } from './canvasToImg'
import getFaceImageData from './getFaceImageData'
import { drawFaceLine } from './drawFaceLine'
import { TRIANGULATION } from './triangulations'


export default async function StreamCanvas(faceBoard) {
    let ctx, videoWidth, videoHeight, video, rafID, faceDotDraw
    video = document.getElementById("video")
    let maskColor;
    if (video && video.previousSibling && video.previousSibling.nodeName == "CANVAS") return
    const loading = document.getElementById("loading")
    const ML_Loading = document.getElementById("ML_Loading")
    ML_Loading.style.display = "block"

    const state = {
        backend: 'webgl',
        maxFaces: 1,
        triangulateMesh: true,
        predictIrises: false
    };

    const NUM_KEYPOINTS = 468;
    const NUM_IRIS_KEYPOINTS = 5;
    const GREEN = '#32EEDB';
    const RED = "#FF2C35";
    const BLUE = "#157AB3";
    let testWrapper = document.getElementById("testWrapper")
    let headerWrapper = document.getElementById("headerWrapper")

    const throttler = throttling()
    const progressBar = document.getElementById("progressBar")
    const percent = document.getElementById("progressPercent")
    const progressContainer = document.getElementById("progressContainer")
    const testExplain = document.getElementById("testExplain")
    let canvas = document.createElement("canvas")
    let cnt = 0;
    let colorSum = {}
    let eyeColor = []
    let cheekColor = []
    let jawColor = []
    let typeArr = getDeviceType()
    let icon = new Image()
    icon.src = `${process.env.PATH}/images/beforeCanvasTitle.png`
    let icon2 = new Image()
    icon2.src = `${process.env.PATH}/images/afterCanvasTitle.png`
    if (faceBoard == "mask") {
        let beige_left = new Image()
        beige_left.src = `${process.env.PATH}/images/beige-left.png`
        let beige_right = new Image()
        beige_right.src = `${process.env.PATH}/images/beige-right.png`
        let mint_left = new Image()
        mint_left.src = `${process.env.PATH}/images/mint-left.png`
        let mint_right = new Image()
        mint_right.src = `${process.env.PATH}/images/mint-right.png`
        let black_left = new Image()
        black_left.src = `${process.env.PATH}/images/black-left.png`
        let black_right = new Image()
        black_right.src = `${process.env.PATH}/images/black-right.png`
        let white_left = new Image()
        white_left.src = `${process.env.PATH}/images/white-left.png`
        let white_right = new Image()
        white_right.src = `${process.env.PATH}/images/white-right.png`
        let purple_left = new Image()
        purple_left.src = `${process.env.PATH}/images/purple-left.png`
        let purple_right = new Image()
        purple_right.src = `${process.env.PATH}/images/purple-right.png`
        let pink_left = new Image()
        pink_left.src = `${process.env.PATH}/images/pink-left.png`
        let pink_right = new Image()
        pink_right.src = `${process.env.PATH}/images/pink-right.png`

        maskColor = {
            white: [white_left, white_right],
            black: [black_left, black_right],
            pink: [pink_left, pink_right],
            purple: [purple_left, purple_right],
            beige: [beige_left, beige_right],
            mint: [mint_left, mint_right],
        }
        maskColor[store.getState().ColorReducer.mainMaskColor][1].onload = () => main()
    }
    else if (faceBoard == "scan") {
        store.dispatch(actionCreators.setScanTrigger(true))
        let beforePopup = store.getState().ColorReducer.scanTrigger
        store.subscribe(() => {
            let afterPopup = store.getState().ColorReducer.scanTrigger
            if (beforePopup != afterPopup) {
                setTimeout(() => {
                    main()
                }, 100);
            }
        })
    } else main()








    // if (renderPointcloud) {
    //   state.renderPointcloud = true;
    // }



    async function setupCamera() {
        video = document.getElementById('video');
        return new Promise((resolve) => {
            video.onloadedmetadata = () => {
                resolve(video);
            };
        });
    }

    async function renderPrediction() {
        model.then(async (data) => {
            let predictions
            try {
                predictions = await data.estimateFaces({
                    input: video,
                    returnTensors: false,
                    flipHorizontal: false,
                    predictIrises: false
                });
            } catch (error) {
                setTimeout(() => {
                    renderPrediction()
                }, 300);
                return
            }

            await ctx.clearRect(0, 0, canvas.width, canvas.height)
            // await context.drawImage(video, 0, 0, canvas.width, canvas.height)
            if (predictions.length > 0) {
                ML_Loading.style.display = "none"
                const keypoints = predictions[0].scaledMesh;
                const boxPos = predictions[0].boundingBox
                const positions = await keypoints.map(i => { //facemesh는 비디오의 client사이즈가아닌 video사이즈를 기준으로 포지션을 리턴한다.
                    //그래서 기기에 맞게 맞춰진 캔버스에는 맞지 않기 때문에 해당 비율로 전환해주는 작업을 거쳐야 한다.
                    return { x: i[0] / (video.videoWidth / videoWidth), y: i[1] / (video.videoHeight / videoHeight) }
                })
                // positions.forEach((i,idx)=>{
                //     ctx.fillStyle = "rgb(0,0,255)"
                //     ctx.fillRect(i.x,i.y,1,1)
                // })
                if (faceBoard == "scan") {
                    testExplain.innerHTML = `피부색을 추출 중 입니다.<br> <span style="color : yellow;">Tip : 최대한 빛의 영향을 받지 않는 곳에서 측정해보세요!</span>`
                    cnt++
                    
                    
                    
                    if(positions[30].x<canvas.width/2&&positions[30].x>canvas.width/2-50){
                        // ctx.save()
                        // ctx.scale(-1,1)
                        // ctx.translate(-canvas.width,0)
                        // ctx.drawImage(icon2,canvas.width/2-125,canvas.height/2-100,250,40)
                        // ctx.restore()
                        faceDotDraw.draw(positions,true)
                    } 
                        
                    else{
                        // ctx.save()
                        // ctx.scale(-1,1)
                        // ctx.translate(-canvas.width,0)
                        // ctx.drawImage(icon,canvas.width/2-125,canvas.height/2-100,250,40)
                        // ctx.restore()
                        faceDotDraw.draw(positions)
                    }

                    

                    // const eyeLength = Math.abs(positions[4].y - positions[1].y)
                    // const rightCheek = positions[425]
                    // const leftCheek = { x: positions[205].x - eyeLength, y: positions[205].y }
                    // const leftUnderEye = positions[110]

                    // const rightUnderEye = positions[252]

                    // const jaw = positions[201]

                    // // await ctx.fillRect(leftCheek.x,leftCheek.y,-eyeLength, eyeLength/2)
                    // // await ctx.fillRect(rightCheek.x,rightCheek.y,eyeLength, eyeLength/2)
                    // // await ctx.fillRect(leftUnderEye.x,leftUnderEye.y,eyeLength, eyeLength/2)
                    // // await ctx.fillRect(rightUnderEye.x,rightUnderEye.y,eyeLength, eyeLength/2)
                    // // await ctx.fillRect(jaw.x,jaw.y,eyeLength, eyeLength/2)


                    // let leftEyeSum = new getColorData(leftUnderEye, eyeLength, context)
                    // let rightEyeSum = new getColorData(rightUnderEye, eyeLength, context)

                    // let leftCheekSum = new getColorData(leftCheek, eyeLength, context)
                    // let rightCheekSum = new getColorData(rightCheek, eyeLength, context)
                    // let jawSum = new getColorData(jaw, eyeLength, context)

                    // let eyeResult = await leftEyeSum.map((i, idx) => {
                    //     return (i + rightEyeSum[idx]) / 2
                    // })

                    // let cheekResult = await leftCheekSum.map((i, idx) => {
                    //     return (i + rightCheekSum[idx]) / 2
                    // })
                    // eyeColor.push(eyeResult)
                    // cheekColor.push(cheekResult)
                    // jawColor.push(jawSum)

                    // ctx.fillStyle = `rgb(${(eyeResult[0] + cheekResult[0] + jawSum[0]) / 3},${(eyeResult[1] + cheekResult[1] + jawSum[1]) / 3},${(eyeResult[2] + cheekResult[2] + jawSum[2]) / 3})`

                    // const rgbBox = (canvas.height + canvas.width) / 2 / 4
                    // ctx.fillRect(0, 0, rgbBox, rgbBox)

                    if (cnt < 61) {
                        // document.getElementById("progressBar").style.width = cnt*2 + "%"
                        //     document.getElementById("progresspercent").innerText = cnt*2 + "%"
                        progressContainer.style.display = "inline-flex"
                        for (let i = 3; i >= 0; i--) {
                            let result = cnt * 1.65
                            let progressUnit = result.toFixed(1) - i
                            progressBar.style.width = progressUnit + "%"
                            percent.innerText = progressUnit + "%"
                            if (cnt === 60) {
                                progressBar.style.width = "100%"
                                percent.innerText = "100%"
                            }
                        }
                    }
                } else if (faceBoard == "faceboard") {
                    testExplain.innerText = "가장 얼굴이 화사해지는 필터를 확인 후 결과 확인 버튼을 눌러주세요"
                    let colorRgb = store.getState().ColorReducer.mainFaceBoardColor
                    new FaceBoard(positions, colorRgb, canvas)
                }
                else {
                    testExplain.innerText = "하단의 마스크를 선택하여 필터를 적용해보세요"
                    let mainColor = maskColor[store.getState().ColorReducer.mainMaskColor]
                    let leftMask = mainColor[0]
                    let rightMask = mainColor[1]
                    new MaskDraw(canvas, leftMask, rightMask, positions, typeArr[0], typeArr[1], typeArr[2])
                }
            } else
                testExplain.innerHTML = `얼굴을 인식할 수 있도록 카메라를 바라봐주세요.<br> <span style="color : yellow;">Tip : 최대한 빛의 영향을 받지 않는 곳에서 측정해보세요!</span>`

            rafID = requestAnimationFrame(renderPrediction);
        })

        //   stats.end();
    };

    async function main() {

        if (faceBoard != "mask") {
            headerWrapper.style.display = "none"
            headerWrapper.style.opacity = 0
        }

        // await tf.setBackend(state.backend);
        //   stats.showPanel(0);  // 0: fps, 1: ms, 2: mb, 3+: custom
        //   document.body.appendChild(stats.dom);


        testWrapper.style.opacity = 1

        video.play();
        video.style.display = "block"
        canvas.className = "faceCanvas"
        videoWidth = video.clientWidth
        canvas.width = videoWidth
        canvas.style.position = "absolute"
        canvas.style.transform = "scale(-1,1)"
        canvas.style.zIndex = " 998"
        canvas.style.left = '0'

        
        if (typeArr[2]) {
            videoHeight = 338
            canvas.height = 338
        }
        else {
            videoHeight = video.clientHeight
            canvas.height = video.clientHeight
        }

        ctx = canvas.getContext('2d');
        ctx.fillStyle = GREEN;
        ctx.strokeStyle = GREEN;
        ctx.lineWidth = 0.5;
        testWrapper.insertBefore(canvas, testWrapper.firstChild)

        const centerX = canvas.width/2
        const centerY = canvas.height/2
        faceDotDraw = new drawFaceLine(canvas)
        renderPrediction();
    };
}
