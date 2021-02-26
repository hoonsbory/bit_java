import { throttling } from './throttle.js'
import selfMode from './selfMode.js'

const throttler = throttling()
export default async function videopPlayEvent(video, camCheck) {
    if (document.getElementById("faceCanvas")) return
    // const model = await faceLandmarksDetection.load(
    //     faceLandmarksDetection.SupportedPackages.mediapipeFacemesh);



    //     /*
    //     `predictions` is an array of objects describing each detected face, for example:

    //     [
    //       {
    //         faceInViewConfidence: 1, // The probability of a face being present.
    //         boundingBox: { // The bounding box surrounding the face.
    //           topLeft: [232.28, 145.26],
    //           bottomRight: [449.75, 308.36],
    //         },
    //         mesh: [ // The 3D coordinates of each facial landmark.
    //           [92.07, 119.49, -17.54],
    //           [91.97, 102.52, -30.54],
    //           ...
    //         ],
    //         scaledMesh: [ // The 3D coordinates of each facial landmark, normalized.
    //           [322.32, 297.58, -17.54],
    //           [322.18, 263.95, -30.54]
    //         ],
    //         annotations: { // Semantic groupings of the `scaledMesh` coordinates.
    //           silhouette: [
    //             [326.19, 124.72, -3.82],
    //             [351.06, 126.30, -3.00],
    //             ...
    //           ],
    //           ...
    //         }
    //       }
    //     ]
    //     */
    //    var canvas = document.createElement('canvas')
    //     canvas.style.position[i] = "absolute"
    //     canvas.style.zIndex = "998"
    //     canvas.style.transform = "scale(-1,1)"
    //     canvas.width = video.videoWidth
    //     canvas.height = video.videoHeight
    //     canvas.id = "faceCanvas"
    //     document.getElementById("mainCam").insertBefore(canvas, video)
    //     var ctx = canvas.getContext('2d')
    //     setInterval(async() => {
    //         const predictions = await model.estimateFaces({
    //             input: video
    //           });
    //           if(predictions.length >0){
    //         ctx.clearRect(0, 0, canvas.width, canvas.height)
    //         for (let i = 0; i < predictions.length; i++) {
    //             const keypoints = predictions[i].scaledMesh;

    //             // Log facial keypoints.
    //             for (let i = 0; i < keypoints.length; i++) {
    //                 if(i==1||i==2||i==3||i==4||i==5||i==6||i==7||i==8||i==9||i==10||i==11){
    //                   const [x, y, z] = keypoints[i];
    //                   ctx.fillStyle = 'rgb(0,0,0)'
    //                   ctx.fillRect(x,y,3,3)
    //                 //   ctx.font = '10px'
    //                 //   ctx.scale(-1,1)
    //                 //   ctx.fillText(i+1,x,y)
    //                 }
    //             }
    //           }
    //         }else{
    //             ctx.clearRect(0, 0, canvas.width, canvas.height)
    //         }
    //     }, 100);
    const colorRgb1 = [
        'rgb(137,81,0)',
        'rgb(235,163,0)',
        'rgb(208,136,0)',
        'rgb(232,202,0)',
        'rgb(195,79,0)',
        'rgb(158,200,0)',
        'rgb(223,204,0)',
        'rgb(63,168,0)',
        'rgb(220,129,0)',
        'rgb(219,86,0)',
        'rgb(217,131,0)',
        'rgb(208,101,0)',
        'rgb(215,119,0)',
        'rgb(212,36,0)',
        'rgb(49,160,0)',
        'rgb(215,193,0)',
        'rgb(187,195,0)',
        'rgb(225,44,0)',
        'rgb(53,169,0)',
        'rgb(230,96,0)',
    ]
    const colorRgb2 = [
        'rgb(137,81,105)',
        'rgb(235,163,175)',
        'rgb(208,136,156)',
        'rgb(232,202,116)',
        'rgb(195,79,98)',
        'rgb(158,200,126)',
        'rgb(223,204,161)',
        'rgb(63,168,127)',
        'rgb(220,129,180)',
        'rgb(219,86,117)',
        'rgb(217,131,140)',
        'rgb(208,101,96)',
        'rgb(215,119,71)',
        'rgb(212,36,71)',
        'rgb(49,160,183)',
        'rgb(215,193,143)',
        'rgb(187,195,73)',
        'rgb(225,44,115)',
        'rgb(53,169,184)',
        'rgb(230,96,107)',
    ]
    var colorRgb = [
        'rgb(137,81,105)',
        'rgb(235,163,175)',
        'rgb(208,136,156)',
        'rgb(232,202,116)',
        'rgb(195,79,98)',
        'rgb(158,200,126)',
        'rgb(223,204,161)',
        'rgb(63,168,127)',
        'rgb(220,129,180)',
        'rgb(219,86,117)',
        'rgb(217,131,140)',
        'rgb(208,101,96)',
        'rgb(215,119,71)',
        'rgb(212,36,71)',
        'rgb(49,160,183)',
        'rgb(215,193,143)',
        'rgb(187,195,73)',
        'rgb(225,44,115)',
        'rgb(53,169,184)',
        'rgb(230,96,107)',
    ]
    // var btn = document.createElement('button')
    // btn.onclick = () => {
    //     colorRgb = colorRgb1
    // }

    // btn.innerText = '컬러 1'
    // document.body.insertBefore(btn, document.body.firstElementChild)
    // var btn2 = document.createElement('button')
    // btn2.onclick = () => {
    //     colorRgb = colorRgb2
    // }
    // btn2.innerText = '컬러 2'
    // document.body.insertBefore(btn2, document.body.firstElementChild)
    // var btn3 = document.createElement('button')
    // btn3.onclick = () => { drawColorCanvas(3) }
    // btn3.innerText = '컬러 3.'
    // document.body.insertBefore(btn3, document.body.firstElementChild)
    // var btn4 = document.createElement('button')
    // btn4.onclick = () => { drawColorCanvas(4) }
    // btn4.innerText = '컬러 4'
    // document.body.insertBefore(btn4, document.body.firstElementChild)

    setTimeout(async () => {
        var canvas
        try {
            canvas = faceapi.createCanvasFromMedia(video)

        } catch (error) {
            video.pause();
            video.play();
        }
        canvas.style.position = "absolute"
        canvas.style.zIndex = "998"
        canvas.style.transform = "scale(-1,1)"
        canvas.id = "faceCanvas"
        document.getElementById("mainCam").insertBefore(canvas, video)
        var ctx = canvas.getContext('2d');

        var camCanvas = document.createElement("canvas")
        camCanvas.id = "canvas"
        camCanvas.width = video.clientWidth
        camCanvas.height = video.clientHeight
        camCanvas.style.zIndex = "998"
        camCanvas.style.transform = "scale(-1,1)"
        // document.getElementById("mainCam").appendChild(camCanvas)
        var context = camCanvas.getContext('2d');
        const displaySize = { width: video.clientWidth, height: video.clientHeight }
        faceapi.matchDimensions(canvas, displaySize)
        let cnt = 0;
        var colorSum = new Array(3).fill(0)

        var interval = setInterval(async () => {
            const detections = await faceapi.detectSingleFace(video, new faceapi.TinyFaceDetectorOptions()).withFaceLandmarks(true) //video 캡쳐본 얼굴인식 정보  사이즈를 맞추기 전이기때문에 좌표값이 다르다
            var resizedDetections
            if (detections) {
                resizedDetections = await faceapi.resizeResults(detections, displaySize) //detections를 displaysize에 맞춘 결과값
                await ctx.clearRect(0, 0, canvas.width, canvas.height) //캔버스 초기화
                // await faceapi.draw.drawDetections(canvas, resizedDetections) //얼굴인식 사각형 박스 드로잉
                await faceapi.draw.drawFaceLandmarks(canvas, resizedDetections) //얼굴인식 랜드마크 드로잉
                // const landmark = await faceapi.detectFaceLandmarksTiny(canvas) //페이스랜드마크 좌표
                const positions = await resizedDetections.landmarks.positions
                const nose = positions[31]
                const leftChin = positions[2]
                const faceLength = positions[6].y - positions[19].y
                const leftCheek = { x: (nose.x + leftChin.x) / 2, y: (nose.y + leftChin.y) / 2 }
                // console.log(nose)
                const colorposition = [
                    { x: positions[17].x - faceLength / 24, y: positions[17].y - faceLength / 6 },
                    { x: positions[19].x, y: positions[19].y - faceLength / 4 },
                    { x: positions[21].x, y: positions[21].y - faceLength / 3 },
                    { x: positions[22].x, y: positions[22].y - faceLength / 3 },
                    { x: positions[24].x, y: positions[24].y - faceLength / 4 },
                    { x: positions[26].x + faceLength / 24, y: positions[26].y - faceLength / 6 },
                    positions[16],
                    positions[15],
                    positions[14],
                    positions[13],
                    positions[12],
                    positions[11],
                    positions[9],
                    positions[7],
                    positions[5],
                    positions[4],
                    positions[3],
                    positions[2],
                    positions[1],
                    positions[0],
                    { x: positions[17].x - faceLength / 24, y: positions[17].y - faceLength / 6 },
                ]
                // var colorRgb = [
                //     'rgb(137,81,105)',
                //     'rgb(235,163,175)',
                //     'rgb(208,136,156)',
                //     'rgb(232,202,116)',
                //     'rgb(195,79,98)',
                //     'rgb(158,200,126)',
                //     'rgb(223,204,161)',
                //     'rgb(63,168,127)',
                //     'rgb(220,129,180)',
                //     'rgb(219,86,117)',
                //     'rgb(217,131,140)',
                //     'rgb(208,101,96)',
                //     'rgb(215,119,71)',
                //     'rgb(212,36,71)',
                //     'rgb(49,160,183)',
                //     'rgb(215,193,143)',
                //     'rgb(187,195,73)',
                //     'rgb(225,44,115)',
                //     'rgb(53,169,184)',
                //     'rgb(230,96,107)',
                // ]

                const leftTopEye1 = positions[37]
                const leftBottomEye2 = positions[41]
                const leftPupil = { x: (leftTopEye1.x + leftBottomEye2.x) / 2, y: (leftTopEye1.y + leftBottomEye2.y) / 2 }
                const rightTopEye1 = positions[38]
                const rightBottomEye2 = positions[40]
                const rightPupil = { x: (rightTopEye1.x + rightBottomEye2.x) / 2, y: (rightTopEye1.y + rightBottomEye2.y) / 2 }
                const centerPupil = { x: (leftPupil.x + rightPupil.x) / 2, y: (leftPupil.y + rightPupil.y) / 2 }
                context.drawImage(video, 0, 0, camCanvas.width, camCanvas.height);
                // new selfMode(colorposition, colorRgb, canvas)
                var eyeAvgColor = context.getImageData(centerPupil.x, centerPupil.y, 1, 1).data
                var cheekAvgColor = context.getImageData(leftCheek.x, leftCheek.y, 1, 1).data

                ctx.fillStyle = `rgb(${eyeAvgColor[0]},${eyeAvgColor[1]},${eyeAvgColor[2]})`

                ctx.fillRect(0, 0, 100, 100)

                ctx.fillStyle = `rgb(${cheekAvgColor[0]},${cheekAvgColor[1]},${cheekAvgColor[2]})`

                ctx.fillRect(0, 150, 100, 100)
                // ctx.font = "20px serif"
                // ctx.strokeText("hello world", 0,20)

                var eyeTextCanvas = document.createElement("canvas")
                eyeTextCanvas.width = 100
                eyeTextCanvas.height = 25
                var eyeTextContext = eyeTextCanvas.getContext("2d")
                eyeTextContext.scale(-1, 1)
                eyeTextContext.font = "15px"
                eyeTextContext.fillText("오른쪽 홍채색", -70, 20)
                eyeTextContext.setTransform(1, 0, 0, 1, 0, 0);
                ctx.putImageData(eyeTextContext.getImageData(0, 0, eyeTextCanvas.width, eyeTextCanvas.height), 100, 0)

                var cheekTextCanvas = document.createElement("canvas")
                cheekTextCanvas.width = 70
                cheekTextCanvas.height = 25
                var cheekTextContext = cheekTextCanvas.getContext("2d")
                cheekTextContext.scale(-1, 1)
                cheekTextContext.font = "15px"
                cheekTextContext.fillText("오른쪽 볼 색", -60, 20)
                cheekTextContext.setTransform(1, 0, 0, 1, 0, 0);
                ctx.putImageData(cheekTextContext.getImageData(0, 0, cheekTextCanvas.width, cheekTextCanvas.height), 100, 150)


                var eyePointArc = document.createElement("canvas")
                var eyePointArcCtx = eyePointArc.getContext('2d')
                eyePointArc.width = 3
                eyePointArc.height = 3
                eyePointArcCtx.beginPath();
                eyePointArcCtx.arc(1.5, 1.5, 1.5, 0, 2 * Math.PI);
                eyePointArcCtx.fillStyle = 'rgb(255,0,0)'
                eyePointArcCtx.fill();
                ctx.putImageData(eyePointArcCtx.getImageData(0, 0, eyePointArc.width, eyePointArc.height), centerPupil.x, centerPupil.y)

                var cheekPointArc = document.createElement("canvas")
                cheekPointArc.width = 3
                cheekPointArc.height = 3
                var cheekPointArcCtx = cheekPointArc.getContext('2d')
                cheekPointArcCtx.beginPath();
                cheekPointArcCtx.arc(1.5, 1.5, 1.5, 0, Math.PI * 2);
                cheekPointArcCtx.fillStyle = 'rgb(255,0,0)'
                cheekPointArcCtx.fill();
                ctx.putImageData(cheekPointArcCtx.getImageData(0, 0, cheekPointArc.width, cheekPointArc.height), leftCheek.x, leftCheek.y)
                cnt++








                colorSum.forEach((i, idx) => {
                    colorSum[idx] += cheekAvgColor[idx]
                })
                if (cnt < 31) {
                    // document.getElementById("progressBar").style.width = cnt*2 + "%"
                    //     document.getElementById("progresspercent").innerText = cnt*2 + "%"
                    for (var i = 3; i >= 0; i--) {
                        document.getElementById("progressBar").style.width = (cnt * 3.3).toFixed(1) - i + "%"
                        document.getElementById("progresspercent").innerText = (cnt * 3.3).toFixed(1) - i + "%"
                        if (cnt === 30) {
                            document.getElementById("progressBar").style.width = "100%"
                            document.getElementById("progresspercent").innerText = "100%"
                        }
                    }
                }
            } else {
                await ctx.clearRect(0, 0, canvas.width, canvas.height)
            }
            if (cnt === 30){
                clearInterval(interval)
                throttler.throttle(()=>{
                    camCheck(camCanvas,colorSum)
                },500)
            }
        }, 100)
    }, 100);
}

