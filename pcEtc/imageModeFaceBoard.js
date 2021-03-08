import faceBoardColor from './faceBoardColor.js'
import selfMode from './selfMode.js'
import seasonResult from './seasonResult.js'

export default class imageModeFaceBoard{
    colorRgb = [
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

    constructor(positions,canvas,firstResult){
        this.positions = positions
        this.canvas = canvas
        this.firstResult = firstResult
        this.addEvent()
    }
    addEvent(){
        const faceBoardColorList = new faceBoardColor('noCamDiv')
        new selfMode(this.positions,this.colorRgb,this.canvas)

        document.getElementById("filter1").onclick = () => {
            this.colorRgb = faceBoardColorList.colorRgb1
            this.classRemove()
            new selfMode(this.positions,this.colorRgb,this.canvas)
            document.getElementById("filter1").classList.add('clicked')
        }
        document.getElementById("filter2").onclick = () => {
            this.colorRgb = faceBoardColorList.colorRgb2
            this.classRemove()
            new selfMode(this.positions,this.colorRgb,this.canvas)
            document.getElementById("filter2").classList.add('clicked')
        }
        document.getElementById("filter3").onclick = () => {
            this.colorRgb = faceBoardColorList.colorRgb3
            this.classRemove()
            new selfMode(this.positions,this.colorRgb,this.canvas)
            document.getElementById("filter3").classList.add('clicked')
        }
        document.getElementById("filter4").onclick = () => {
            this.colorRgb = faceBoardColorList.colorRgb4
            this.classRemove()
            new selfMode(this.positions,this.colorRgb,this.canvas)
            document.getElementById("filter4").classList.add('clicked')
        }
        document.getElementById("goResult").onclick = () => {
            seasonResult(this.firstResult)
        }
        var cnt =2;
        document.querySelectorAll(".select").forEach(i=>{
            i.onclick = ()=> {
                if(i.classList.contains("clicked")){
                    i.classList.remove("clicked")
                    document.querySelectorAll('.select').forEach(j=>{
                        if(i.innerText<j.innerText)
                        j.innerText = j.innerText - 1
                    })
                    i.innerText = 0
                    cnt--
                }else {
                    i.innerText = cnt
                    i.classList.add('clicked')
                    cnt++
                }
            }
        })

    
    }
    classRemove() {
        document.querySelectorAll(".btnGroup.clicked").forEach(i => {
            i.classList.remove("clicked")
        })
    }
}