window.onload = function () {
    bind()
}
function bind() {
    const menu = document.querySelector('#menu')
    const best = document.querySelector('.best')
    const low = document.querySelector('.low')
    const high = document.querySelector('.high')
    const n = document.querySelector('.new')

    menu.addEventListener('click', function (event) {
        // if(best.value)
        // best.style.fontSize = 'bold'
        if(event.target == best){
            low.style.fontWeight = ''
            high.style.fontWeight = ''
            n.style.fontWeight = ''
            best.style.fontWeight = 'bold'
        } else if(event.target == low) {
            best.style.fontWeight = ''
            high.style.fontWeight = ''
            n.style.fontWeight = ''
            low.style.fontWeight = 'bold'
        } else if(event.target == high){
            best.style.fontWeight = ''
            low.style.fontWeight = ''
            n.style.fontWeight = ''
            high.style.fontWeight = 'bold'
        } else if(event.target == n){
            best.style.fontWeight = ''
            low.style.fontWeight = ''
            high.style.fontWeight = ''
            n.style.fontWeight = 'bold'
        }
    })


}