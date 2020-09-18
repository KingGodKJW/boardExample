package com.spring.kjw.board.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.kjw.board.DAO.ReplyDAO;
import com.spring.kjw.board.Reply.ReplyVO;
import com.spring.kjw.paging.PageVO;

@Service
public class ReplyServicep implements ReplyService {
	
	@Autowired
	private ReplyDAO dao;
	
	@Override
	public void register(ReplyVO reply) throws Exception {
		dao.register(reply);
		
	}
	
	
	 @Override
	public List<ReplyVO> listReplyPage(Integer id) throws Exception {
		
		return dao.listReplyPage(id);
	}
	
	@Override
	public void modify(ReplyVO reply) throws Exception {
		
		dao.modify(reply);
	}
	@Override
	public void remove(Integer rid) throws Exception {
		dao.remove(rid);
		
	}
	
	
	

}
