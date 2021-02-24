export default function videopPlayEvent(video, camCheck) {
    if (document.getElementById("faceCanvas")) return
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
        var camCanvas = document.createElement("canvas")
        // camCanvas.id = "canvas"
        // camCanvas.width = video.clientWidth
        // camCanvas.height = video.clientHeight
        // camCanvas.style.zIndex = "998"
        // camCanvas.style.transform = "scale(-1,1)"
        // // document.getElementById("mainCam").appendChild(camCanvas)
        // var context = camCanvas.getContext('2d');
        const displaySize = { width: video.clientWidth, height: video.clientHeight }
        faceapi.matchDimensions(canvas, displaySize)
        let cnt = 0;
        var colorSum = new Array(3).fill(0)

        setInterval(async () => {
            const detections = await faceapi.detectSingleFace(video, new faceapi.TinyFaceDetectorOptions()).withFaceLandmarks(true) //video 캡쳐본 얼굴인식 정보  사이즈를 맞추기 전이기때문에 좌표값이 다르다
            var resizedDetections
            if (detections) {
                resizedDetections = await faceapi.resizeResults(detections, displaySize) //detections를 displaysize에 맞춘 결과값
                await canvas.getContext('2d').clearRect(0, 0, canvas.width, canvas.height) //캔버스 초기화
                await faceapi.draw.drawDetections(canvas, resizedDetections) //얼굴인식 사각형 박스 드로잉
                await faceapi.draw.drawFaceLandmarks(canvas, resizedDetections) //얼굴인식 랜드마크 드로잉
                // const landmark = await faceapi.detectFaceLandmarksTiny(canvas) //페이스랜드마크 좌표
                // const positions = await resizedDetections.landmarks.positions
                // const nose = positions[31]
                // const leftChin = positions[2]
                // const leftCheek = { x: (nose.x + leftChin.x) / 2, y: (nose.y + leftChin.y) / 2 }
                // // console.log(nose)
                // const leftTopEye1 = positions[37]
                // const leftBottomEye2 = positions[41]
                // const leftPupil = { x: (leftTopEye1.x + leftBottomEye2.x) / 2, y: (leftTopEye1.y + leftBottomEye2.y) / 2 }
                // const rightTopEye1 = positions[38]
                // const rightBottomEye2 = positions[40]
                // const rightPupil = { x: (rightTopEye1.x + rightBottomEye2.x) / 2, y: (rightTopEye1.y + rightBottomEye2.y) / 2 }
                // const centerPupil = { x: (leftPupil.x + rightPupil.x) / 2, y: (leftPupil.y + rightPupil.y) / 2 }
                // var ctx = canvas.getContext('2d');
                // context.drawImage(video, 0, 0, camCanvas.width, camCanvas.height);

                // var eyeAvgColor = context.getImageData(centerPupil.x, centerPupil.y, 1, 1).data
                // var cheekAvgColor = context.getImageData(leftCheek.x, leftCheek.y, 1, 1).data

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
                // eyeTextContext.scale(-1,1)
                // eyeTextContext.font = "15px"
                // eyeTextContext.fillText("오른쪽 홍채색", -70,20)
                // eyeTextContext.setTransform(1, 0, 0, 1, 0, 0);
                // ctx.putImageData(eyeTextContext.getImageData(0,0,eyeTextCanvas.width,eyeTextCanvas.height), 100,0)

                // var cheekTextCanvas = document.createElement("canvas")
                // cheekTextCanvas.width = 70
                // cheekTextCanvas.height = 25
                // var cheekTextContext = cheekTextCanvas.getContext("2d")
                // cheekTextContext.scale(-1,1)
                // cheekTextContext.font = "15px"
                // cheekTextContext.fillText("오른쪽 볼 색", -60,20)
                // cheekTextContext.setTransform(1, 0, 0, 1, 0, 0);
                // ctx.putImageData(cheekTextContext.getImageData(0,0,cheekTextCanvas.width,cheekTextCanvas.height), 100,150)


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
                // cnt++
                // colorSum.forEach((i,idx)=>{
                //     colorSum[idx] += cheekAvgColor[idx]
                // })
                //     if (cnt < 31) {
                //         for (var i = 3; i >= 0; i--) {
                //             document.getElementById("progressBar").style.width = (cnt * 3.3).toFixed(1) - i + "%"
                //             document.getElementById("progresspercent").innerText = (cnt * 3.3).toFixed(1) - i + "%"
                //             if (cnt === 30) {
                //                 document.getElementById("progressBar").style.width = "100%"
                //                 document.getElementById("progresspercent").innerText = "100%"
                //             }
                //         }
                //     }
                } else {
                await canvas.getContext('2d').clearRect(0, 0, canvas.width, canvas.height)
            }
            // if (cnt === 30){
            //     camCheck(camCanvas,colorSum)
            // }
        }, 17)
    }, 100);
}