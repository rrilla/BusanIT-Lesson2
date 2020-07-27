<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	pageContext.setAttribute("id", "aaaa");
	request.setAttribute("id", "abcd");
	session.setAttribute("id", "bbbb");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${id }<br> <!-- 가장가까운 위치값을 가져옴 pageContext - request - session - application-->
	${name }<br> <!-- 변수가없어도 가능, 값o-보여줌,값x-암것도x -->
</body>
</html>