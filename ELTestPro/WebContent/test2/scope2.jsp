<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>	
	<h2>Scope2 page</h2>
	${name }<br>
	${sessionScope.name }<br>
	${applicationScope.name }<br>
	<a href="scope3.jsp">scope3 페이지로</a><br>
	page.getCoontextPath - ${pageContext.request.contextPath }<br>
	request.getContextPath - <%=request.getContextPath() %><br>
	<!-- 페이지의 루트경로 -->
</body>
</html>