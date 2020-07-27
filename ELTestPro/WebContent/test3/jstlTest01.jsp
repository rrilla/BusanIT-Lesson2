<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<%
	int a = 10;
	pageContext.setAttribute("b", a);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set var="bb" value="안뇽"/>
<c:set var="c" >여기도되나</c:set>
<c:remove var="bb"/>	<!-- 변수 지움 -->
<h2>표현식 - <%=a %></h2><br>
<h2>EL - ${b }</h2><br>		<!-- 앱,컨텍스트,리퀘스트,세션 등 저장안하면 몬가옴 -->
<h2>EL2 - ${bb }</h2><br>	<!-- 코어태그이용 변수선언 사용 -->
<h2>EL3 - ${c }</h2><br>
</body>
</html>