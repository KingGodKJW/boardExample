package com.spring.kjw.board.DAO;

import java.util.List;

import com.spring.kjw.board.VO.BoardVO;
import com.spring.kjw.paging.PageVO;



public interface BoardDAO {
	
		// 게시물 리스트 조회
		 List<BoardVO> selectList(BoardVO vo) throws Exception;
		
		// 게시물 등록
		 void insertBoard(BoardVO vo) throws Exception;
		
		// 게시물 수정
		 void updateBoard(BoardVO vo) throws Exception;
		
		// 게시물 삭제
		 void deleteBoard(int id) throws Exception;
		
		// 게시물 조회
		 BoardVO selectBoard(BoardVO vo) throws Exception;
		 
		 //조회수 증가
		 void updateViewCnt(int id) throws Exception;
		 
		 
		 //페이징 리스트
		 List<BoardVO> listPage(PageVO vo) throws Exception;
		 
		 //총게시글조회
		 int getTotalCount(PageVO vo) throws Exception;
		 
	
		 

}
