package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.dao.MemberDao;
import com.lec.dto.MemberDto;

public class MLoginService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		MemberDao dao = MemberDao.getInstance();
		int result = dao.login(mid, mpw);
		if(result == MemberDao.SUCCESS) {
			HttpSession session = request.getSession();
			session.setAttribute("member", dao.loginSuccess(mid));		
			session.setAttribute("mphoto", dao.loginSuccess(mid).getMphoto());
		} else {
			request.setAttribute("loginFail", "아이디와 비밀번호를 확인해주세요.");
		}
		
		
	}

}
