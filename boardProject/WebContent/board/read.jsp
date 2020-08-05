<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<div class="row">
	<div class="col-md-2">
		<ul class="nav nav-pills nav-stacked">
			<li class="active"><a href="#">메뉴1</a></li>
			<li><a href="#">메뉴2</a></li>
			<li><a href="#">메뉴3</a></li>
			<li><a href="#">메뉴4</a></li>
		</ul>
	</div>
	<div class="col-md-10">
		<h1>글 상세보기</h1>
		<hr>

		<div class="panel panel-info">
			<div class="panel-heading">
				<h3 class="panel-title">글 상세보기</h3>
			</div>
			<div class="panel-body">

				<fieldset disabled>
					<legend>기본정보 </legend>
					<div class="form-group">
						<label class="col-xs-2 col-lg-2 control-label">글번호</label>
						<div class="col-xs-10 col-lg-10">
							<input type="text" class="form-control" value="${board.bno }">
						</div>
					</div>
					<div class="form-group">
						<label class="col-xs-2 col-lg-2 control-label">글제목</label>
						<div class="col-xs-10 col-lg-10">
							<input type=text class="form-control" value="${board.title }">
						</div>
					</div>
					<div class="form-group">
						<label class="col-xs-2 col-lg-2 control-label">글내용</label>
						<div class="col-xs-10 col-lg-10">
							<textarea rows="5" class="form-control" >${board.content }</textarea>
						</div>
					</div>
					<div class="form-group">
						<label class="col-xs-2 col-lg-2 control-label">이미지</label>
						<div class="col-xs-10 col-lg-10">
							<img src="images/temp/${board.image_name }" width="320" height="240">
						</div>
					</div>
					<div class="form-group">
						<label class="col-xs-2 col-lg-2 control-label">조회수</label>
						<div class="col-xs-10 col-lg-10">
							<input type=text class="form-control" value="${board.readcount }">
						</div>
					</div>
					<div class="form-group">
						<label class="col-xs-2 col-lg-2 control-label">작성일</label>
						<div class="col-xs-10 col-lg-10">
							<input type=text class="form-control" value="${board.writedate }">
						</div>
					</div>
					<div class="form-group">
						<label class="col-xs-2 col-lg-2 control-label">작성자</label>
						<div class="col-xs-10 col-lg-10">
							<input type=text class="form-control" value="${board.writer }">
						</div>
					</div>
				</fieldset>

			</div>
			<div class="panel-footer">	
			<c:if test="${session_id == board.writer }">	<!-- 내글만 나오게 -->
				<button type="button" id="btnUpdateForm" class="btn btn-warning">수정</button>
				<button type="button" id="btnDelete" class="btn btn-danger">삭제</button>
			</c:if>
				<button type="button" id="btnList" class="btn btn-info">목록보기</button>
			</div>
		</div>
		<!-- /글내용 panel -->

		<div class="panel panel-default">
			<div class="panel-heading panel-comment">
				<span class="glyphicon glyphicon-comment"></span> 댓글 <span>${board.replycount }</span>
				<c:if test="${not empty session_id }">
				<button id="btnAddComment" type="button"
					class="btn btn-primary btn-xs pull-right">댓글쓰기</button>
				</c:if>
			</div>
			<div class="panel-body comment-body">

				<ul id="replyList" class="media-list">
				<c:forEach items="${replyList }" var="reply">
					<li class="media" data-rno="${reply.rno }"><a class="pull-left" href="#"><img
							src="images/baby4.jpg"  width="100" height="100"></a>
						<div class="media-body">
							<div>
								<strong class="text-primary">${reply.rno }</strong>
								<strong class="text-primary">${reply.writer }</strong>
								 <small class="pull-right text-muted">${reply.writedate }</small>
							</div>
							<p>${reply.replytext }
							<c:if test="${not empty session_id && session_id ==reply.writer }">
								<button type="button"  class="pull-right btn-xs btn-danger ">삭제</button>
							</c:if>
							</p>
						</div></li>
				</c:forEach>
					<!-- <li class="media" style="margin-left: 70px;"><a
						class="pull-left" href="#"><img src="images/baby3.jpg"  width="100" height="100"></a>
						<div class="media-body">
							<div>
								<strong class="text-primary">user01</strong> <small
									class="pull-right text-muted">2020-07-31</small>
							</div>
							<p>반가워요~~! Cras sit amet nibh libero, in gravida nulla. Nulla
								vel metus scelerisque ante sollicitudin commodo. Cras purus
								odio, vestibulum in vulputate at, tempus viverra turpis.</p>
						</div></li>
					<li class="media" style="margin-left: 140px;"><a
						class="pull-left" href="#"><img src="images/baby2.jpg"  width="100" height="100"></a>
						<div class="media-body">
							<div>
								<strong class="text-primary">user01</strong> <small
									class="pull-right text-muted">2020-07-31</small>
							</div>
							<p>반가워요~~! Cras sit amet nibh libero, in gravida nulla. Nulla
								vel metus scelerisque ante sollicitudin commodo. Cras purus
								odio, vestibulum in vulputate at, tempus viverra turpis.</p>
						</div></li>
					<li class="media"><a class="pull-left" href="#"><img
							src="images/baby.jpg"  width="100" height="100"></a>
						<div class="media-body">
							<div>
								<strong class="text-primary">user01</strong> <small
									class="pull-right text-muted">2020-07-31</small>
							</div>
							<p>반가워요~~! Cras sit amet nibh libero, in gravida nulla. Nulla
								vel metus scelerisque ante sollicitudin commodo. Cras purus
								odio, vestibulum in vulputate at, tempus viverra turpis.</p>
						</div></li>
						<li class="media" style="margin-left: 70px;"><a
						class="pull-left" href="#"><img src="images/baby8.jpg"  width="100" height="100"></a>
						<div class="media-body">
							<div>
								<strong class="text-primary">user01</strong> <small
									class="pull-right text-muted">2020-07-31</small>
							</div>
							<p>반가워요~~! Cras sit amet nibh libero, in gravida nulla. Nulla
								vel metus scelerisque ante sollicitudin commodo. Cras purus
								odio, vestibulum in vulputate at, tempus viverra turpis.</p>
						</div></li> -->
				</ul>

			</div>
		</div>
		<!-- /댓글 panel -->

	</div>
</div>

<!-- Modal -->
	<div class="modal fade" id="replyModal" tabindex="-1"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">모달 제목</h4>
				</div>
				<div class="modal-body">

					<div class="form-group">
						<label>댓글내용</label> 
						<textarea id="replytext" row="5"  cols="20" class="form-control" placeholder="댓글내용"></textarea>
					</div>
					<div class="form-group">
						<label>댓글작성자</label> 
						<input id="replyWriter" type="text" class="form-control" value="${session_id }">
					</div>
					<div class="form-group">
						<label>작성일자</label> 
						<input id="replydata" type="text" class="form-control" placeholder="댓글일자">
					</div>

				</div>
				<div class="modal-footer">
					<button id="btnUpdateReply" type="button" class="btn btn-warning">수정</button>
					<button id="btnDeleteReply" type="button" class="btn btn-danger">삭제</button>
					<button id="btnAddReply"type="button" class="btn btn-primary">등록</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
				</div>
			</div>
			<!-- 모달 콘텐츠 -->
		</div>
		<!-- 모달 다이얼로그 -->
	</div>
	<!-- 모달 전체 윈도우 -->

<script type="text/javascript">
	$("#btnUpdateForm").on('click', function () {
		location.href="updateForm.do?bno=${board.bno }&pageNum=${param.pageNum}";
	});
	
	$("#btnDelete").on('click', function () {
		location.href="delete.do?bno=${board.bno }&pageNum=${param.pageNum}";
	});
	
	$("#btnList").on('click', function () {
		location.href="list.dopageNum=${param.pageNum}";
	});
	var modal = $('.modal');
	var modal = $("#replyModal");
	$('#btnAddComment').on('click', function () {
		$("#replyModal").find("button[id='btnUpdateReply']").hide();
		$("#replyModal").find("#btnDeleteReply").hide();
		$("#replyModal").modal('show');
		
	});
	
</script>



<%@ include file="../include/footer.jsp"%>