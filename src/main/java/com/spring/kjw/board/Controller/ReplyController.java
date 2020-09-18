package com.spring.kjw.board.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.kjw.board.Reply.ReplyVO;
import com.spring.kjw.board.Service.ReplyService;

@RestController
public class ReplyController {

	
	@Inject
	private ReplyService service;

	
	@RequestMapping(value = "/listReplyPage", method = RequestMethod.POST)

	public List<ReplyVO> listReplyPage(@RequestParam("id") int id) throws Exception {

		return service.listReplyPage(id);

	}
	
	@RequestMapping(value = "/registerReqly", method = RequestMethod.POST)

	public Map<String, Object> registerReply(@RequestBody ReplyVO replyVO) throws Exception {

		Map<String, Object> result = new HashMap<>();

		

		try {

			service.register(replyVO);

			result.put("status", "OK");

		} catch (Exception e) {

			e.printStackTrace();

			result.put("status", "False");

		}

		return result;

	}
	
	@RequestMapping(value="/updateReply", method=RequestMethod.POST)
	public Map<String,Object> updateReply(@RequestBody ReplyVO replyVO) throws Exception{
		
		Map<String,Object> result = new HashMap<>();
		System.out.println("parameter rid = "+ replyVO.getRid());
		try {
			replyVO.setRid(replyVO.getRid());
			service.modify(replyVO);
			result.put("status", "OK");
			
		}catch(Exception e) {
			e.printStackTrace();
			result.put("status", "False");
		}
		
		return result;
	}

	
	@RequestMapping(value="/deleteReply")
	public Map<String,Object> deleteReply(@RequestParam("rid") int rid) throws Exception{
		
		Map<String,Object> result = new HashMap<>();
		
		try {
			service.remove(rid);
			result.put("status", "OK");
			
		}catch(Exception e) {
			e.printStackTrace();
			result.put("status", "False");
		}
		
		return result;
	}

	
}
