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
<c:forEach var="i" begin="1" end="10" step="2" varStatus="loop">
i=${i } &nbsp;&nbsp; 인덱스 : ${loop.index } &nbsp;&nbsp; ${loop.count }<br>
</c:forEach>

<c:set var="sum" >0</c:set>

for(int i=1; i<=10; i++){
sum+=i;
}
<c:forEach var="i" begin="1" end="10" step="1">	<!-- for(int i=) -->
i=${1 }, sum=${sum=sum+i }<br>
</c:forEach>
</body>
</html>