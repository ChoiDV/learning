package com.lec.ch07.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lec.ch07.dto.Member;

@Controller
@RequestMapping("board") // 공통 요청 경로 
public class BoardController {  //  Board 관련 controller
	// board/write, board/content, board/list, board/reply
	 //   /board/write : 앞에 / 넣어도 되고 안넣어도 되고 
	@RequestMapping(value="write")    // value 생략 // 조합된 요청경로 : board/write    
	public String write() {
		return "board/write";  // 뷰  :   /WEB-INF/views/board/wirte.jsp 로 스프링이 조합해줌
	}
	@RequestMapping(value="content",method=RequestMethod.GET)
	public String content(Model model /* , HttpServletRequest request */ ) { 
		// 여기의 HttpServletRequest request는 request로 setAttribute를 할 수도 있는데 여기서 
		//  request.setAttribute를 하려면 매개변수에 request를 넣어야 해서 데이터형과 매개변수 request 써주기
		// request.setAttribute("id","aaa");
		model.addAttribute("id","aaa");
		model.addAttribute("pw","111");
		Member member = new Member("bbb","222");
		model.addAttribute("member",member);
		return "board/content";
	}
	@RequestMapping(value="list", method=RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		Member member = new Member("ccc","111");
		ArrayList<Member> list = new ArrayList<Member>();
		list.add(member);
		mav.addObject("list",list);     // model.addAttribute("list",list);
		mav.setViewName("board/list"); // 뷰
		return mav;  // 이러면 위랑 똑같다?
	}
	@RequestMapping(value="reply", method=RequestMethod.GET)
	public ModelAndView modify(ModelAndView mav) {
		Member member = new Member("ddd", "111");
		mav.addObject("member",member);
		mav.setViewName("board/reply");
		return mav;
	}

}





