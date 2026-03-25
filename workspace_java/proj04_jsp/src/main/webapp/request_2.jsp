<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import = "java.util.*" %>
    <%@ page import = "forward.TodoDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 
	forward로 전달 받은 request에서
	num, map을 뽑아서
	syso도, html로도 출력
 -->
	<% int num = (int)request.getAttribute("num");
		Map map = (Map)request.getAttribute("map");
		
		System.out.println("jsp > num : " + num);
		System.out.println("jsp > map : " + map);
		
		out.print("num : " + num);
		out.print(" map : " + map);
	%>
	<br>
	num : 
 	<%= num %>
 	map :
 	<%= map %>
 	<br>
 	<%  TodoDTO todoDTO = (TodoDTO)request.getAttribute("todoDTO");
 		List list = (List)request.getAttribute("list");
 		String[] arr = (String[])request.getAttribute("arr");
 		
 		System.out.println("jsp > todoDTO : "+ todoDTO);
 		System.out.println("jsp > list : "+ list);
 		for(int i = 0; i<arr.length; i++) {
 		System.out.println("jsp > arr : "+ arr[i]);
 		}
		
 		out.println("<hr>");
 		out.println(todoDTO + "<br>");
 		out.println("list : " + list + "<br>");
 		for(int i = 0; i<arr.length; i++) {
 		out.print("arr");
 		out.print("["+i+"] : "+arr[i]+ " ");
 		}
 	%>
 	<br>
 	<hr>
 	<%= todoDTO %>
 	<br>
 	list :
 	<%= list %>
 	<br>
 	<%
 	for(int i=0; i<arr.length; i++) {
 	%>
 	arr[<%= i %>] :
 	<%= arr[i] %>
 	<%} %>
	
</body>
</html>