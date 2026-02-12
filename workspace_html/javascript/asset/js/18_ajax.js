window.addEventListener('load', bind)
function bind() {
    const btn1 = document.querySelector('#btn1')
    btn1.addEventListener('click', function () {

        // ajax 객체 생성
        const xhr = new XMLHttpRequest();

        // 보낼 준비
        // 방식method, 주소
        xhr.open('get', 'https://jsonplaceholder.typicode.com/users')

        // 보내기
        xhr.send()
        console.log(0, xhr.responseText)

        xhr.onload = function () {
            console.log('다녀왔소')
            console.log(xhr.responseText)
            const par = JSON.parse(xhr.responseText)
            console.log(par[1].name)
            console.log(par[2].address.geo.lat)
        }

        // 깜짝 퀴즈
        // 두번째 사람의 이름을 출력한다
        // 세번째 사람의 lat를 출력한다



    })
    document.querySelector('#btn2').addEventListener('click', () => {
        const xhr = new XMLHttpRequest();

        xhr.open('get', '17_json.html')

        // 보내기
        xhr.send()

        xhr.onload = function () {
            console.log(xhr.responseText)
        }
    })
    document.querySelector('#btn3').addEventListener('click', () => {

        const xhr = new XMLHttpRequest();

        const key = 'e3dc8bb94d48ad409b382b5bd6666e809d3a1fe63372247c681de8f5b2ba8d6e'
        let url = 'http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtFcst'
        url += '?serviceKey=' + key
        url += '&numOfRows=1000'
        url += '&pageNo=1'
        url += '&dataType=JSON'
        url += '&base_date=20260212'
        url += '&base_time=1300'
        url += '&nx=63'
        url += '&ny=110'

        xhr.open('get', url)
        xhr.send()

        xhr.onload = function () {
            // console.log(xhr.responseText)
            const data = JSON.parse(xhr.responseText)
            console.log(data)
            const result = data.response.body.items.item
            console.log(result[0].category)
            console.log(result[0].fcstValue)

            // 이렇게도 해보자
            let json = {}



            for (let i = 0; i < result.length; i++) {
                if (result[i].category == 'T1H') {
                    console.log(result[i])

                    document.querySelector('#temp').innerHTML += `
                        <tr>
                            <td>${result[i].fcstTime}</td>
                            <td>${result[i].fcstValue}</td>
                        </tr>
                    `
                    if (!json[result[i].fcstTime]) {
                        json[result[i].fcstTime] = {}
                    }
                    json[result[i].fcstTime][result[i].category] = result[i].fcstValue
                }
                if (result[i].category == 'RN1') {
                    console.log(result[i])
                    if (!json[result[i].fcstTime]) {
                        json[result[i].fcstTime] = {}
                    }
                    json[result[i].fcstTime][result[i].category] = result[i].fcstValue
                }
                if (result[i].category == 'REH') {
                    console.log(result[i])

                    if (!json[result[i].fcstTime]) {
                        json[result[i].fcstTime] = {}
                    }
                    json[result[i].fcstTime][result[i].category] = result[i].fcstValue
                }

            }

            console.log(json)


        }
    })

    const btn4 = document.querySelector('#btn4')
    btn4.addEventListener('click', function () {

        // const xhr = new XMLHttpRequest();
        // xhr.open('get', 'https://jsonplaceholder.typicode.com/users')
        // xhr.send()
        // xhr.onload = function () {
        //     console.log(xhr.responseText)
        // }

        const url = 'https://jsonplaceholder.typicode.com/users'
        const option = {
            method: 'get'
        }
        fetch(url, option).then(function (response) {
            return response.json()
        }).then(function (json) {
            console.log(json)
        }).catch(function (error) {
            console.error(error)
        })
    })
    const btn5 = document.querySelector('#btn5')
    btn5.addEventListener('click', function () {

        const xhr = new XMLHttpRequest();
        xhr.open('get', 'https://jsonplaceholder.typicode.com/users')
        xhr.send()
        xhr.onreadystatechange = function () {
            console.log(xhr.readyState)
            if (xhr.readyState == 4) {
                // if(xhr.readyState == XMLHttpRequest.DONE){
                console.log('다녀왔어')
            }
        }



    })
}