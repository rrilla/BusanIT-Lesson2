<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	pageContext.setAttribute("name", "page");
	request.setAttribute("name", "request");
	session.setAttribute("name", "session");	
	application.setAttribute("name", "application");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${name }<br>	<!-- 가장 안쪽에있는 page를 가져옴 -->
	<jsp:forward page="scope2.jsp"></jsp:forward>	
</body>
</html>