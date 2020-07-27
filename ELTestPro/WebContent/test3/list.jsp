<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
	<tr><th>아디</th><th>비번</th><td>이름</td><th>이메일</th></tr>
	
	<c:forEach var="member" items="${list }">
	<tr>
		<td>${member.id }</td>
		<td>${member.pw }</td>
		<td>${member.name }</td>
		<td>${member.email }</td>
	</tr>
	<tr></tr>
	</c:forEach>
	</table>
</body>
</html>