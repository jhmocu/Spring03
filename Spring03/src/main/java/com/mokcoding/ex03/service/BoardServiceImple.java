package com.mokcoding.ex03.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mokcoding.ex03.domain.Board;
import com.mokcoding.ex03.domain.BoardDTO;
import com.mokcoding.ex03.persistence.BoardMapper;
import com.mokcoding.ex03.util.Pagination;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class BoardServiceImple implements BoardService{
	
	@Autowired
	private BoardMapper boardMapper;

	// controller에서 전송된 BoardDTO를 Board로 변환하여 boardMapper의 insert로 전송
	@Override
	public int createBoard(BoardDTO boardDTO) {
		log.info("createBoard()");
		log.info("boardDTO = " + boardDTO);
		int result = boardMapper.insert(toEntity(boardDTO));
		return result;
	} // end createBoard()

	// boardMapper의 selectList로 가져온 List<Board> 데이터를
	// List<BoardDTO>로 변환하여 controller에 전송
	@Override
	public List<BoardDTO> getAllBoards() {
		log.info("getAllBoards()");
		List<Board> list = boardMapper.selectList();
		
		return list.stream().map(this::toDTO).collect(Collectors.toList());
		// stream() : 리스트로부터 스트림 생성. 스트림은 요소(element)들에 대한 연속적인 작업을 수행 가능
		// map(this::toDTO) : 스트림의 각 요소를 다른 형태로 변환. toDTO는 변환 함수로 Board를 BoardDTO로 변경
		// collect(Collectors.toList()) : 스트림의 요소들을 수집. toList()를 통해 새로운 리스트 타입으로 수집
	} // end getAllBoards()
  
	// controller에서 전송된 boardId를 바탕으로 
	// boardMapper의 selectOne으로 가져온 Board 데이터를
	// BoardDTO로 변환하여 controller에 전송
	@Override
	public BoardDTO getBoardById(int boardId) {
		log.info("getBoardById()");
		log.info("boardId = " + boardId);
		Board board = boardMapper.selectOne(boardId);
		return toDTO(board);
	} // end getBoardById()

	// controller에서 전송된 BoardDTO를 Board로 변환하여
	// boardMapper의 update로 전송
	@Override
	public int updateBoard(BoardDTO boardDTO) {
		log.info("updateBoard()");
		log.info("boardDTO = " + boardDTO);
		int result = boardMapper.update(toEntity(boardDTO));
		return result;
	} // end updateBoard()

	// controller에서 전송된 boardId를 
	// boardMapper의 delete로 전송
	@Override
	public int deleteBoard(int boardId) {
		log.info("deleteBoard()");
		log.info("boardId = " + boardId);
		int result = boardMapper.delete(boardId);
		return result;
	} // end deleteBoard()
	
	// boardMapper의 selectListByPaginaton로 가져온 List<Board> 데이터를
	// List<BoardDTO>로 변환하여 controller에 전송
	@Override
	public List<BoardDTO> getPagingBoards(Pagination pagination) {
		log.info("getPagingBoards()");
		List<Board> list = boardMapper.selectListByPagination(pagination);
		
		return list.stream().map(this::toDTO).collect(Collectors.toList());
	} // end getPagingBoards()
	
	// 게시글을 조회하여 controller에 전송
	@Override
	public int getTotalCount(Pagination pagination) {
		log.info("getTotalCount");
		return boardMapper.selectTotalCount(pagination);
	} // end getTotalCount()
	
	// Board 데이터를 BoardDTO에 적용하는 메서드
	public BoardDTO toDTO(Board board) {
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setBoardId(board.getBoardId());
		boardDTO.setBoardTitle(board.getBoardTitle());
		boardDTO.setBoardContent(board.getBoardContent());
		boardDTO.setMemberId(board.getMemberId());
		boardDTO.setBoardDateCreated(board.getBoardDateCreated());
		boardDTO.setReplyCount(board.getReplyCount());
		return boardDTO;
	} // end toDTO()
	
	// BoardDTO 데이터를 Board에 적용하는 메서드
	public Board toEntity(BoardDTO boardDTO) {
		Board board = new Board();
		board.setBoardId(boardDTO.getBoardId());
		board.setBoardTitle(boardDTO.getBoardTitle());
		board.setBoardContent(boardDTO.getBoardContent());
		board.setMemberId(boardDTO.getMemberId());
		board.setReplyCount(boardDTO.getReplyCount());
		return board;
	} // end toEntity()
	
} // end BoardServiceImple
