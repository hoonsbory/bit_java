import { throttling } from './throttle.js'

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
    //     canvas.style.position = "absolute"
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

    // var btn = document.createElement('button')
    // btn.onclick = () => { drawColorCanvas(1) }
    // btn.innerText = '컬러 1'
    // document.body.insertBefore(btn, document.body.firstElementChild)
    // var btn2 = document.createElement('button')
    // btn2.onclick = () => { drawColorCanvas(2) }
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

    setTimeout(() => {
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
                await faceapi.draw.drawDetections(canvas, resizedDetections) //얼굴인식 사각형 박스 드로잉
                await faceapi.draw.drawFaceLandmarks(canvas, resizedDetections) //얼굴인식 랜드마크 드로잉
                // const landmark = await faceapi.detectFaceLandmarksTiny(canvas) //페이스랜드마크 좌표
                const positions = await resizedDetections.landmarks.positions
                const nose = positions[31]
                const leftChin = positions[2]
                const leftCheek = { x: (nose.x + leftChin.x) / 2, y: (nose.y + leftChin.y) / 2 }
                // console.log(nose)
                const leftTopEye1 = positions[37]
                const leftBottomEye2 = positions[41]
                const leftPupil = { x: (leftTopEye1.x + leftBottomEye2.x) / 2, y: (leftTopEye1.y + leftBottomEye2.y) / 2 }
                const rightTopEye1 = positions[38]
                const rightBottomEye2 = positions[40]
                const rightPupil = { x: (rightTopEye1.x + rightBottomEye2.x) / 2, y: (rightTopEye1.y + rightBottomEye2.y) / 2 }
                const centerPupil = { x: (leftPupil.x + rightPupil.x) / 2, y: (leftPupil.y + rightPupil.y) / 2 }
                context.drawImage(video, 0, 0, camCanvas.width, camCanvas.height);
                // drawColorCanvas(positions[0],positions[17], "rgb(200,0,0")
                // drawColorCanvas(positions[17],positions[18],"rgb(255,0,0)")
                var eyeAvgColor = context.getImageData(centerPupil.x, centerPupil.y, 1, 1).data
                var cheekAvgColor = context.getImageData(leftCheek.x, leftCheek.y, 1, 1).data

                // ctx.fillStyle = `rgb(${eyeAvgColor[0]},${eyeAvgColor[1]},${eyeAvgColor[2]})`

                // ctx.fillRect(0, 0, 100, 100)

                // ctx.fillStyle = `rgb(${cheekAvgColor[0]},${cheekAvgColor[1]},${cheekAvgColor[2]})`

                // ctx.fillRect(0, 150, 100, 100)
                // // ctx.font = "20px serif"
                // // ctx.strokeText("hello world", 0,20)

                // var eyeTextCanvas = document.createElement("canvas")
                // eyeTextCanvas.width = 100
                // eyeTextCanvas.height = 25
                // var eyeTextContext = eyeTextCanvas.getContext("2d")
                // eyeTextContext.scale(-1, 1)
                // eyeTextContext.font = "15px"
                // eyeTextContext.fillText("오른쪽 홍채색", -70, 20)
                // eyeTextContext.setTransform(1, 0, 0, 1, 0, 0);
                // ctx.putImageData(eyeTextContext.getImageData(0, 0, eyeTextCanvas.width, eyeTextCanvas.height), 100, 0)

                // var cheekTextCanvas = document.createElement("canvas")
                // cheekTextCanvas.width = 70
                // cheekTextCanvas.height = 25
                // var cheekTextContext = cheekTextCanvas.getContext("2d")
                // cheekTextContext.scale(-1, 1)
                // cheekTextContext.font = "15px"
                // cheekTextContext.fillText("오른쪽 볼 색", -60, 20)
                // cheekTextContext.setTransform(1, 0, 0, 1, 0, 0);
                // ctx.putImageData(cheekTextContext.getImageData(0, 0, cheekTextCanvas.width, cheekTextCanvas.height), 100, 150)


                // var eyePointArc = document.createElement("canvas")
                // var eyePointArcCtx = eyePointArc.getContext('2d')
                // eyePointArc.width = 3
                // eyePointArc.height = 3
                // eyePointArcCtx.beginPath();
                // eyePointArcCtx.arc(1.5, 1.5, 1.5, 0, 2 * Math.PI);
                // eyePointArcCtx.fillStyle = 'rgb(255,0,0)'
                // eyePointArcCtx.fill();
                // ctx.putImageData(eyePointArcCtx.getImageData(0, 0, eyePointArc.width, eyePointArc.height), centerPupil.x, centerPupil.y)

                // var cheekPointArc = document.createElement("canvas")
                // cheekPointArc.width = 3
                // cheekPointArc.height = 3
                // var cheekPointArcCtx = cheekPointArc.getContext('2d')
                // cheekPointArcCtx.beginPath();
                // cheekPointArcCtx.arc(1.5, 1.5, 1.5, 0, Math.PI * 2);
                // cheekPointArcCtx.fillStyle = 'rgb(255,0,0)'
                // cheekPointArcCtx.fill();
                // ctx.putImageData(cheekPointArcCtx.getImageData(0, 0, cheekPointArc.width, cheekPointArc.height), leftCheek.x, leftCheek.y)
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

// function drawColorCanvas(position,position2,color) {
//     var colorCanvas = document.getElementById("colorCanvas")
//     var colorCtx = colorCanvas.getContext('2d')
//     colorCtx.clearRect(0, 0, colorCanvas.width, colorCanvas.height)
//     var video = document.getElementById("video")
//     colorCanvas.width = video.clientWidth
//     colorCanvas.height = video.clientHeight
//     colorCanvas.style.position = "absolute"
//     colorCanvas.style.zIndex = "999"
//     colorCanvas.style.transform = "scale(-1,1)"
//     var unit = colorCanvas.width/6
//     var startPos = {x : unit/2, y : 0}
//     for(var i=0; i<20; i++){
//         if(startPos.y==0) topDraw(colorCtx)
//         if(startPos.y==0&&startPos.x+unit>colorCanvas.width) rightTopDraw(colorCtx)
//         if(startPos.x==colorCanvas.width) rightDraw(colorCtx)
//         if(startPos.x==colorCanvas.width&&startPos.y+unit>colorCanvas.height) rightBottomDraw(colorCtx)
    
//     }
// function topDraw(ctx,position,position2){
//     colorCtx.beginPath()
//     colorCtx.moveTo(position.x,position.y)
//     colorCtx.lineTo(startPos.x,0)
//     startPos.x += unit
//     colorCtx.lineTo(startPos.x,0)
//     colorCtx.lineTo(position2.x,position2.y)
//     colorCtx.bezierCurveTo((position.x+position2.x)/2,position2.y,position.x,(position.y+position2.y)/2,position.x,position.y)
//     // colorCtx.lineWidth = 100;
//     // colorCtx.strokeStyle = 'rgb(255,0,0)'
//     // colorCtx.stroke()
//     colorCtx.fillStyle = color
//     colorCtx.fill()
// }
// function bottomDraw(ctx){
//     colorCtx.beginPath()
//     colorCtx.moveTo(position.x,position.y)
//     colorCtx.lineTo(startPos.x,startPos.y)
//     colorCtx.lineTo(50,0)
//     colorCtx.lineTo(position2.x,position2.y)
//     colorCtx.bezierCurveTo((position.x+position2.x)/2,position2.y,position.x,(position.y+position2.y)/2,position.x,position.y)
//     // colorCtx.lineWidth = 100;
//     // colorCtx.strokeStyle = 'rgb(255,0,0)'
//     // colorCtx.stroke()
//     colorCtx.fillStyle = color
//     colorCtx.fill()
// }
// function leftDraw(ctx){
//     colorCtx.beginPath()
//     colorCtx.moveTo(position.x,position.y)
//     colorCtx.lineTo(startPos.x,startPos.y)
//     colorCtx.lineTo(50,0)
//     colorCtx.lineTo(position2.x,position2.y)
//     colorCtx.bezierCurveTo((position.x+position2.x)/2,position2.y,position.x,(position.y+position2.y)/2,position.x,position.y)
//     // colorCtx.lineWidth = 100;
//     // colorCtx.strokeStyle = 'rgb(255,0,0)'
//     // colorCtx.stroke()
//     colorCtx.fillStyle = color
//     colorCtx.fill()
// }
// function rightDraw(ctx){
//     colorCtx.beginPath()
//     colorCtx.moveTo(position.x,position.y)
//     colorCtx.lineTo(startPos.x,startPos.y)
//     startPos.y += unit
//     colorCtx.lineTo(startPos.x,startPos.y)
//     colorCtx.lineTo(position2.x,position2.y)
//     colorCtx.bezierCurveTo((position.x+position2.x)/2,position2.y,position.x,(position.y+position2.y)/2,position.x,position.y)
//     // colorCtx.lineWidth = 100;
//     // colorCtx.strokeStyle = 'rgb(255,0,0)'
//     // colorCtx.stroke()
//     colorCtx.fillStyle = color
//     colorCtx.fill()
// }
// function leftTopDraw(ctx){
//     colorCtx.beginPath()
//     colorCtx.moveTo(position.x,position.y)
//     colorCtx.lineTo(startPos.x,startPos.y)
//     colorCtx.lineTo(50,0)
//     colorCtx.lineTo(position2.x,position2.y)
//     colorCtx.bezierCurveTo((position.x+position2.x)/2,position2.y,position.x,(position.y+position2.y)/2,position.x,position.y)
//     // colorCtx.lineWidth = 100;
//     // colorCtx.strokeStyle = 'rgb(255,0,0)'
//     // colorCtx.stroke()
//     colorCtx.fillStyle = color
//     colorCtx.fill()
// }
// function rightTopDraw(ctx){
//     colorCtx.beginPath()
//     colorCtx.moveTo(position.x,position.y)
//     colorCtx.lineTo(startPos.x,0)
//     startPos.x = colorCanvas.width
//     startPos.y = unit/2
//     colorCtx.lineTo(startPos.x,startPos.y)
//     colorCtx.lineTo(position2.x,position2.y)
//     colorCtx.bezierCurveTo((position.x+position2.x)/2,position2.y,position.x,(position.y+position2.y)/2,position.x,position.y)
//     // colorCtx.lineWidth = 100;
//     // colorCtx.strokeStyle = 'rgb(255,0,0)'
//     // colorCtx.stroke()
//     colorCtx.fillStyle = color
//     colorCtx.fill()
// }
// function leftBottomDraw(ctx){
//     colorCtx.beginPath()
//     colorCtx.moveTo(position.x,position.y)
//     colorCtx.lineTo(startPos.x,startPos.y)
//     colorCtx.lineTo(50,0)
//     colorCtx.lineTo(position2.x,position2.y)
//     colorCtx.bezierCurveTo((position.x+position2.x)/2,position2.y,position.x,(position.y+position2.y)/2,position.x,position.y)
//     // colorCtx.lineWidth = 100;
//     // colorCtx.strokeStyle = 'rgb(255,0,0)'
//     // colorCtx.stroke()
//     colorCtx.fillStyle = color
//     colorCtx.fill()
// }
// function rightBottomDraw(ctx){
//     colorCtx.beginPath()
//     colorCtx.moveTo(position.x,position.y)
//     colorCtx.lineTo(startPos.x,startPos.y)
//     colorCtx.lineTo(50,0)
//     colorCtx.lineTo(position2.x,position2.y)
//     colorCtx.bezierCurveTo((position.x+position2.x)/2,position2.y,position.x,(position.y+position2.y)/2,position.x,position.y)
//     // colorCtx.lineWidth = 100;
//     // colorCtx.strokeStyle = 'rgb(255,0,0)'
//     // colorCtx.stroke()
//     colorCtx.fillStyle = color
//     colorCtx.fill()
// }
//     // var img = new Image()
//     // img.src = `./pcImages/color${num}.png`

//     // img.onload = () => {

//     //     var colorCanvas = document.getElementById("colorCanvas")
//     //     var colorCtx = colorCanvas.getContext('2d')
//     //     colorCtx.clearRect(0,0,colorCanvas.width,colorCanvas.height)

//     //     var video = document.getElementById("video")
//     //     colorCanvas.width = video.clientWidth
//     //     colorCanvas.height = video.clientHeight
//     //     colorCanvas.style.position = "absolute"
//     //     colorCanvas.style.zIndex = "999"
//     //     // colorCanvas.style.transform = "scale(-1,1)"
//     //     colorCtx.beginPath()

//     //     // colorCtx.drawImage(img,0,0,video.clientWidth,video.clientHeight)
//     //     // var imgData = colorCtx.getImageData(0,0,colorCanvas.width,colorCanvas.height)
//     //     // ctx.putImageData(imgData,0,0)
//     // }
// }