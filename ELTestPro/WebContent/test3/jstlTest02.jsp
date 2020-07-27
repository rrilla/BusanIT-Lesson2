<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<% request.setCharacterEncoding("utf-8"); %>  

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set var="id">hong</c:set>
<c:set var="pw" >1234</c:set>
<c:set var="name" value="${'홍길동'}"/>
<c:set var="age">22</c:set>

<c:if test="${true }">
	<h1>참참참차맟ㅁㅊㅁㅊ마마</h1>
</c:if>
<c:if test="${30==30 }" >
	두값 같음
</c:if>
<c:if test="${(id == 'hong') && (name == '홍길동') }">
	<h2>아이디 - ${id }<br> 이름 - ${name }</h2>
</c:if>
</body>
</html>