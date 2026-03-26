<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	\${wish} : ${wish}<br>
	
	pageScope : ${pageScope.wish}<br>
	requestScope : ${requestScope.wish}<br>
	sessionScope : ${sessionScope.wish}<br>
	applicationScope : ${applicationScope.wish}<br>
</body>
</html>