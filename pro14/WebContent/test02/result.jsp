<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!-- contextPath == ROOT경로(web url) -->
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:set var="file1" value="${param.param1 }"/>
<c:set var="file2" value="${param.param2 }"/>
</head>
<body>
	매개변수1 : ${file1 }<br>
	매개변수2 : ${file2 }<br>
	
	<c:if test="${not empty file1 }">
	<img alt="" src="../download.do?fileName=${file1}" width=300 height=300>
	</c:if>
	
	<c:if test="${not empty file2 }">
	<img alt="" src="${contextPath }/download.do?fileName=${file2}" width=300 height=300>
	</c:if>
	파일 내려 받기<br>
	<a href="../download.do?fileName=${file2 }" >파일 내려받기</a><br>
</body>
</html>