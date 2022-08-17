package com.lec.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// @WebServlet("/HWrold") 이렇게 매핑하기도 가능 서블릿 이름 넣지않고 urlPatterns만 해도됨.  서블릿이름 default값은 클래스이름과 같음 
// @WebServlet(name = "HelloWorld", urlPatterns = { "/HWorld" })   // url 매핑
// url 맵핑을 web.xml 에서 해보기 여기서 하는 매핑방식은 어노테이션 방식
public class Ex1_HelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get방식으로 요청이 들어오면 이곳을 실행함 
		System.out.println("doGet호출1");
		// request는 요청처리객체
		// response는 응답처리객체
		// response에 출력할것들(보내줄것들?) 을 넣어줘야함. HTML을 response에 넣어줌.
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter(); // 스트림 객체 생성
		// getWriter 는 response 안의 html문을 넣는 공간을 의미 		
		out.println("<html>");
		out.println("<head>");
		out.println("<style>");
		out.println("h1 { color:blue;");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>안녕하세요. 첫servlet 예제입니다</h1>");
		out.println("</body>");				
		out.println("<html>");
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// post방식으로 요청이 들어오면 이곳을 실행함
		System.out.println("doPost호출1");
		doGet(request, response);		
	}
	// html에서 method="post" 방식으로 호출하면 doPost를 실행하고, doGet도 실행한다.

}
