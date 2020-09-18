package com.spring.kjw;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.kjw.board.Service.BoardService;
import com.spring.kjw.board.VO.BoardVO;
import com.spring.kjw.paging.PageVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/**/root-context.xml")
public class Test1 {
	
	@Autowired
	private BoardService service;
	
	
	
	@Test
	public void listPageTest() throws Exception{
		PageVO cri = new PageVO();
		cri.setPage(1);
		cri.setPerPageNum(10);
		List<BoardVO> boards = service.listPage(cri);
		for (BoardVO board : boards) {
			System.out.println(board.getId()+ ":" + board.getTitle());
		}		
	}

}
