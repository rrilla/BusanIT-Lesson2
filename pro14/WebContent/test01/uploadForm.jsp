<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드 예시1(cos)</title>
</head>
<body>
	<form method="post" action="upLoadPro" enctype="multipart/form-data">
		<input type="file" name="filename" multiple/><br> <!-- 'multiple'다중파일 선택가능 -->
		<input type="file" name="filename1" />			<!-- 하나씩 보내기 -->
		<input type="file" name="filename2" />
		<input type="file" name="filename3" />
	</form>
</body>
</html>