<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="member" method="post">
<input type="hidden" name="command" value="update">	<!-- 주소url ==  command=join -->
<table>
	<tr><th>번호</th><td><input type="text" name="no" value="${member.no }" readonly></td></tr>
	<tr><th>아이디</th><td><input type="text" name="id" value="${member.id }"></td></tr>
	<tr><th>비밀번호</th><td><input type="password" name="pw" value="${member.pw }"></td></tr>
	<tr><th>이름</th><td><input type="text" name="name" value="${member.name }"></td></tr>
	<tr><th>가입일</th><td><input type="text" name="reg_date" value="${member.reg_date }" readonly></td></tr>
	<tr><td colspan=2 align="center">
		<input type="submit" value="수정">
		<input type="reset" value="취소">
	</td></tr>
</table>
</form>
</body>
</html>