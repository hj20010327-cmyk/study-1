<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="coupang.DTO.CoupangDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	List<CoupangDTO> list = (List) request.getAttribute("list");
	%>
	

	<table border="1">
		<tr>
			<th>product_id</th>
			<th>product_name</th>
			<th>product_price</th>
		</tr>
		<%
		for (int i = 0; i < list.size(); i++) {
			CoupangDTO coupangDTO = list.get(i);
		%>
		<tr>
			<td><%=coupangDTO.getProduct_id()%></td>
			<td><%=coupangDTO.getProduct_name()%></td>
			<td><%=coupangDTO.getProduct_price()%></td>
			<td>
				<form action="<%=request.getContextPath()%>/coupang/control"
					method="post" style="display: inline;">
					<input type="hidden" name="cmd" value="modifyForm"> <input
						type="hidden" name="product_id" value="<%=coupangDTO.getProduct_id()%>">
					<input type="submit" value="수정">
				</form>

				<form action="<%=request.getContextPath()%>/coupang/control"
					method="post" style="display: inline;">
					<input type="hidden" name="cmd" value="delete"> <input
						type="hidden" name="product_id" value="<%=coupangDTO.getProduct_id()%>">
					<input type="submit" value="삭제"
						onclick="return confirm('정말 삭제하시겠습니까?');">
				</form>
			</td>
		</tr>
		<%
		}
		%>
	</table>

	<a href="/proj04_jsp/coupangInsert.jsp">상품추가하러가기</a>



</body>
</html>