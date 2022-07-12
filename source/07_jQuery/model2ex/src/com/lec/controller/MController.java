package com.lec.controller;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.service.ALoginService;
import com.lec.service.BoardContentService;
import com.lec.service.BoardListSerivce;
import com.lec.service.BoardReplyService;
import com.lec.service.BoardReplyViewService;
import com.lec.service.BoardWriteService;
import com.lec.service.MAllViewService;
import com.lec.service.MJoinService;
import com.lec.service.MLoginService;
import com.lec.service.MLogoutService;
import com.lec.service.MModifyService;
import com.lec.service.MWithdrawalService;
import com.lec.service.MemailConfirmService;
import com.lec.service.MidConfirmService;
import com.lec.service.Service;
@WebServlet("*.do")
public class MController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private boolean writeView = false;
	private boolean replyView = false;
	private boolean memberLoginView = false;
	private boolean adminLoginView = false;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		actionDo(request, response);
	}
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com     = uri.substring(conPath.length()); // 들어온 요청
		String viewPage = null;
		Service service = null;
		if(com.equals("/main.do")) { // 첫화면
			viewPage = "main/main.jsp"; 
		/* * * * * * * * * * *  * * * * * * * * * * * *
		 * * * * * * * * * member 관련 요청  * * * * * * *
		* * * * * * * * * * *  * * * * * * * * * * * * */
		}else if(com.equals("/joinView.do")) { // 회원가입 화면
			viewPage = "member/join.jsp";
		}else if(com.equals("/idConfirm.do")) {
			service = new MidConfirmService();
			service.execute(request, response);
			viewPage = "member/idConfirm.jsp";
		}else if(com.equals("/emailConfirm.do")) {
			service = new MemailConfirmService();
			service.execute(request, response);
			viewPage = "member/emailConfirm.jsp";
		}else if(com.equals("/join.do")) { // 회원가입 DB 처리
			service = new MJoinService(); // execute메소드 : mId중복체크 후 회원가입
			service.execute(request, response);
			viewPage = "loginView.do";
		}else if(com.equals("/loginView.do")) { // 로그인 화면
			viewPage = "member/login.jsp";
			memberLoginView = true;
		}else if(com.equals("/login.do")) { // 로그인 DB 및 세션 처리
			if(memberLoginView) {
				service = new MLoginService();
				service.execute(request, response);
				memberLoginView = false;
			}
			viewPage = "main/main.jsp";
		}else if(com.equals("/logout.do")) {//로그아웃 - 세션 날리기
			service = new MLogoutService();
			service.execute(request, response);
			viewPage = "main/main.jsp";
		}else if(com.equals("/modifyView.do")) { // 정보 수정 화면
			viewPage = "member/modify.jsp";
		}else if(com.equals("/modify.do")) { // DB에 정보 수정
			service = new MModifyService();
			service.execute(request, response);
			viewPage = "main/main.jsp";
		}else if(com.equals("/allView.do")) { // 회원목록가져오기
			service = new MAllViewService();
			service.execute(request, response);
			viewPage = "member/mAllView.jsp";
		}else if(com.equals("/withdrawal.do")) { // 회원탈퇴
			service = new MWithdrawalService();
			service.execute(request, response);
			viewPage = "member/main.jsp";
		}else if(com.equals("/list.do")) {  // 고객센터 클릭시 FileBoard 게시판 
			service = new BoardListSerivce();
			service.execute(request, response);
			viewPage = "freeBoard/boardList.jsp";
		}else if(com.equals("/boardWriteView.do")) {
			viewPage = "freeBoard/boardWrite.jsp";
			writeView = true;
		}else if(com.equals("/boardWrite.do")) {
			if(writeView) {
				service = new BoardWriteService();
				service.execute(request, response);				
				writeView = false;
			}
			viewPage = "list.do";
		}else if(com.equals("/boardContent.do")) {
			service = new BoardContentService();
			service.execute(request, response);
			viewPage = "freeBoard/boardContent.jsp";			
		}else if(com.equals("/boardReplyView.do")) {
			service = new BoardReplyViewService();
			service.execute(request, response);
			viewPage = "freeBoard/boardReply.jsp";
			replyView = true;
		}else if(com.equals("/boardReply.do")) {
			if(replyView) {
				service = new BoardReplyService();
				service.execute(request, response);
				replyView = false;
			}
			viewPage = "list.do";
		}else if(com.equals("/adminLoginView.do")) {
			viewPage = "admin/adminLogin.jsp";
			adminLoginView = true;
		}else if(com.equals("/adminLogin.do")) {
			if(adminLoginView) {
				service = new ALoginService();
				service.execute(request, response);
				adminLoginView = false;
			}
			viewPage = "allView.do";		
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
}