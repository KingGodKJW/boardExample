package com.spring.kjw.board.Service;

import java.util.List;

import com.spring.kjw.board.Reply.ReplyVO;
import com.spring.kjw.paging.PageVO;

public interface ReplyService {
	
	//댓글 등록
	void register(ReplyVO reply) throws Exception;
	//댓글 수정
	void modify(ReplyVO reply) throws Exception;
	//댓글 삭제
	void remove(Integer rid) throws Exception;
	//댓글 리스트 조회
	List<ReplyVO> listReplyPage(Integer id) throws Exception;
	

}
