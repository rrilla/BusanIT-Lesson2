<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajex-ID 중복테스트</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	function fn_process(){
		var _id=$("#t_id").val();
		if(_id==''){
			alert("ID입력하셈");
			return;
		}
		$.ajax({
			type:"post",
			async:false,
			url:"member",
			data:{id:_id}, //파라메타이름은 'id'로 인식함!!!!!!!!!!
			dataType:"text",
			success:function(data,textStatus){
				if(data=='usable'){
					$("#msg").text("사용가능 ID");
					$("#btn_duplicate").prop("desabled",true);
				}else{
					$("#msg").text("사용불가 ID");
				}
			}
		});
	}
</script>
</head>
<body>
	<input type="text" id="t_id"/>
	<input type="button" value="ID 중복확인" onClick="fn_process()" id="id_duplecate" />
	<div id="msg"></div>
</body>
</html>