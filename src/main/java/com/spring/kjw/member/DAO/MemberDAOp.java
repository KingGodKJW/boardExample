package com.spring.kjw.member.DAO;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.spring.kjw.member.VO.MemberVO;
import com.spring.kjw.member.mapper.MemberMapper;


@Service
public class MemberDAOp implements MemberDAO {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void insertmember(MemberVO vo) throws Exception {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		mapper.insertmember(vo);
	}
	@Override
	public MemberVO login(MemberVO vo) throws Exception {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		return mapper.login(vo);
	}
}
