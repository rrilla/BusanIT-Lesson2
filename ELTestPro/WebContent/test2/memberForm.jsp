<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="../member3" method="post">
		<table>
			<tr><th>아이디</th><td><input type="text" name="id"/></td></tr>
			<tr><th>비번</th><td><input type="password" name="pw"/></td></tr>
			<tr><th>이름</th><td><input type="text" name="name"/></td></tr>
			<tr><th>이메일</th><td><input type="text" name="email"/></td></tr>
			<tr><td colspan=2 align="center">
			<input type="submit" value="가입할래" />
			<input type="reset" value="다시쓸래" />
			</td></tr>
		</table>
	</form>
</body>
</html>