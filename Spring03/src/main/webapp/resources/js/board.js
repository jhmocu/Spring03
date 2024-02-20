/**
 * 게시글 관련 기능
 */

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
