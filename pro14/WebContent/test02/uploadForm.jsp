<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드 예시1(다중파일,commons)</title>
</head>
<body>
	<form method="post" action="../upload3.do" enctype="multipart/form-data">
	
		파 일 1 : <input type="file" name="file1" /><br><br>
		파 일 2 : <input type="file" name="file2" /><br><br>
		매개변수1 : <input type="text" name="param1" /><br> 
		매개변수2 : <input type="text" name="param2" /><br> 
		매개변수3 : <input type="text" name="param3" /><br> 
		
		<input type="submit" value="전송" />
	</form>
</body>
</html>