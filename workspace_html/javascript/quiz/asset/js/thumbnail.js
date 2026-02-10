window.onload = function () {
    bind()
}
function bind() {
    const pretty = document.querySelector('#pretty')
    const karina = document.querySelector('#karina')
    const yujin = document.querySelector('#yujin')
    const ihyun = document.querySelector('#ihyun')
    const copy = document.querySelector('#copy')

    pretty.addEventListener('mouseover', function (event) {
        if (event.target == karina) {
            copy.setAttribute('src', karina.getAttribute('src'))
        } else if (event.target == yujin) {
            copy.setAttribute('src', yujin.getAttribute('src'))
        } else if (event.target == ihyun) {
            copy.setAttribute('src', ihyun.getAttribute('src'))
        }

    })


}