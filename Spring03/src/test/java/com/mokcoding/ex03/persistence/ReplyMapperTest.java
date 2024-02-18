package com.mokcoding.ex03.persistence;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mokcoding.ex03.config.RootConfig;
import com.mokcoding.ex03.domain.Reply;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class) // 스프링 JUnit 실행 클래스 연결
@ContextConfiguration(classes = { RootConfig.class }) // 설정 파일 연결
@Log4j
public class ReplyMapperTest {
	
	@Autowired
	private ReplyMapper replyMapper;
	
	@Test
	public void test() {
//		testReplyInsert();
		testReplyList();
//		testReplyUpdate();
//		testReplyDelete();
	}


	private void testReplyInsert() {
		Reply reply = new Reply();
		reply.setBoardId(1);
		reply.setMemberId("mok");
		reply.setReplyContent("테스트 댓글 작성");
		
		log.info(replyMapper.insert(reply));
	}
	

	private void testReplyList() {
		List<Reply> list = replyMapper.selectListByBoardId(1);
		for(Reply reply : list) {
			log.info(reply);
		}
	}
	
	private void testReplyUpdate() {
		Reply reply = new Reply();
		reply.setReplyId(1);
		reply.setReplyContent("댓글 수정");
		log.info(replyMapper.update(reply));
	}
	

	private void testReplyDelete() {
		log.info(replyMapper.delete(1));
	}


} // end ReplyMapperTest
