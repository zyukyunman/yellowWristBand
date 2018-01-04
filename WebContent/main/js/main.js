        var img_container = document.getElementsByClassName('img_container')[0];
        var button_click = document.getElementsByClassName('button_click')[0]
        var right_text = document.getElementsByClassName('right_text')[0]   
        var left_text = document.getElementsByClassName('left_text')[0] 
        var click_slide = document.getElementById('click_slide')
            window.onload = function(){
                img_container.style.height = window.innerHeight + 'px'
            }
            window.onresize = function(){
                img_container.style.height = window.innerHeight + 'px'
            }
            window.onscroll= function(){
                if (window.scrollY >=60){
                    img_container.classList.add('transform')
//                    left_text.classList.add('in_left')
//                    right_text.classList.add('in_right')
                    img_container.classList.add('trans')
                    button_click.style.display ='none'
                }
                else{
                    img_container.classList.remove('transform')
//                    left_text.classList.remove('in_left')
//                    right_text.classList.remove('in_right')
                     img_container.classList.remove('trans')
                     button_click.style.display ='block'
                }
            }
             button_click.onclick = function(){
            	 window.scrollTo(0,60)
//                 img_container.classList.add('transform')
//                 left_text.classList.add('in_left')
//                 right_text.classList.add('in_right')
//                 img_container.classList.add('trans')
                 button_click.style.display ='none'
             }
            click_slide.onclick= function(){
                slide()
            }
function slide(){
    var timer = setInterval(function(){
        window.scrollTo(0,window.scrollY-15)
        console.log(window.scrollY)
        if (window.scrollY <= 80){
            clearInterval(timer)
        }
    },1)
}