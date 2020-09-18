package com.spring.kjw.board.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.kjw.board.Reply.ReplyVO;
import com.spring.kjw.board.mapper.ReplyMapper;
import com.spring.kjw.paging.PageVO;

@Repository
public class ReplyDAOp implements ReplyDAO {

	
	@Autowired
	private SqlSession sqlSession;
	
	
	
	@Override
	public List<ReplyVO> listReplyPage(Integer id) throws Exception {
		ReplyMapper mapper = sqlSession.getMapper(ReplyMapper.class);
		
		return mapper.listReplyPage(id);
	}
	@Override
	public void modify(ReplyVO reply) throws Exception {
		ReplyMapper mapper = sqlSession.getMapper(ReplyMapper.class);
		mapper.modify(reply);
		
	}
	@Override
	public void register(ReplyVO reply) throws Exception {
		ReplyMapper mapper = sqlSession.getMapper(ReplyMapper.class);
		mapper.register(reply);
		
	}
	@Override
	public void remove(Integer rid) throws Exception {
		ReplyMapper mapper = sqlSession.getMapper(ReplyMapper.class);
		mapper.remove(rid);
	}

}
