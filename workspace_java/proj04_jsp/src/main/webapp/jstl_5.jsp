<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="a" value="10"/>
	\${a} : ${a}<br>
	<%
	 String name= "용상";
	%> 
	\${name} : ${ name }<br>
	s
	<c:set var="name2" value="<%= name %>"/>
	\${name2} : ${ name2 }<br>
	
	scope : page > request > session > application<br>
	<c:set var="name3" value="<%= name %>" scope="page"/>
	scope 생략하면 page<br>
	
	<c:set var="wish" value="데이트" scope="page"/>
	<c:set var="wish" value="여행" scope="request"/>
	<c:set var="wish" value="게임" scope="session"/>
	<c:set var="wish" value="잠자기" scope="application"/>
	
	\${wish} : ${wish}<br>
	
	pageScope : ${pageScope.wish}<br>
	requestScope : ${requestScope.wish}<br>
	sessionScope : ${sessionScope.wish}<br>
	applicationScope : ${applicationScope.wish}<br>
	
<%-- 	<jsp:forward page="jstl_5_1_scope.jsp" /> --%>

	<hr>
	<c:if test="true"/>항상참<br>
	
	<c:set var="b" value="100"/>
	<c:if test="${ b > 10 }">b는 10보다 큽니다<br></c:if>
	<c:if test="${ b eq 100 }">b는 100입니다<br></c:if>
	<c:if test="${ not (b eq 100) }">b는 100이 아닙니다<br></c:if>
	
	<c:choose>
		<c:when test="${b eq 99}">
			b는 99입니다
		</c:when>
		<c:when test="${b eq 101}">
			b는 101입니다
		</c:when>
		<c:otherwise>
			b는 99와 101이 아닙니다
		</c:otherwise>
	</c:choose>
	
	<hr>
	<% 
		List list = new ArrayList();
		for(int i=15; i<20; i++) {
			Map map = new HashMap();
			map.put("정신연령", i);
			map.put("실제나이", 10+i);
			
			list.add(map);
		}
	%>
	
	<c:set var="list2" value="<%=list %>" scope="page"/>
	첫번째 목록의 "실제 나이" 값 출력 : ${list2[0].실제나이} <br>
	
	<br>
	items<br>
<%-- 	<c:forEach var="m" items="<%=list %>"> --%>
	<c:forEach var="m" items="${list2}">
		정신연령 : ${m.정신연령}<br>
		실제나이 : ${m.실제나이}<br>
		<br>	
	</c:forEach> 
	<hr>
	begin, end<br>
	<c:forEach var="i" begin="0" end="3">
		${i}, ${list2[i].정신연령}<br>
	</c:forEach>
	<hr>
	step<br>
	<c:forEach var="i" begin="0" end="3" step="2">
		${i}, ${list2[i].정신연령}<br>
	</c:forEach>
	<hr>
	varStatus<br>
	<c:forEach var="i" begin="0" end="4" step="2" varStatus="loop">
		${i}
		<c:if test="${not loop.last}">
		,
		</c:if>
		loop.index : ${loop.index}<br>
		loop.count : ${loop.count}<br>
		loop.first : ${loop.first}<br>
		loop.last : ${loop.last}<br>
		<br>
	</c:forEach>
	
	<hr>
	items, begin등 같이 사용<br>
	<c:forEach var="m" items="${list2}" begin="1" end="3" varStatus="loop">
		${loop.index},${m.실제나이}<br>
	</c:forEach>
	<hr>
	<c:forEach var="list" items="${list2}">
		정신연령 : ${list.정신연령}<br>
		실제나이 : ${list.실제나이}<br>
		<br>	
	</c:forEach> 
	
	<hr>
	<c:forEach var="i" begin="2" end="9" varStatus="loop">
		<c:if test="${not(loop.index eq 3) and not(loop.index eq 7)}">
			<c:forEach var="j" begin="1" end="9">
				${i} x ${j} = ${i*j}
			</c:forEach>
			<br>
		</c:if>
	</c:forEach>
	<hr>
	
	c:url 사용 이유 <br>
	1. context path를 자동으로 추가한다<br>
	2. 영어나 숫자 외 문자를 encoding 해줌<br>
	3. 쿠키 금지일 때 ";jsessionid=어쩌고"를 자동으로 붙혀줌<br>
<%-- 	<c:url var="url1" value="el_4.jsp"> --%>
	<c:url var="url1" value="/el_4.jsp">
	</c:url>
	<a href="${url1}" target="_blank">el_4.jsp</a><br>
	
	<c:url var="url2" value="https://search.naver.com/search.naver">
		<c:param name="query" value="한글"/>
	</c:url>
	<a href="${url2}" target="_blank">네이버검색</a><br>
	
	<c:url var="url3" value="https://maplescouter.com/info">
		<c:param name="name" value="에따"/>
	</c:url>
	<a href="${url3}" target="_blank">환산주스탯검색</a><br>
	
	<hr>
	c:out<br>
	param.html : ${param.html} : innerHTML <br>
	c:out : <c:out value="${param.html}"/> : innerText <br>
	<!-- 
		< : &lt;
		> : $gt;
		공백 : &nbsp;
		& : &amp;
	 -->
	
</body>
</html>