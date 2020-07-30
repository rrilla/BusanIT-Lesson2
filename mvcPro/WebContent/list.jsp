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
		width: 600px;
	}
	
	#tblList tbody {
		background-color: #F6F6F6;
	}
</style>
</head>
<body>
	<div class="data">
		<button id="update">갱신</button>
		<table id="tblList" border="1">
		<thead>
			<tr>
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
			<input type="hidden" name="bno" id="bno">
			<br /><br />
			<table><h2>아이디 수정</h2>
				<tr>
					<th>아디 - </th>
					<td><input type="text" name="title" id="title" ></td>
					<!-- required 무조건 입력하게,미입력시 말풍선 (브라우저에서 검증)-->
					
				</tr>
				<tr>
					<th>이름 - </th>
					<td><input type="text" name="content" id="content" /></td>
				</tr>
				<!-- <tr>
					<th>작성자</th>
					<td><input type="text" name="writer" id=writer></td>
				</tr> -->
				<tr>
					<td colspan=2 align="center">
						<input type="button" value="수정" id="btnModify">
						<input type="reset" value="다시">
					</td>
				</tr>
			</table>
		</form><br /><br /><br />
	</div>
	<div class="addId">
		<form id="addFrm">
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
	</div>
	
<script src="js/jquery-3.5.1.min.js"></script>
<script>
	
	$('#update').click(function () {
		getList();
		alert("갱신됨!")
	});

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
		
		for (let Member of list) {
			str += '<tr>';
			str += '<td>' + Member.no + '</td>';
			str += '<td>' + Member.id + '</td>';
			str += '<td>' + Member.pw + '</td>';
			str += '<td>' + Member.name + '</td>';
			str += '<td>' + Member.reg_date + '</td>';
			str += '</tr>';
		}
		$('#tblList > tbody').html(str);
	}
</script>
<script>
	getList();
</script>
</body>
</html>