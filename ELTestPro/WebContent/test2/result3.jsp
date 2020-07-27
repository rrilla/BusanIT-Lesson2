<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	아디 : ${member.id }<br>
	비번 : ${member.pw }<br>
	이름 : ${member.name }<br>	
	이멜 : ${member.email }<br>
	우편번호 : ${member.address.zipcode }<br>	<!-- 객체 안에 객체 -->
	주소 : ${member.address.addr }<br><br>
</body>
</html>