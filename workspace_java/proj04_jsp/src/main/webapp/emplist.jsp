<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="emp.DTO.EmpDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<% 
		List<EmpDTO> list = (List)request.getAttribute("list");
	%>
	<table border=1>
		<tr>
			<th>empno</th>
			<th>ename</th>
			<th>job</th>
			<th>mgr</th>
			<th>hiredate</th>
			<th>sal</th>
			<th>comm</th>
			<th>deptno</th>
		</tr>
		<% for(int i=0; i<list.size(); i++) { 
			EmpDTO empDTO = list.get(i);%>
		<tr>
			<td><%= empDTO.getEmpno() %></td>
			<td><%= empDTO.getEname() %></td>
			<td><%= empDTO.getJob() %></td>
			<td><%= empDTO.getMgr() %></td>
			<td><%= empDTO.getHiredate() %></td>
			<td><%= empDTO.getSal() %></td>
			<td><%= empDTO.getComm() %></td>
			<td><%= empDTO.getDeptno() %></td>
		</tr>
		<%} %>
	</table>
	<form method="get" action="/proj04_jsp/emp/order">
	<input type="submit" value="급여낮은순 정렬">
	</form>
	<form method="get"	action="/proj04_jsp/empcon">
	<input type="submit" value="원상태로">
	</form>

</body>
</html>