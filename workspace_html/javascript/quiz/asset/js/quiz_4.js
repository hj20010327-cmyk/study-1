window.onload = function () {
    bind()
}
function bind(){
    const menu = document.querySelector('#id')
    const best = document.querySelector('.best')
    const low = document.querySelector('.low')
    const high = document.querySelector('.high')
    const n = document.querySelector('.new')

    best.addEventListener('click',function(){
        best.style.fontSize = 'bold'
    })


}