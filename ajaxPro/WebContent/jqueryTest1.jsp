<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jquery test 선택자</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {	//문서가 준비가 되면 안의 작업(함수)을 해라
	alert($("p").html());
});

function addHtml() {
	$("#aaa").html("ㅎㅇㅎㅇ this is jquery<br>");
};

function addImage() {
	$(".a1").html("<img src='images/duke.png'>");
}

/* function fn_process() {
	var value=${"#t_input"}.val();
	$("#t_output").val(value);
} */
</script>
</head>
<body>
<input type="text" id="t_input" />
<input type="button" value="입력" onClick="fn_process()" /><br>
<div>
	결과 : <input type="text" id="t_output" disabled/>
</div>


<div class="a1"></div>
<div class="a1"></div>
<input type="button" value="이미지 추가"  onClick="addImage()"><br>

	<div class="class1">ㅎㅇㅎㅇ</div>
	<div id="unique2">this is jquery </div>
	<div id="unique3">
		<p>jquery 쉽다????</p>
	</div>
	<div id="aaa"></div>
	<input type="button" value="추가하기" onClick="addHtml()"/>	
</body>
</html>