package com.lec.ch09.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
	@RequestMapping(value="main.do", method=RequestMethod.GET)
	public String main() {
		return "main";
	}
//	@RequestMapping(value="student")
//	public String student(String id, Model model, HttpServletRequest request) {
//		String method = request.getMethod();  // request.getMethod() 하면 method 방식이 get인지 post인지 String으로 들어옴
//		model.addAttribute("method",method);
//		model.addAttribute("id",id);
//		return "studentId";
//	}
	
	@RequestMapping(value="student",method=RequestMethod.GET)
	public String student(String id, Model model) {
		//id = request.getParameter("id");  
		model.addAttribute("method", "GET");
		model.addAttribute("id",id);
		return "studentId";
	}
	
	@RequestMapping(value="student",method=RequestMethod.POST)
	public ModelAndView student(String id, ModelAndView mav) {
		//id = request.getParameter("id");  
		mav.addObject("method", "POST");
		mav.addObject("id",id);
		mav.setViewName("studentId");
		return mav;
	}
	
	@RequestMapping(value="idConfirm", method=RequestMethod.GET)
	public String idConfirm(String id, Model model) {
		model.addAttribute("id",id);
		if(id.equals("aaa")) {
			return "forward:studentOk.do"; // forward가 요청경로, redirect로 치던 둘다 요청경로가 된다. 즉 studentOk.do.jsp 로 가라가 아닌 studentOk.do를 호출해라가 된다.
			// return = "redirect:studentOk.do";   redirect는 새로운 request객체를 만들어서 가는것이기 때문에 파라미터들이 다 사라지고 새로 만들어짐 forward는 반대 
		}
		return "redirect:studentNg.do";
	}
	@RequestMapping(value="studentOk", method=RequestMethod.GET)  // method 방식은 나에게 온 애의 요청방식을 그대로 따른다.  즉 get방식으로 왔으면 그대로 get방식
	public String studentOk() {
		return "studentOk";
	}
	@RequestMapping(value="studentNg",method=RequestMethod.GET)
	public String studentNg() {
		return "studentNg";
	}
	// redirect 하면 model은 안넘어오고 파라미터는 넘어간다
	
	@RequestMapping(value="fullpath",method=RequestMethod.GET)
	public String fullpath() {
		return "redirect:http://www.naver.com";
	}
	
	
	
}
