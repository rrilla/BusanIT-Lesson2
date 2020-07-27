<%@page import="java.util.Date"%>
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
	<c:set var="price" value="1000000"/>
	<fmt:formatNumber value="${price }" type="number" var="priceNumber"/>
	통화료 표시 :
	<fmt:formatNumber type="currency" currencySymbol="$" value="${price }"/><br>
	<fmt:formatNumber type="percent" value="${price }" groupingUsed="false"/><br>
	
	<c:set var="now" value="<%=new Date() %>"/>
	<br><fmt:formatDate value="${now }" type="date" dateStyle="full"/><br>
	<fmt:formatDate value="${now }" type="date" dateStyle="short"/><br>		<!-- date:날짜만 -->
	<fmt:formatDate value="${now }" type="time"/><br>						<!-- time:요일만?시간 -->
	<fmt:formatDate value="${now }" pattern="YYYY-MM-DD :hh:mm:ss"/><br>	<!-- both:날짜요일 둘다 -->
	<fmt:formatDate value="${now }" type="both" dateStyle="full" timeStyle="full"/><br>
	<fmt:timeZone value="America/New York">
	뉴욕 현재 시간: <fmt:formatDate value="${now }" type="both" dateStyle="full" timeStyle="full"/>
	</fmt:timeZone>	
	
</body>
</html>