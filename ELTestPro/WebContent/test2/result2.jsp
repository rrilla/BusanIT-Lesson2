<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	아디 : ${map.m1.id }<br>
	비번 : ${map.m1.pw }<br>
	이름 : ${map.m1.name }<br>	<!-- 빈클래스의 멤벼 변수에 직접접근x -->
	이멜 : ${map.m1.email }<br><br>	<!-- getter에 접근하는 것임. id=getId() -->
	
	아디 : ${map.m2.id }<br>
	비번 : ${map.m2.pw }<br>
	이름 : ${map.m2.name }<br>	
	이멜 : ${map.m2.email }<br><br>
	
	아디 : ${map.m3.id }<br>
	비번 : ${map.m3.pw }<br>
	이름 : ${map.m3.name }<br>	
	이멜 : ${map.m3.email }<br><br>
</body>
</html>