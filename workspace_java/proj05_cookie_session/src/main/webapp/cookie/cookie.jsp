<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.popup {
		border: 1px solid red;
		width : 200px;
		height: 300px;
		box-shadow : 3px 3px 3px 3px #e2e2e2;
	}
	.hide {
		display: none;
	}
</style>
<script>
	
	window.addEventListener('load', ()=>{
		
		printCookie();
		bind();
	})
	
	function printCookie(){
		console.log( document.cookie );
		// name=이용상; dinner=국밥; popup=N
		
		const cookies = document.cookie.split('; ');
		for(c of cookies) {
			// "name=이용상"
			const name = c.split("=")[0];
			const value = c.split('=')[1];
			
			console.log(`name: \${name}, value: \${value}`);
			
			if(name == "popup" && value == "N") {
				document.querySelector('.popup').classList.add('hide');
			}
			
		}
	}
	function bind(){
		document.querySelector('#noShow')
			.addEventListener('click',function(event){
			
				if(event.target.checked) {
					// 세션쿠키(만료일이 없는 쿠키)
// 					document.cookie = "popup=N";
					
					// 만료일이 있는 쿠키
					const now = new Date();
					const after10s = now.getSeconds() + 10;
					now.setSeconds(after10s);
					
					document.cookie = "popup=N;expires="+now.toGMTString();
				}			
			
		})
	}
	
</script>
</head>
<body>

	<div class='popup'>
		공지입니다<br>
		꼭 보세요<br>
		<hr>
		<input type='checkbox' id='noShow'> 10초 동안 보지 않기
	</div>

</body>
</html>