<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/shopping.css"/>
<script type="text/javascript" src="js/product.js"></script>
</head>
<body>
<c:set var="msg" value="${param.msg }"/>
<c:if test="${not empty msg }">
<script type="text/javascript" >
	alert("${msg}")
</script>
</c:if>
<script type="text/javascript">
</script>

	<div id="wrap" align="center">
	<h1>상품 수정 - 관리자 페이지</h1>
	<form method="post" enctype="multipart/form-data" name="frm">
	<input type="hidden" name="picName" value="${product.price }"/>
		<table>
			<tr><td>
				<c:choose>
					<c:when test="${empty product.pictureurl }">
						<img src="upLoad/noimage.gif">
					</c:when>
					<c:otherwise>
							<img src="upload/${product.pictureurl }" alt="" />
					</c:otherwise>
				</c:choose>
			</td><td>
			
		<table>
			<tr>
				<th style="width:80px">상품코드</th><td><input type="text" name="code" size=80 value="${product.code }" size=80 readonly/></td>
			</tr>
			<tr>
				<th style="width:80px">상품명</th><td><input type="text" name="name" value="${product.name }"  size=80 /></td>
			</tr>
			<tr>
				<th style="width:80px">가격</th><td><input type="text" name="price" value="${product.price }" size=80 /></td>
			</tr>
			<tr>
				<th style="width:80px">사진</th><td><input type="file" name="pictureurl" /><br>
					(주의 사항 : 이미지 변경할 경우 선택하세요)
				</td>
			</tr>
			<tr>
				<th style="width:80px">설명</th><td>
				<textarea name="description" cols="50" rows="10">${product.description }</textarea></td>
				</td>
			</tr>
			<tr>
			<td colspan=2 align="center">
			<input type="submit" value="삭제" onClick="check()" />
			<input type="reset" value="다시작성" />
			<input type="button" value="목록보기" onClick="location.href=list.do" />
			</td>
			</tr>	
		</table>
		
		</td></tr></table>
	</form>
	</div>
</body>
</html>