<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%><!-- 표현 언어 기능을 활성화,defalt 값이라 생략가능 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>EL 산술 연산 TEST</h1>		<!-- 산술연산 -->
	\${100} : ${100 }<br>
	\${1+2} : ${1+2 }<br>
	\${10+10} : ${10+10 }<br>
	\${20-30} : ${20-30 }<br>
	\${5*3} : ${5*3 }<br>
	\${7/5} : ${7/5 }<br>
	\${7%5} : ${7%5 }<br>
	\${100 div 9} : ${100 div 9}<br>
	\${100 mod 9} : ${100 mod 9}<br>
	
	
</body>
</html>