package com.spring.kjw.member.Service;


import com.spring.kjw.member.VO.MemberVO;

public interface MemberService {
	
	//회원가입
	public void insertmember(MemberVO vo) throws Exception;
	//로그인
	public MemberVO login(MemberVO vo) throws Exception;

}
