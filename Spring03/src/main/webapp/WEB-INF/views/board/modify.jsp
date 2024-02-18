<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${boardDTO.boardTitle }</title>
</head>
<body>
	<h2>글 수정 페이지</h2>
	<form action="modify" method="POST">
		<input type="hidden" name="pageNum" value="${pagination.pageNum}">
		<input type="hidden" name="pageSize" value="${pagination.pageSize}">
		<input type="hidden" name="type" value="${pagination.type}">
		<input type="hidden" name="keyword" value="${pagination.keyword}">
		
		<div>
			<p>번호 :</p>
			<input type="text" name="boardId" value="${boardDTO.boardId }"
				readonly>
		</div>
		<div>
			<p>제목 :</p>
			<input type="text" name="boardTitle" placeholder="제목 입력"
				maxlength="20" value="${boardDTO.boardTitle }" required>
		</div>
		<div>
			<p>작성자 : ${boardDTO.memberId}</p>

		</div>
		<div>
			<p>내용 :</p>
			<textarea rows="20" cols="120" name="boardContent"
				placeholder="내용 입력" maxlength="300" required>${boardDTO.boardContent }</textarea>
		</div>
		<div>
			<input type="submit" value="등록">
		</div>
	</form>
</body>
</html>