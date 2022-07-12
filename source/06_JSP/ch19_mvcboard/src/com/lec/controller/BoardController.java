package com.lec.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.service.BContentService;
import com.lec.service.BDeleteService;
import com.lec.service.BListService;
import com.lec.service.BModifyService;
import com.lec.service.BModifyViewService;
import com.lec.service.BReplyService;
import com.lec.service.BReplyViewService;
import com.lec.service.BWriteService;
import com.lec.service.Service;

@WebServlet("*.do")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private boolean write_view = false;
	private boolean modify_view = false;
	private boolean delete = false;
	private boolean reply = false;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		actionDo(request, response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();					// ch19_mvcboard/list.do
		String conPath = request.getContextPath();				// ch19_mvcboard
		String command = uri.substring(conPath.length());		// list.do
		String viewPage = null;  // viewPage 초기화
		Service service = null;
		if(command.equals("/list.do")) {
			service = new BListService();  
			service.execute(request, response);
			viewPage = "board/list.jsp";
			// 지금 현재 위치가 루트에 있어서 conPath 안붙여도됌.
		} else if(command.equals("/write_view.do")) {  // 글쓰기 view
			viewPage = "board/write_view.jsp";
			write_view = true;
		} else if(command.equals("/write.do")) { // 원글쓰기 dao 수행 로직
			if(write_view) {
				service = new BWriteService();
				service.execute(request, response);
				write_view = false;  // 이것을 하는이유는 write_view에 들어갔을때만 글쓰기 dao가 실행되어야해서 write_view에 들어가면 write_view 변수를 true 잠깐만 만들어서 if문으로 write_view 변수가 true일때만 dao 실행할수 있도록 
			}
			viewPage = "list.do"; 
		} else if(command.equals("/content_view.do")) {
			// 글 상세보기
			service = new BContentService();
			service.execute(request, response);
			viewPage = "board/content_view.jsp";
			delete = true;
		} else if(command.equals("/modify_view.do")) {
			service = new BModifyViewService();
			service.execute(request, response);
			viewPage = "board/modify_view.jsp";
			modify_view = true;
		} else if(command.equals("/modify.do")) {
			if(modify_view) {
				service = new BModifyService();
				service.execute(request, response);
				modify_view = false;
			}
			viewPage = "list.do";		
		} else if(command.equals("/delete_view.do")) {
			if(delete) {
				service = new BDeleteService();
				service.execute(request, response);
				delete = false;
			}
			viewPage ="list.do";
		} else if(command.equals("/reply_view.do")) {  // 답변글 쓰기 view(form 태그)
			service = new BReplyViewService();
			service.execute(request, response);
			viewPage = "board/reply_view.jsp";
			reply = true;
		} else if(command.equals("/reply.do")) {
			if(reply) {
				service = new BReplyService();
				service.execute(request, response);
				reply = false;
			}
			viewPage = "list.do";
			
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
	
	

}
