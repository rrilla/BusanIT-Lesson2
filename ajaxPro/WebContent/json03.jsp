<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>servlet >> json</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	$(function () {
		$("#checkJson").click(function (){
			$.ajax({
				type : "post",
				async : false,
				url : "json2",
				success : function(data, textStatus){
					var jsonInfo = JSON.parse(data);
					var memberInfo = "회원정보<br>";
					memberInfo += "=================<br>";
					for(var i in jsonInfo.members){
						memberInfo += "이름 : " + jsonInfo.members[i].name +"<br>";
						memberInfo += "나이 : " + jsonInfo.members[i].age +"<br>";
						memberInfo += "성별 : " + jsonInfo.members[i].gender +"<br>";
						memberInfo += "별명 : " + jsonInfo.members[i].nickname +"<br>";
						imgURL = jsonInfo.members[i].image;
						memberInfo += "<img src="+imgURL+"><br><br>";
						
					}
					$("#output").html(memberInfo);
					
				},error : function(data, textStatus){
					
				},complete : function(data, textStatus){}
			});
		});
	});


</script>
</head>
<body>
	<a id="checkJson" style="cursor:pointer">출력!</a><br /><br />
	<div id="output"></div>
</body>
</html>