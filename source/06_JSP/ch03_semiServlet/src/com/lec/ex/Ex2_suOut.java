package com.lec.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Ex2suOut", description = "sumOut", urlPatterns = { "/Ex2suOut" })
public class Ex2_suOut extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Ex2_suOut() {
        super();
       
    }	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		String numStr = request.getParameter("num");
		if ( numStr == null || numStr.equals("")) {
			numStr = "1";
		} 
		int num = Integer.parseInt(numStr);
		int sum = 0;
		for(int i=0; i <= num; i++) {
			sum += i;
		}
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<h1>1부터 " + num + " 까지 누적합은  " + sum + " 입니다.</h1>");
		out.close();
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		doGet(request, response); // ex2_suInput 에서 post 방식을 해서 여기로 오지만 deGet(request,response) 로 인해 doGet이 실행되기때문에 doGet에 정의.
	}

}
