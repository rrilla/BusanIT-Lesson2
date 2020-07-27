<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	request.setAttribute("addr", "함안군 산서리");
	session.setAttribute("msg", "세션 정보임.");
	application.setAttribute("msg1", "애플리케이션 정보임.");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:forward page="member2.jsp"/>
</body>
</html>