<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드 예시3(다중파일)</title>
</head>
<body>
	<form method="post" action="../upload2.do" enctype="multipart/form-data">
		파 &nbsp; 일 1 : <input type="file" name="uploadFile1" multiple/><br> 
		<!-- 파 &nbsp; 일 1 : <input type="file" name="uploadFile1" /><br>
		파 &nbsp; 일 1 : <input type="file" name="uploadFile2" /><br>
		파 &nbsp; 일 1 : <input type="file" name="uploadFile3" /><br> -->
		<input type="submit" value="전송" />
	</form>
</body>
</html>