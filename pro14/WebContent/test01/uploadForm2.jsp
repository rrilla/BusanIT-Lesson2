<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드 예시2</title>
</head>
<body>
	<form method="post" action="upload.do" enctype="multipart/form-data">
		글쓴이 : <input type="text" name="name" /><br> 
		제 &nbsp; 목 : <input type="text" name="title" /><br>
		파 &nbsp; 일 : <input type="file" name="uploadFile" /><br><br>
		<input type="submit" value="전송" />
	</form>
</body>
</html>