package com.mokcoding.ex03.domain;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter 
@Setter
@ToString 
public class BoardDTO {

	private int boardId; 
	private String boardTitle; 
	private String boardContent;
	private String memberId; 
	private Date boardDateCreated; 
	private int replyCount;
	
} // end BoardDTO
