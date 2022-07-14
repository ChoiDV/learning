package com.lec.ch07.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
	// http://localhost:8090/ch07/ 요청처리
	@RequestMapping("/")
	public String home(Model model) {   // 이게 결국엔 메인페이지가 되는것
		model.addAttribute("greeting", "안녕하세요, 스프링");  // view단에 전달하고 싶은거 있을때 addAttribute
		return "main";  // view 이름 리턴
	}
		
	
}
