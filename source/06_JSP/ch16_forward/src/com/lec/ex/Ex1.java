package com.lec.ex;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex1
 */
@WebServlet("/Ex1")
public class Ex1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		actionDo(request, response);
	}


	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 넘어온 파라미터 id, pw 
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		Member member = new Member(id, pw);
		request.setAttribute("member", member);
		// View단으로 forward
		RequestDispatcher dispatcher = request.getRequestDispatcher("1_dispatcher/ex2_View.jsp");
		dispatcher.forward(request, response);
		
	}
	
}
