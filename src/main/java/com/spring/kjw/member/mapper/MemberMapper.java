package com.spring.kjw.member.mapper;


import com.spring.kjw.member.VO.MemberVO;

public interface MemberMapper {
	
	//회원 가입
	public void insertmember(MemberVO vo) throws Exception;
	//로그인
	MemberVO login(MemberVO vo) throws Exception;
	
}
