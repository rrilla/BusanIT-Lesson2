<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
$(function(){
	$("#checkJson").click(function(){
		var jsonStr='{"name":["홍길동","이순신","임꺽정"]}';
		var jsonInfo=JSON.parse(jsonStr);
		var output="회원이름<br>";
		output+="===============<br>";
		for(var i in jsonInfo.name){
			output+=jsonInfo.name[i]+"<br>";
		}
		$("#output").html(output);
		
	});
	
	$("#checkJson2").click(function(){
		var jsonStr='{"age":[20,30,40]}';
		var jsonInfo=JSON.parse(jsonStr);
		var output="회원나이<br>";
		output+="===============<br>";
		for(var i in jsonInfo.age){
			output+=jsonInfo.age[i]+"<br>";
		}
		$("#output2").html(output);
		
	});
	$("#checkJson3").click(function(){
		var jsonStr='{"name":"박지성","age":20,"gender":"남자","nickname":"날센돌이"}';
		var jsonInfo=JSON.parse(jsonStr);
		var output="회원정보<br>";
		output+="==========<br>";
		output+="이름 :"+jsonInfo.name+"<br>";
		output+="나이 :"+jsonInfo.age+"<br>";
		output+="성별 :"+jsonInfo.gender+"<br>";
		output+="별명 :"+jsonInfo.nickname+"<br>";
		$("#output3").html(output);
	});
	
	$("#checkJson4").click(function(){
		var jsonStr='{"members":'+
		'[{"name":"박지성","age":20,"gender":"남자","nickname":"날센돌이"},'+
		'{"name":"김연아","age":20,"gender":"여자","nickname":"칼치기"},'+
		'{"name":"손흥민","age":20,"gender":"남자","nickname":"탱크"}]}';
		var jsonInfo=JSON.parse(jsonStr);
		var output="회원정보<br>";
		output+="==========<br>";
		for(var i in jsonInfo.members){
			output+="이름 :"+jsonInfo.members[i].name+"<br>";
			output+="나이 :"+jsonInfo.members[i].age+"<br>";
			output+="성별 :"+jsonInfo.members[i].gender+"<br>";
			output+="별명 :"+jsonInfo.members[i].nickname+"<br>";
			output+="===========<br>"
			$("#output4").html(output);
		}
	});
});
</script>
</head>
<body>
<a id="checkJson" style="cursor:pointer">이름출력</a><br>
<div id="output"></div>
<br>
<a id="checkJson2" style="cursor:pointer">나이출력</a><br>
<div id="output2"></div>

<br>
<a id="checkJson3" style="cursor:pointer">객체출력</a><br>
<div id="output3"></div>

<br>
<a id="checkJson4" style="cursor:pointer">객체배열출력</a><br>
<div id="output4"></div>
</body>
</html>




