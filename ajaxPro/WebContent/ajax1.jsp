<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajax test - jquery 사용</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	function fn_process() {
		$.ajax({
			type:"post",
			dataType:"xml",
			async:false,	//동기식 처리
			url:"ajaxTest2",
			success:function(info,textStatus){
				$(info).find("book").each(function() {
					var title=$(this).find("title").text();
					var writer=$(this).find("writer").text();
					var image=$(this).find("image").text();
					$("#bookInfo").append("<p>"+title+"</p><p>"+writer+"</p><img src="+image+">");
				});
			},
			error:function(data,textStatus){
				alert("에러에러에러에러!!!!");
			},
			complete:function(data,textStatus){
				alert("작업완료!!!");
			}
		});
	}
</script>
</head>
<body>
	<div id="bookInfo"></div>
	<input type="button" value="전송!!!!" onClick="fn_process()"/><br><br>
	<div id="message"></div>
</body>
</html>