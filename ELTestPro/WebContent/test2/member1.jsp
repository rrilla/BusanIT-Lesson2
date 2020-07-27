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
	<tr><th>아디</th><th>비번</th><th>이름</th><th>이멜</th></tr>
	<tr>
		<td><%=request.getParameter("id") %></td>
		<td><%=request.getParameter("pw") %></td>
		<td><%=request.getParameter("name") %></td>
		<td><%=request.getParameter("email") %></td>
	</tr>
	<tr>
		<td>${param.id}</td>
		<td>${param.pw }</td>
		<td>${param.name }</td>
		<td>${param.email }</td>
	</tr>
	</table>
</body>
</html>