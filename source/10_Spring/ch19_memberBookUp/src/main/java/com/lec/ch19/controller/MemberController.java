package com.lec.ch19.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.ch19.dto.Member;
import com.lec.ch19.service.MemberService;

@Controller
@RequestMapping("member")   // 공통 요청 경로
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(params="method=joinForm",method=RequestMethod.GET)
	public String joinForm() {
		return "member/joinForm";
	}
	@RequestMapping(params = "method=idConfirm",method=RequestMethod.GET)
	public String idconfirm(String mid, Model model) {
		model.addAttribute("result",memberService.idConfirm(mid));
		return "member/idConfirm";
	}
	@RequestMapping(params= "method=join",method=RequestMethod.POST)
	public String joinMember(@ModelAttribute("mDto") Member member, HttpSession httpSession, Model model) {
		model.addAttribute("joinResult",memberService.joinMember(member, httpSession));
		return "forward:member.do?method=loginForm";
	}
	@RequestMapping(params="method=loginForm",method= {RequestMethod.GET, RequestMethod.POST})
	public String loginForm() {
		return "member/loginForm";
	}
	@RequestMapping(params="method=login",method= {RequestMethod.GET, RequestMethod.POST})
	public String loginCheck(String mid, String mpw, HttpSession httpSession, Model model) {
		model.addAttribute("loginResult", memberService.loginCheck(mid, mpw, httpSession));
		return "forward:main.do";
	}
	@RequestMapping(params="method=logout",method= {RequestMethod.GET })
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:main.do";
	}
	@RequestMapping(params="method=modifyForm",method= {RequestMethod.GET, RequestMethod.POST })
	public String modifyForm() {
		return "member/modifyForm";
	}
	@RequestMapping(params="method=modify", method= {RequestMethod.POST})
	public String modifyMember(@ModelAttribute("mDto") Member member, Model model,HttpSession session) {
		model.addAttribute("modifyResult", memberService.modifyMember(member));
		session.setAttribute("member", member);
		return "forward:main.do";
	}
}
