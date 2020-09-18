package com.spring.kjw.member.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.kjw.member.DAO.MemberDAO;
import com.spring.kjw.member.VO.MemberVO;

@Service
public class MemberServicep implements MemberService {

	@Autowired
	private MemberDAO dao;

	@Override
	public void insertmember(MemberVO vo) throws Exception {

		dao.insertmember(vo);

	}

	@Override
	public MemberVO login(MemberVO vo) throws Exception {
		
		return dao.login(vo);
	}
}
