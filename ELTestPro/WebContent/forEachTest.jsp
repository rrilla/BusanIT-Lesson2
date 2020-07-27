<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="fruits" value="사과,배,포도,딸기"/>
	<c:forTokens var="fruit" items="${fruits }" delims=",">
		${fruit }<br>
	</c:forTokens>
	
	
</body>
</html>