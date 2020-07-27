<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
	<tr><th>아디</th><th>비번</th><th>이름</th><th>이멜</th><th>주소</th></tr>
	<tr>
		<td>${param.id}</td>
		<td>${param.pw }</td>
		<td>${param.name }</td>
		<td>${param.email }</td>
		<td>${requestScope.addr }</td>		<!-- requestScope 이용해 바인딩주소 정보 출력 -->
	</tr>
	</table>
	세션 정보:${sessionScope.msg }<br>
	애플리케이션 정보 : ${applicationScope.msg1 }<br>
</body>
</html>