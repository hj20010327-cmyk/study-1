window.onload = function () {
    bind()
}

function bind() {

    const todo = document.querySelector('.todo')
    const add = document.querySelector('.add')
    const a = document.querySelector('.a')
    const removeBtn = document.querySelector('.remove')

    // 추가
    add.addEventListener('click', function () {

        if (todo.value.trim() != '') {
            a.innerHTML += `<div class="ctodo"> 
                    <input type="checkbox" class="select"> 
                    ${todo.value}
                     <input class="delete" type="button" value="삭제"></div>`
            todo.value = ''
            const select = document.querySelectorAll('.select')
            const all = document.querySelector('.all')

            for (let i = 0; i < select.length; i++) {
                select[i].checked = false
                select[i].parentElement.style.textDecoration = 'none'
            }

            if (all) {
                all.checked = false
            }
        }
    })


    // 삭제 (이제 밖에 있음)
    a.addEventListener('click', function (event) {
        if (event.target.classList.contains('delete')) {
            event.target.parentElement.remove()
        }
    })


    // 체크 처리
    a.addEventListener('change', function (event) {

        const select = document.querySelectorAll('.select')
        const all = document.querySelector('.all')

        // 전체선택
        if (event.target.classList.contains('all')) {

            for (let i = 0; i < select.length; i++) {
                select[i].checked = event.target.checked

                if (event.target.checked) {
                    select[i].parentElement.style.textDecoration = 'line-through'
                } else {
                    select[i].parentElement.style.textDecoration = 'none'
                }
            }
        }

        // 개별 체크
        if (event.target.classList.contains('select')) {

            if (event.target.checked) {
                event.target.parentElement.style.textDecoration = 'line-through'
            } else {
                event.target.parentElement.style.textDecoration = 'none'
            }

            // 전체 체크 상태 계산
            let count = 0

            for (let i = 0; i < select.length; i++) {
                if (select[i].checked) {
                    count++
                }
            }

            all.checked = (select.length > 0 && count === select.length)
        }
    })


    // 선택 삭제 (한 번만 등록)
    removeBtn.addEventListener('click', function () {

        const select = document.querySelectorAll('.select')

        for (let i = select.length - 1; i >= 0; i--) {
            if (select[i].checked) {
                select[i].parentElement.remove()
            }
        }

        const all = document.querySelector('.all')
        if (all) all.checked = false
    })
}
