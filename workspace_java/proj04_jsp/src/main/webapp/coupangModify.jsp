<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="coupang.DTO.CoupangDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	CoupangDTO dto = (CoupangDTO) request.getAttribute("dto");
	%>
	<form action="<%=request.getContextPath()%>/coupang/control"
		method="post">
		<input type="hidden" name="cmd" value="modify"> <input
			type="hidden" name="product_id" value="<%=dto.getProduct_id()%>">

		상품명: <input type="text" name="product_name"
			value="<%=dto.getProduct_name()%>"><br> 가격: <input
			type="text" name="product_price" value="<%=dto.getProduct_price()%>"><br>

		<input type="submit" value="수정완료">
	</form>
</body>
</html>