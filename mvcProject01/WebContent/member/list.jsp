<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${not empty param.msg }">
<script type="text/javascript">
	alert("${param.msg}")
</script>
</c:if>
<a href="member?command=joinForm">회원가입</a>
<table>
<tr><th>no</th><th>id</th><th>이름</th><th>가입일</th><th>수정</th><th>삭제</th></tr>
<c:forEach items="${list }" var="member">
<tr>
	<td>${member.no }</td>
	<td>${member.id }</td>
	<td>${member.name }</td>
	<td><fmt:formatDate value="${member.reg_date }"/></td>
	<td><a href="member?command=updateForm&no=${member.no}">수정</a></td>
	<td><a href="member?command=delete&no=${member.no}">삭제</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>








