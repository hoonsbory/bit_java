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
        // var camCanvas = document.createElement("canvas")
        // camCanvas.id = "canvas"
        // camCanvas.width = video.clientWidth
        // camCanvas.height = video.clientHeight
        // camCanvas.style.zIndex = "998"
        // camCanvas.style.transform = "scale(-1,1)"
        // document.getElementById("mainCam").appendChild(camCanvas)
        // var context = camCanvas.getContext('2d');
        const displaySize = { width: video.clientWidth, height: video.clientHeight }
        faceapi.matchDimensions(canvas, displaySize)
        let cnt = 0;
        setInterval(async () => {
            const detections = await faceapi.detectSingleFace(video, new faceapi.TinyFaceDetectorOptions()).withFaceLandmarks(true) //video 캡쳐본 얼굴인식 정보  사이즈를 맞추기 전이기때문에 좌표값이 다르다
            var resizedDetections
            if (detections) {
                resizedDetections = await faceapi.resizeResults(detections, displaySize) //detections를 displaysize에 맞춘 결과값
                await canvas.getContext('2d').clearRect(0, 0, canvas.width, canvas.height) //캔버스 초기화
                await faceapi.draw.drawDetections(canvas, resizedDetections) //얼굴인식 사각형 박스 드로잉
                await faceapi.draw.drawFaceLandmarks(canvas, resizedDetections) //얼굴인식 랜드마크 드로잉
                // const landmark = await faceapi.detectFaceLandmarksTiny(canvas) //페이스랜드마크 좌표
                // console.log(landmark.positions)
                // const nose = await resizedDetections.landmarks.positions[31]
                // const leftChin = await resizedDetections.landmarks.positions[2]
                // const avgPosition = { x: (nose.x + leftChin.x) / 2, y: (nose.y + leftChin.y) / 2 }
                // // console.log(nose)

                // var ctx = canvas.getContext('2d');
                // context.drawImage(video, 0, 0, camCanvas.width, camCanvas.height);
                // var avgColor = context.getImageData(avgPosition.x, avgPosition.y, 1, 1).data
                // ctx.fillStyle = `rgb(${avgColor[0]},${avgColor[1]},${avgColor[2]})`
                // ctx.fillRect(0, 0, 100, 100)


                // var arcCan = document.createElement("canvas")
                // arcCan.width = 5
                // arcCan.height = 5
                // var arcCtx = arcCan.getContext('2d')

                // arcCtx.beginPath();
                // arcCtx.arc(2.5, 2.5, 2.5, 0, Math.PI * 2);
                // arcCtx.strokeStyle = 'rgb(255,0,0)'
                // arcCtx.stroke();
                // ctx.putImageData(arcCtx.getImageData(0, 0, arcCan.width, arcCan.height), avgPosition.x, avgPosition.y)
                // context.putImageData(arcCtx.getImageData(0, 0, arcCan.width, arcCan.height), avgPosition.x, avgPosition.y)
                // cnt++
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
            // if (cnt === 30)
            //     camCheck()
        }, 100)
    }, 100);
}