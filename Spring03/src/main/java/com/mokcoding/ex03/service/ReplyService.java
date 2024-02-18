package com.mokcoding.ex03.service;

import java.util.List;

import com.mokcoding.ex03.domain.ReplyDTO;

public interface ReplyService {
	int createReply(ReplyDTO replyDTO);
	List<ReplyDTO> getAllReply(int boardId);
	int updateReply(int replyId, String replyContent);
	int deleteReply(int replyId, int boardId);
} // end ReplyService
