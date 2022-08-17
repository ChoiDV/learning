package com.lec.ch08.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lec.ch08.vo.MemberDto;

@Controller
@RequestMapping("member")  // 공동 요청 경로 
public class MemberController {
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
	@RequestMapping(value="join1")  // 요청 경로 : member/join1
	public String join1(HttpServletRequest request, Model model) {  
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		int age = Integer.parseInt(request.getParameter("age"));
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		model.addAttribute("name",name);
		model.addAttribute("id",id);
		model.addAttribute("pw",pw);
		model.addAttribute("age", new Integer(age));  // New Integer 안써도 알아서 오브젝트타입으로 형변환해서 넘겨줌 
		model.addAttribute("email",email);
		model.addAttribute("address",address);
		return "member/result1";
	}
	@RequestMapping(value="join2") // 요청경로 : member/join2 
	public String join2(@RequestParam("name") String membername,
						@RequestParam("id") String memberid,
						@RequestParam("pw") String memberpw,
						@RequestParam("age") int age,
						@RequestParam("email") String memberemail,
						@RequestParam("address") String memberaddress, Model model) {
		model.addAttribute("name",membername);
		model.addAttribute("id",memberid);
		model.addAttribute("pw",memberpw);
		model.addAttribute("age",age);
		model.addAttribute("email", memberemail);  
		model.addAttribute("address",memberaddress);
		return "member/result1";	
	}
	@RequestMapping(value="join3")  // 요청경로 : member/join3     // 여기의 매개변수 이름과 input창의 파라미터 이름이 같아야함.
	public String join3(String name, String id, String pw, int age, String email, String address, Model model) {
		model.addAttribute("name",name);
		model.addAttribute("id",id);
		model.addAttribute("pw",pw);
		model.addAttribute("age", age);  
		model.addAttribute("email",email);
		model.addAttribute("address",address);
		return "member/result1";
	}
	@RequestMapping(value="join4")  // 요청경로 : member/join4
	public String join4(MemberDto memberDto, Model model) {
		model.addAttribute("member",memberDto);
		return "member/result4";
	}
	@RequestMapping(value="join5") // 요청경로 : member/join5
	public String join5(MemberDto memberDto/*  , Model model */) {
		// model.addAttribute("memberDto",memberDto );   주석 처리한부분은 생략해도 알아서 해준다.
		// 단 이방법을 사용하려면 매개변수 없는 생성자함수가 있어야하고 getter,setter 반드시 해주어야한다. 왜? 내부적으로는 MemberDto를 하나하나  set 해주기때문 
		return "member/result5";
	}
	@RequestMapping("join6")
	public String join6(@ModelAttribute("member") MemberDto memberDto) {
		return "member/result4";
	}
	
	
}
