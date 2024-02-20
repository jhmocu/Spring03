package com.mokcoding.ex03.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mokcoding.ex03.config.RootConfig;
import com.mokcoding.ex03.domain.ReplyDTO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class) // 스프링 JUnit 실행 클래스 연결
@ContextConfiguration(classes = { RootConfig.class }) // 설정 파일 연결
@Log4j
public class ReplyServiceTest {
	
	@Autowired
	private ReplyService replyService;
	
	@Test
	public void test() {
		testReplyCreate();
	}

	private void testReplyCreate() {
		ReplyDTO replyDTO = new ReplyDTO();
		replyDTO.setBoardId(1);
		replyDTO.setMemberId("mok");
		replyDTO.setReplyContent("test");
		int result = replyService.createReply(replyDTO);
		log.info(result + " 성공");
	} // end testReplyCreate()

} // end ReplyServiceTest
