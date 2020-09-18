package com.spring.kjw.member.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.kjw.member.Service.MemberService;
import com.spring.kjw.member.VO.MemberVO;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	@Autowired
	BCryptPasswordEncoder passEncoder;

	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String registerGET() throws Exception{
		return "/member/register";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String registerPost(MemberVO vo, RedirectAttributes ra) throws Exception {
		
		String inputPw = vo.getM_pw();
		String Pw = passEncoder.encode(inputPw);
		vo.setM_pw(Pw);
		
		service.insertmember(vo);
		
		ra.addFlashAttribute("msg","Success");
		
		return "redirect:/member/login";
		
	}
	
	@RequestMapping(value="/member/login", method=RequestMethod.GET)
	public String loginGet() throws Exception{
		
		return "/member/login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginPost(MemberVO vo, HttpServletRequest req, RedirectAttributes ra) throws Exception{
		
		HttpSession session = req.getSession();
		MemberVO login = service.login(vo);
		
		boolean passMatch = passEncoder.matches(vo.getM_pw(), login.getM_pw());
		
		if(login!=null && passMatch) {
			session.setAttribute("member", login);
			return "redirect:/listPage";
		}else {
			ra.addFlashAttribute("msg", "fail");
			return "redirect:/member/login";
		}

	}
	
	@RequestMapping(value="/member/needLogin")
	public ModelAndView needLogin() throws Exception{
		ModelAndView mav = new ModelAndView("/member/needLogin");
		mav.addObject("msg","로그인 후 이용해주시기 바랍니다.");
		
		return mav;
	}
	
	@RequestMapping(value="/member/logout")
	public String logout(HttpSession session) throws Exception{
		session.invalidate();
		return "redirect:/listPage";
	}
	
	

	
	
	
	
}
