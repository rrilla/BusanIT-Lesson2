<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#update {
		margin-bottom: 15px;
	}
	
	#tblList {
		background-color: #A6A6A6;
		width: 800px;
	}
	
	#tblList tbody {
		background-color: #F6F6F6;
	}
</style>
</head>
<body>
	<div class="data">
		<h2>아이디 목록</h2>
		<button id="update">갱신</button>
		<button id="update" >선택삭제</button>
		<table id="tblList" border="1">
		<thead>
			<tr>
				<th>
				<input type="checkbox" id="allCheck" /> 삭제
				</th>
				<th>수정</th>
				<th>번호</th>
				<th>아이디</th>
				<th>비번</th>
				<th>이름</th>
				<th>가입일</th>
			</tr>
		</thead>
		<tbody>
		
		</tbody>
		</table>
	
	</div>
	<div class="input-container">
		<form id="frm" >
			<!-- 글 수정 위해 글번호 배치할 용도. -->
			<input type="hidden" name="no" id="no">
			<br /><br />
			<table><h2>아이디 수정,생산</h2>
				<tr>
					<th>아디 - </th>
					<td><input type="text" name="id" id="id" ></td>
					<!-- required 무조건 입력하게,미입력시 말풍선 (브라우저에서 검증)-->
					
				</tr>
				<tr>
					<th>이름 - </th>
					<td><input type="text" name="name" id="name" /></td>
				</tr>
				<tr>
					<th>비번 - </th>
					<td><input type="password" name="pw" id=pw></td>
				</tr>
				<tr>
					<td colspan=2 align="center">
						<input type="button" value="생산" id="btnAdd">
						<input type="button" value="수정" id="btnModify">
						<input type="reset" value="다시">
					</td>
				</tr>
			</table>
		</form><br /><br /><br />
	</div>
	<!-- <div class="addId">
		<form id="addFrm">
			<input type="hidden" name="no" id="no">
			<table><h2>아이디 생산</h2>
				<tr>
					<th>아디 - </th>
					<td><input type="text" name="id" id="id"/></td>
				</tr>
				<tr>
					<th>비번 - </th>
					<td><input type="password" name="pw" id="pw"/></td>
				</tr>
				<tr>
					<th>이름 - </th>
					<td><input type=text name="name" id="name"/></td>
				</tr>
				<td colspan=2 align="center">
					<input type="submit" value="생산" id="btnCreate"/>
					<input type="reset" value="다시" />
				</td>
			</table>
		</form>
	</div> -->
	
<script src="js/jquery-3.5.1.min.js"></script>
<script>
	function getList() {
		$.ajax({
			url: 'servlet',
			method: 'GET',
			success: function (result) {
				console.log(result);
				
				processList(result);
			}
		});
	}

	function processList(list) {
		var str = '';
		
		for (let member of list) {
			str += '<tr>';
			str += '<td><input type="checkbox" name="no" value="' + member.no + '"></td>' + member.no + '</td>';
			str += '<td><input type="radio" name="modify" data-content="' + member.pw + '" ></td>';
			str += '<td>' + member.no + '</td>';
			str += '<td>' + member.id + '</td>';
			str += '<td>' + member.pw + '</td>';
			str += '<td>' + member.name + '</td>';
			str += '<td>' + member.reg_date + '</td>';
			str += '</tr>';
		}
		$('#tblList > tbody').html(str);
	}
	
	$('#update').click(function () {	//갱신버튼 클릭시 동작
		getList();
		alert("갱신됨!")
	});
	
	$('#tblList').on('click', 'input:radio[name="modify"]',function () {
		//closest()가장 가까운 부모찾아감
		var no = $(this).closest('tr').find('td:nth-child(3)').html();
		var id = $(this).closest('tr').find('td:nth-child(4)').html();
		var name = $(this).closest('tr').find('td:nth-child(6)').html();
		//var pw = $(this).closest('tr').find('td:nth-child(5)  a').html();
		
		$('#no').val(no);
		$('#id').val(id);
		$('#name').val(name);
		//$('#pw').val(pw); //db 비번 비교후 수정완료
	});
	
	$('#allCheck').on('click', function () {
		if ($(this).prop('checked')) {
			$('input:checkbox[name="no"]').prop('checked', true);
		}else {
			$('input:checkbox[name="no"]').prop('checked', false);
		}
	});
	
	$('#btnModify').on('click', function () {
		
		var str = $('#frm').serialize();	//자동으로 쿼리스트링(name=입력값)으로 전송
		console.log(str);
		 
		$.ajax({
			url: 'servlet',
			method: 'PUT',
			data: str,
			success: function(result) {
				alert(result);
				getList()
			},
			error: function (e) {
				alert('에러에러에러에러에러에ㅓㄹ에ㅓ레어에ㅓㄹ에ㅓ레어레어레어레어레얼에러');
			}
			//data: 'no=??&id=??&name=??&pw=??'	
		}); 
		//$(this).reset();
	});
	
	$('#frm').submit(function (event) {
		//event.preventDefault(); // from 객체의 기본동작인 action 요청을 막음
		
		//var title = $('input[name="title"]').val();
		
		var str = $(this).serialize();	//자동으로 쿼리스트링(name=입력값)으로 전송
		console.log(str);
		 
		$.ajax({
			url: 'servlet',
			method: 'POST',
			data: str,
			success: function(result) {	//result라는 변수로 응답값을 받음
				alert(result);
			
				getList()
			},
			error: function (e) {
				alert('에러에러에러에러에러에ㅓㄹ에ㅓ레어에ㅓㄹ에ㅓ레어레어레어레어레얼에러');
			}
				
			//data: 'title=sdf&content=sdf&writer=sdf'	//serialize()가 이걸 전송해줌
		}); 
		
		$(this).reset();
		
		return false;
	});
	
	
	
	
	
	$('#btnAdd')
	
	

	
</script>
<script>
	getList();
</script>
</body>
</html>