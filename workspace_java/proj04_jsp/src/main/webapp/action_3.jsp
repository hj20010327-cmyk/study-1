<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 	<jsp:include page="jsp_1.jsp?name=abcd"></jsp:include> --%>
	<jsp:include page="jsp_1.jsp">
		<jsp:param name="name" value="abcd"/>
	</jsp:include>
	<!-- include 안에 주석 있으니까 에러 남 -->
<%-- 		<jsp:param name="name" value="abcd"></jsp:param> --%>

<%-- 	<jsp:forward page="footer.jsp"/> --%>
	
	<%
		emp.DTO.EmpDTO dto2 = new emp.DTO.EmpDTO();
		pageContext.setAttribute("dto2", dto2);
	%>
	<jsp:useBean id="dto" class="emp.DTO.EmpDTO" scope="page" />
	
	<jsp:setProperty name="dto" property="empno" value="1234"/>
	<jsp:setProperty name="dto" property="empno" value="<%=request.getParameter("empno") %>"/>
	<jsp:setProperty name="dto" property="empno" value="${param.empno}"/>
	
	<jsp:setProperty name="dto" property="*" />
	
	<hr>
	${dto}
	
</body>
</html>