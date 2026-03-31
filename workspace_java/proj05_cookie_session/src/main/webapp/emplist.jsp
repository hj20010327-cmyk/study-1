<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="emp.EmpDTO" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<table border=1>
	<tr>
		<th>empno</th>
		<th>ename</th>
		<th>job</th>
		<th>hiredate</th>
		<th>sal</th>
		<th>comm</th>
		<th>deptno</th>
		<th>mgr</th>
	</tr>
<%-- 	<c:set var="list2" value="<%=list %>"/> --%>
	<c:forEach var="emp" items="${list}"> 
	<tr>
		<td>${emp.empno}</td>
		<td>${emp.ename }</td>
		<td>${emp.job }</td>
		<td>${emp.hiredate }</td>
		<td>${emp.sal }</td>
		<td>${emp.comm }</td>
		<td>${emp.deptno }</td>
		<td>${emp.mgr }</td>
	</tr>
	</c:forEach>
	
	</table>
	
</body>
</html>