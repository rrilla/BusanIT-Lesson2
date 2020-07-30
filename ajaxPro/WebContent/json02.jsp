<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	$(function () {
		$("#checkJson").click(function () {
			var name=$("#name").val();
			var age=$("#age").val();
			var gender=$("#gender").val();
			var nickname=$("#nickname").val();
			var jsonInfo = {
					"name": name ,
					"age" : age,
					"gender":gender,
					"nickname":nickname
					};
			//var _jsonInfo='{"name":"'+name+'","age":'+age+',"gender":"'+gender+'","nickname":"'+nickname+'"}';	//문자열 상태로 전송시
			$.ajax({
				type : "post",
				async : false,
				url : "json",
				data : jsonInfo,//{jsonInfo:_jsonInfo},
				success : function(data,textStatus){
					alert("전송 & 처리 성공");
					
				},
				error : function(data,textStatus){
					alert("에러에렁러ㅔㅇ");
				},
				complete : function(data,textStatus){}
			});
		});
	});
</script>
</head>
<body>
	이름 - <input type="text" id="name" /><br />
	나이 - <input type="text" id="age" /><br />
	성별 - <input type="text" id="gender" /><br />
	별명 - <input type="text" id="nickname" /><br />
	<button id="checkJson">전송</button><br />
	<!-- <a href="" id="checkJson" style="cursor:pointer">전송</a><br /> -->
	<div id="output"></div>
</body>
</html>