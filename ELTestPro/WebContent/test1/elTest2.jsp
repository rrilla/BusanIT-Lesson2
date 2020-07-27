<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>EL 비교 연산 TEST</h2>
	\${10 == 10} : ${10 == 10}<br>
	\${10 eq 10} : ${10 eq 10}<br>
	
	\${10 != 10} : ${10 != 10}<br>
	\${10 ne 10} : ${10 ne 10}<br>
	
	\${10 > 10} : ${10 > 10}  	<br>	<!-- 크다 -->
	\${10 gt 10} : ${10 gt 10}<br>
	
	\${10 < 10} : ${10 < 10}<br>
	\${10 lt 10} : ${10 lt 10}<br>
	
	\${10 >= 10} : ${10 >= 10}<br>
	\${10 ge 10} : ${10 ge 10}<br>
	
	\${10 <= 10} : ${10 <= 10}<br>
	\${10 le 10} : ${10 le 10}<br>
	
	\${"hello" == "hello"} : ${"hello" == "hello"}<br>
	\${"hello" eq "hello"} : ${"hello" eq "hello"}<br>
</body>
</html>