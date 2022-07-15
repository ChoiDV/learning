package com.lec.ch08.controller;

import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
	@ModelAttribute("cnt")  // 모든 요청경로에 cnt와 list란 이름의 model.attribute를 하는것.(모든 함수에 공통으로 attribute?)
	public int cnt() {
		return 5;
	}
	@ModelAttribute("list")
	public ArrayList<String> list(){
		ArrayList<String> list = new ArrayList<String>();
		list.add("test1");
		list.add("test2");
		list.add("test3");
		return list;
	}
	@RequestMapping(value="/")
	public String input(Model model) {
//		model.addAttribute("cnt",5);
		return "member/input";
	}
	
//	@RequestMapping(value="studentId/*")
//	public String studentId(HttpServletRequest request, Model model) throws UnsupportedEncodingException {
//		String uri = request.getRequestURI();  // 요청 uri  즉,  /ch08/studentId/aaa   우리가 필요한건 studentId/??? 뒤에오는 ??? 가 궁금하기때문에 뽑아내기
//		String id = uri.substring(uri.lastIndexOf("/")+1);  // 마지막으로 나오는 / 다음부터 끝까지 즉, aaa, bbb, 홍홍홍 등을 가져옴
//		id = URLDecoder.decode(id, "utf-8");   // 컴퓨터만 알수있는 언어를 이전의 정보로 되돌리는 과정 즉 깨지지 않게 utf-8
//		model.addAttribute("id",id);	
//		return "studentId";
//	}
	@RequestMapping(value="studentId/{id}")  // {id} 의 의미는 studentId/ uri  뒤에 오는것을 id에 넣는것이다.
	public String studentId(@PathVariable("id") String id, Model model) {  
		model.addAttribute("id",id);
		return "studentId";
	}
	
}
