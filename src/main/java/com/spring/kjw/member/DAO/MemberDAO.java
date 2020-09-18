package com.spring.kjw.member.DAO;


import com.spring.kjw.member.VO.MemberVO;

public interface MemberDAO {
	
	//회원 가입
	 void insertmember(MemberVO vo) throws Exception;
	 //로그인
	 public MemberVO login(MemberVO vo) throws Exception;
	 

}
