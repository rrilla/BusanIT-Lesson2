<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>EL 논리 연산 TEST</h2>
	\${(10 == 10) && (20 == 20)} : ${(10 == 10) && (20 == 20)}<br>
	\${(10 == 10) and (20 == 20)} : ${(10 == 10) and (20 == 20)}<br>
	
	\${(10 == 10) || (30 == 20)} : ${(10 == 10) || (30 == 20)}<br>
	\${(10 == 10) or (30 == 20)} : ${(10 == 10) or (30 == 20)}<br>
	
	\${!(10 == 10)} : ${!(10 == 10)}<br>
	\${not(10 == 10)} : ${not(10 == 10)}<br>
	
	
</body>
</html>