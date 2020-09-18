package com.spring.kjw.board.Service;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.kjw.board.DAO.BoardDAO;
import com.spring.kjw.board.VO.BoardVO;
import com.spring.kjw.paging.PageVO;

@Service
public class BoardServicep implements BoardService {

	@Autowired
	private BoardDAO dao;

	@Override
	public List<BoardVO> selectList(BoardVO vo) throws Exception {
		List<BoardVO> list = null;
		list = dao.selectList(vo);
		return list;
	}

	@Override
	public void insertBoard(BoardVO vo) throws Exception {
		dao.insertBoard(vo);

	}

	@Override
	public void updateBoard(BoardVO vo) throws Exception {
		dao.updateBoard(vo);

	}

	@Override
	public void deleteBoard(int id) throws Exception {
		dao.deleteBoard(id);

	}

	@Override
	public BoardVO selectBoard(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		BoardVO boardVO = dao.selectBoard(vo);
		return boardVO;
	}

	@Override
	public void updateViewCnt(int id) throws Exception {
		dao.updateViewCnt(id);

	}

	@Override
	public List<BoardVO> listPage(PageVO vo) throws Exception {
		
		
		return dao.listPage(vo);
	}

	@Override
	public int getTotalCount(PageVO vo) throws Exception {
		
		return dao.getTotalCount(vo);
	}
}
