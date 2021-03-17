import colorAvg from './colorAvg.js'
import streamMode from './streamMode.js'
import videoPlayEvent from './videoPlayEvent.js'
import seasonResult from './seasonResult.js'
import imageModeFaceBoard from './imageModeFaceBoard.js'

//뒤로가기고 페이지에 진입하면 새로고침되게
//엣지는 뒤로가기해도 캐시가없이 스크립트가 실행되었고, 크롬 일부버전은 persisted값이 false로만 나오는 버그가 있다고 한다. 그래서 window.performance조건을 추가해줌
if (document.addEventListener) {
    window.addEventListener('pageshow', function (event) {
        if (event.persisted || window.performance &&
            window.performance.navigation.type == 2) {
            location.reload();
        }
    },
        false);
}

let appleCheck = false;
let ua = navigator.userAgent || navigator.vendor || window.opera;
if ((navigator.appName == 'Netscape' && ua.search('Trident') != -1) || (ua.indexOf("msie") != -1)) { // IE 일 경우
    document.documentElement.classList.add('fonts-loaded');
    alert("지원하지않는 브라우저입니다. 크롬,엣지,사파리 등의 브라우저를 이용해주세요");
}

//애플 기기의 ios버전을 체크하기 위함.
let osInfo;
let realOs;
let floatOs = 0;
if ((ua.indexOf("iPhone") > -1) || (ua.indexOf("iPad") > -1) || (ua.indexOf("iPod") > -1) || (ua.indexOf("Mac") > -1)) {
    appleCheck = true;
    //인스타그램, 페이스북, 카카오 전부 OS라는 문자옆에 버전이 적혀있는데 페이스북 메신저는 OS가 없고 다른 곳에 버전이 적혀있어서 따로 구현함.
    if (ua.indexOf("FBSV") > -1) {
        osInfo = ua.split("FBSV")[1];
        realOs = osInfo.substring(1, 3) + "." + osInfo.substring(4, 5);
        floatOs = parseFloat(realOs)
    } else {
        osInfo = ua.split("OS")[1]
        realOs = osInfo.substring(1, 3) + "." + osInfo.substring(4, 5);

        //ios버전 추출해서 실수형으로.
        floatOs = parseFloat(realOs)
    }
}
function isFacebookApp() {
    return (ua.indexOf("Android") > -1 && ((ua.indexOf("FBAN") > -1) || (ua.indexOf("Instagram") > -1) || (ua.indexOf("FBAV") > -1) || (ua.indexOf("FBSV") > -1) || (ua.indexOf("FBSS") > -1) || (ua.indexOf("FBCR") > -1) || (ua.indexOf("FBID") > -1) || (ua.indexOf("FBCL") > -1) || (ua.indexOf("FBMD") > -1) || (ua.indexOf("FBDV") > -1) || (ua.indexOf("FBSN") > -1)));
};
//안드로이드 페이스북메신저에서 파일 업로드가 안된다. accept속성을 지우면 된다는 얘기가 많은데 시도해봐도 되지를 않아서 외부 브라우저를 키도록 유도함.
if (isFacebookApp()) {
    document.getElementById("popup").style.display = "block";
}

if (ua.indexOf("Mobile") > -1) {
    document.getElementById("subInfo").style.position = "relative"
    document.getElementById("subInfo").style.top = "1vh"
}


var video = document.getElementById('video');

//비디오 에러 캐치
function camErr() {
    alert("카메라가 지원되지 않는 모듈입니다. 크롬,사파리 브라우저를 이용해주세요. 업로드 방식으로 전환합니다.")
    document.getElementById("noCamDiv").style.display = "block"
    document.getElementById("fileInput").click();
    // document.getElementById("openVideoBtn").style.display = "block"
    // document.getElementById("videoSource").src = "https://s3.ap-northeast-2.amazonaws.com/jaehoon-dayoff.ml/video/퍼스널컬러홍보영상2.mp4"
}

document.getElementById("resultPopup").onclick = () => { popupConfirm('checkResult') }
document.getElementById("noticePopup").onclick = () => { popupConfirm('popup') }

//상황에따라 다른 팝업창 구분
function popupConfirm(div) {
    if (document.getElementById("checkSuccess").style.display == "block") {
        // moveRight("");
        console.log(123)
        faceBoard = true;
        console.log(uploadCheck)
        if (uploadCheck) new imageModeFaceBoard(facePositions, faceBoardCanvas, firstResult)

        else video.play()
    }
    document.getElementById(div).style.display = "none";
}



//캠화면 캡쳐 및 주요컬러 도출
function camCheck(colorSum) {

        colorSum.forEach((i, idx) => {
            colorSum[idx] = i / 30
        })
    // document.getElementById("subInfo").style.backgroundColor = `rgb(${colorSum[0]}, ${colorSum[1]}, ${colorSum[2]})`
    // var context = camCanvas.getContext('2d');
    // context.drawImage(video, 0, 0, video.clientWidth, video.clientHeight);
    firstResult = []
    colorAvg(colorSum, firstResult, labColor, colorList, stream, colorNum)
}
// document.getElementById("toneCheck").onclick = camCheck

//폰트가 로드되기전까지 투명도를 줘서 안보이게 했다가 3초이내에 로딩되면 보이게함.
//3초가 지나면 기본폰트로
setTimeout(function () {
    document.body.style.opacity = 1
}, 3000)
var font = new FontFaceObserver('HSThin');
font.load(null, 3000).then(function () {
    document.body.classList.add('fonts-loaded');
});

// document.getElementById("openVideoBtn").onclick = openVideo

// function openVideo() {
//     if (window.innerWidth < 768) {
//         if (window.innerWidth >= window.innerHeight) {
//             guideVideo.style.height = "100%"
//             guideVideo.style.width = "unset"
//         } else {
//             guideVideo.style.width = "100%"
//             guideVideo.style.height = "unset"
//         }
//     } else {
//         guideVideo.style.height = "unset"
//         guideVideo.style.width = "500px"
//     }
//     guideVideo.load()
//     document.getElementById("guideDiv").style.display = "block"
//     guideVideo.play()
//     document.getElementById("close").style.display = "block"
// }
// document.querySelectorAll(".closeVideo").forEach(i=>{
//     i.onclick = closeVideo
// })

// function closeVideo() {
//     document.getElementById("guideDiv").style.display = "none"
//     guideVideo.pause()
//     document.getElementById("close").style.display = "none"
// }



//페이스북 인앱 브라우저에서 accept속성때문에 업로드가 안되는 버그가 있어서 대응

//크롭없이 회전후 크롭할 경우  크롭을 하는 것은, 원본이미지를 캔버스에 옮겨오는 것으로 시작하는데, 크롭버튼을 누르지않고 회전부터 할 경우, 나중에 크롭할때 회전도가 달라 문제가 생긴다.
//그래서 크롭을 시작하기전에 회전을 할 경우에만 한해서 캔버스에 그리고 시작한다. 사진을 올리자마자 캔버스에 그리는 게 편하지만, 편집을 원하지 않는 경우엔 불필요한 로딩을 하는 것이라 
//따로 크롭 버튼을 넣은 것이다.

const guideVideo = document.getElementById("guideVideo") //튜토리얼 비디오


var labColor; //lab값




var stream = false; //steram 지원 유무 

var uploadCheck = false; //업로드여부 체크해


var loading = document.getElementById("loading"); //로딩


var firstResult = []; //첫 비교 결과값을 담을 변수





var colorNum
var faceBoardCanvas;
var facePositions;
var faceBoard = false;
var warmColor = [
    //봄
    { L: 93.24308501707372, A: 1.8831653918775504, B: 20.718646292445865 },
    { L: 90.52289128383626, A: 3.233666015118153, B: 28.307937546766237 },
    { L: 87.86424337552954, A: 5.039781815103062, B: 35.51057954854002 },
    { L: 84.02555434458635, A: 7.303593750393079, B: 32.35239498551059 },
    //가을
    { L: 88.01422576423417, A: 0.44469105936484343, B: 22.066594327876565 },
    { L: 85.40709355772393, A: 2.6280755544423884, B: 28.39518318891747 },
    { L: 79.77375484413481, A: 7.765231163705922, B: 31.730027579476207 },
    { L: 75.76154718068078, A: 7.23321668208865, B: 40.38007858135049 }

]
var coolColor = [
    //여름
    { L: 94.50167496851937, A: 4.139834223156058, B: 7.996009480649668 },
    { L: 92.13269969033836, A: 7.406843133354157, B: 10.332405216677664 },
    { L: 90.69511899883976, A: 8.506748645930816, B: 13.506314388479757 },
    { L: 86.45273910781171, A: 11.28147997114498, B: 17.43590092164615 },
    //겨울
    { L: 92.35725352107004, A: 3.850753074886304, B: 9.013026210042252 },
    { L: 91.2734226421461, A: 5.028273762088087, B: 11.6465909405429 },
    { L: 88.21365467347522, A: 6.757624702209474, B: 15.649915754155597 },
    { L: 84.31331292028791, A: 6.67861946731424, B: 17.951879223826882 }
]


//맨처음 색상분석을 위한 색상리스트
var colorList = [
    warmColor[0],
    warmColor[1],
    warmColor[2],
    warmColor[3],
    warmColor[4],
    warmColor[5],
    warmColor[6],
    warmColor[7],
    coolColor[0],
    coolColor[1],
    coolColor[2],
    coolColor[3],
    coolColor[4],
    coolColor[5],
    coolColor[6],
    coolColor[7],

    // { L: 54.94213801213769, A: -53.07384198363935, B: 34.43417705537093 },
    // { L: 62.18763178824342, A: -8.479405327875222, B: -46.28902249513915 },
    // { L: 20.217290355298722, A: 36.06355989320672, B: -57.05422997619636 },
    // { L: 50.41376744611719, A: 43.73719859707093, B: -77.79677741706573 },
    // { L: 99.65492223276894, A: 0.005244850979191362, B: -0.010377222171187306 },
    // { L: 0.27417592423966397, A: 0.00003730131757639921, B: -0.00007380574454374234 }
    //여기까지 톤색깔
    // [0, 152, 68],//초록
    // [0, 159, 232],//하늘색
    // [29, 32, 135],//파랑
    // [95, 100, 255],//보라
    // [254, 254, 254],//하양
    // [0, 0, 0]//검정
]




//비디오 스트리밍 모드 활성화
function streamTrue() {
    document.getElementById("mainCam").style.display = "block"
    document.getElementById("cropNotice").innerHTML = "※ 피부를 측정할 때까지 얼굴이 인식된 상태에서 기다려주세요"
    // document.getElementById("openVideoBtn").style.display = "block";
    document.getElementById("progressContainer").style.display = "inline-flex";
    modeChange();
    stream = true;
}

//AI 모듈 로드
Promise.all([
    faceapi.nets.tinyFaceDetector.loadFromUri('/models'),
    faceapi.nets.faceLandmark68TinyNet.loadFromUri('/models'),
])


document.getElementById("cameraBtn").onclick = () => { streamMode(ua, streamTrue, camErr, video) }
document.getElementById("uploadBtn").onclick = () => {
    document.getElementById("fileInput").click();
}

video.addEventListener('play', () => { videoPlayEvent(video, camCheck, faceBoard,  firstResult) })

function modeChange() {
    document.getElementById("mainbody").scrollIntoView();
    document.getElementById("subTitle").style.display = "none";
    document.getElementById("mainTitle").style.display = "none";
    document.getElementById("stepInfo").style.display = "inline-block";
    document.getElementById("cropNotice").style.display = "inline-block";
    document.getElementById("notice").style.display = "none";
    document.getElementById("notice2").style.display = "none";
    $('.image-upload-wrap').hide();
    $('#slider').show();
}
//인풋창 파일 업로드 시 
document.getElementById("fileInput").onclick = document.getElementById("fileInput").value = ""
document.getElementById("fileInput").onchange =
    function readURL(input) {
        if ((input.target.files && input.target.files[0])) {
            loading.style.display = "block"

            uploadCheck = false;


            const fileInfo = input.target.files[0];
            var reader = new FileReader();
            reader.onload = async function (e) {
                loading.style.display = 'block'
                try {


                    var input = document.getElementById("realImage")
                    input.src = e.target.result

                    const detectionsWithLandmarks = await faceapi.detectAllFaces(input, new faceapi.TinyFaceDetectorOptions()).withFaceLandmarks(true)
                    if (detectionsWithLandmarks.length === 0) {
                        loading.style.display = 'none'
                        alert('얼굴이 인식되지 않습니다. 다른 사진으로 시도해주세요.')

                    }
                    else if (detectionsWithLandmarks.length > 1) {
                        loading.style.display = 'none'
                        alert("사진 속에 얼굴이 2개 이상 인식되었습니다. 혼자 찍은 사진을 올려주세요.")
                    }
                    else {
                        document.getElementById("noCamDiv").style.display = "block"

                        $('.file-upload-image').attr('src', e.target.result);
                        modeChange();
                        uploadCheck = true
                        faceBoardCanvas = document.createElement("canvas")

                        var camCanvas = document.createElement("canvas")
                        camCanvas.className = "imageMode"
                        camCanvas.style.position = 'absolute'
                        camCanvas.style.zIndex = '998'
                        camCanvas.width = input.width
                        camCanvas.height = input.height
                        // document.getElementById("mainCam").appendChild(camCanvas)
                        var context = camCanvas.getContext('2d');
                        context.drawImage(input, 0, 0, camCanvas.width, camCanvas.height);
                        faceBoardCanvas = faceapi.createCanvasFromMedia(input)
                        faceBoardCanvas.style.position = "absolute"
                        faceBoardCanvas.className = 'imageMode'
                        document.getElementById("noCamDiv").insertBefore(faceBoardCanvas, input)
                        const displaySize = { width: input.width, height: input.height }

                        await faceapi.matchDimensions(faceBoardCanvas, displaySize)
                        const resizedDetections = await faceapi.resizeResults(detectionsWithLandmarks, displaySize)
                        facePositions = resizedDetections[0].landmarks.positions
                        await faceapi.draw.drawFaceLandmarks(faceBoardCanvas, resizedDetections)
                        var faceCtx = faceBoardCanvas.getContext('2d')

                        const nose = facePositions[31]
                        const leftChin = facePositions[2]
                        const leftCheek = { x: (nose.x + leftChin.x) / 2, y: (nose.y + leftChin.y) / 2 }
                        var sumColor = new Array(3).fill(0)
                        for(var i=0; i>-6; i--){
                            for(var j=0; j>-5; j--){
                                faceCtx.fillStyle = 'rgb(0,255,0)';
                                faceCtx.fillRect(leftCheek.x+i, leftCheek.y+j, 1, 1);
                                var data = context.getImageData(leftCheek.x+i, leftCheek.y+j, 1, 1).data
                                data.slice(0,data.length-1).forEach((i,idx)=>{
                                    sumColor[idx] += i
                                })
                            }
                        }
                        camCheck(sumColor)
                    }
                } catch (error) {
                    console.log(error)
                }
            }

            reader.readAsDataURL(fileInfo);
            loading.style.display = "none"

        }
    }

$('.image-upload-wrap').bind('dragover', function () {
    $('.image-upload-wrap').addClass('image-dropping');
});
$('.image-upload-wrap').bind('dragleave', function () {
    $('.image-upload-wrap').removeClass('image-dropping');
});
//이미지 회전.





