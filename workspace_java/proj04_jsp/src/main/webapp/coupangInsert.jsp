<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="/proj04_jsp/coupang/control?cmd=insert">
	<input type="text" name="product_name" placeholder="상품명"><br>
	<input type="text" name="product_price" placeholder="가격"><br>
	<input type=submit value="상품등록">
	</form>


</body>
</html>