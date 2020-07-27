<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${empty a1}<br>  <!-- a1이 비어있나(null이냐)? true/false -->
	${empty null}<br>	<!-- null,빈문자열,공백 둘다 true -->
	${not empty a1}<br>	
	${not empty "hello"}<br>
	${empty ""}	
</body>
</html>