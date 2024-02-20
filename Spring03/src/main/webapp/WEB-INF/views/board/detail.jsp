<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<!-- jquery 라이브러리 import -->
<script src="https://code.jquery.com/jquery-3.7.1.js">
</script>
<meta charset="UTF-8">
<title>${boardDTO.boardTitle }</title>
</head>
<body>
	<h2>글 보기 페이지</h2>
	<div>
		<p>글 번호 : ${boardDTO.boardId }</p>
	</div>
	<div>
		<p>제목 : </p>
		<p>${boardDTO.boardTitle }</p>
	</div>
	<div>
		<p>작성자 : ${boardDTO.memberId }</p>
		<p>작성일 : ${boardDTO.boardDateCreated }</p>
	</div>
	<div>
		<textarea rows="20" cols="120" readonly>${boardDTO.boardContent }</textarea>
	</div>
	
	<button id="listBoard">글 목록</button>	
	<button id="modifyBoard">글 수정</button>
	<button id="deleteBoard">글 삭제</button>
	
	<form id="listForm" action="list" method="GET">
		<input type="hidden" name="pageNum" >
    	<input type="hidden" name="pageSize" >
    	<input type="hidden" name="type" >
    	<input type="hidden" name="keyword" >	
	</form>
	<form id="modifyForm" action="modify" method="GET">
		<input type="hidden" name="boardId">
		<input type="hidden" name="pageNum" >
    	<input type="hidden" name="pageSize" >
    	<input type="hidden" name="type" >
    	<input type="hidden" name="keyword" >
	</form>
	<form id="deleteForm" action="delete" method="POST">
		<input type="hidden" name="boardId">
		<input type="hidden" name="pageNum" >
    	<input type="hidden" name="pageSize" >
    	<input type="hidden" name="type" >
    	<input type="hidden" name="keyword" >
	</form>

	<!-- 댓글 영역 -->
	<input type="hidden" id="boardId" value="${boardDTO.boardId }">
	
	<h2>댓글 작성</h2>
	<div style="text-align: center;">
		<input type="text" id="memberId" >
		<input type="text" id="replyContent">
		<button id="btnAdd">작성</button>
	</div>

	<hr>
	<div style="text-align: center;">
		<div id="replies"></div>
	</div>
	
	<script type="text/javascript">
	$(document).ready(function(){
		$("#listBoard").click(function(){
			var listForm = $("#listForm"); // form 객체 참조
			
			// c:out을 이용한 현재 페이지 번호값 저장
			var pageNum = "<c:out value='${pagination.pageNum }' />";
			var pageSize = "<c:out value='${pagination.pageSize }' />"; 
			var type = "<c:out value='${pagination.type }' />";
			var keyword = "<c:out value='${pagination.keyword }' />";
			
			// 페이지 번호를 input name='pageNum' 값으로 적용
			listForm.find("input[name='pageNum']").val(pageNum);
			// 선택된 옵션 값을 input name='pageSize' 값으로 적용
			listForm.find("input[name='pageSize']").val(pageSize);
			// type 값을 적용
			listForm.find("input[name='type']").val(type);
			// keyword 값을 적용
			listForm.find("input[name='keyword']").val(keyword);
			listForm.submit(); // form 전송
		}); // end click()
		
		$("#modifyBoard").click(function(){
			var modifyForm = $("#modifyForm"); // form 객체 참조
			
			var boardId = "<c:out value='${boardDTO.boardId}' />";
			// c:out을 이용한 pagination값 저장
			var pageNum = "<c:out value='${pagination.pageNum }' />";
			var pageSize = "<c:out value='${pagination.pageSize }' />";
			var type = "<c:out value='${pagination.type }' />";
			var keyword = "<c:out value='${pagination.keyword }' />";
			
			// 게시글 번호를 input name='boardId' 값으로 적용
			modifyForm.find("input[name='boardId']").val(boardId);				
			// 페이지 번호를 input name='pageNum' 값으로 적용
			modifyForm.find("input[name='pageNum']").val(pageNum);
			// 선택된 옵션 값을 input name='pageSize' 값으로 적용
			modifyForm.find("input[name='pageSize']").val(pageSize);
			// type 값을 적용
			modifyForm.find("input[name='type']").val(type);
			// keyword 값을 적용
			modifyForm.find("input[name='keyword']").val(keyword);
			modifyForm.submit(); // form 전송
		}); // end click()
		
		$('#deleteBoard').click(function(){
			if(confirm('삭제하시겠습니까?')) {
				var deleteForm = $("#deleteForm"); // form 객체 참조
				
				var boardId = "<c:out value='${boardDTO.boardId}' />";
				// c:out을 이용한 pagination값 저장
				var pageNum = "<c:out value='${pagination.pageNum }' />";
				var pageSize = "<c:out value='${pagination.pageSize }' />"; 
				var type = "<c:out value='${pagination.type }' />";
				var keyword = "<c:out value='${pagination.keyword }' />";
				
				// 게시글 번호를 input name='boardId' 값으로 적용
				deleteForm.find("input[name='boardId']").val(boardId);				
				// 페이지 번호를 input name='pageNum' 값으로 적용
				deleteForm.find("input[name='pageNum']").val(pageNum);
				// 선택된 옵션 값을 input name='pageSize' 값으로 적용
				deleteForm.find("input[name='pageSize']").val(pageSize);
				// type 값을 적용
				deleteForm.find("input[name='type']").val(type);
				// keyword 값을 적용
				deleteForm.find("input[name='keyword']").val(keyword);
				deleteForm.submit(); // form 전송
			}
		}); // end click()
	});

	</script>
	<!-- js 파일 연결 -->
	<script src="${pageContext.request.contextPath }/resources/js/reply.js"></script>
</body>
</html>








