<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>result</title>
</head>
<body>
	
<%-- 	id: ${id}<br> --%>
	dto1 : ${dto1}<br>
	<hr>
	id : ${dto1.id}
	<hr>
	dto1["id"] : ${dto1["id"]}
	<hr>
	memberDTO3 : ${memberDTO3}
	<hr>
	memberDTO : ${memberDTO}
	
</body>
</html>