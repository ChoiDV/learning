package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.dao.AdminDao;
import com.lec.dto.AdminDto;

public class ALoginService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {		
		String aId = request.getParameter("aId");
		String aPw = request.getParameter("aPw");
		AdminDao dao = AdminDao.getInstance();
		int result = dao.adminLogin(aId, aPw);
		if(result == AdminDao.SUCCESS) {
			HttpSession session = request.getSession();
			AdminDto admin = dao.getAdmin(aId);
			request.setAttribute("adminLoginResult", "관리자 로그인 성공");
			session.setAttribute("admin", admin);
		} else {
			request.setAttribute("adminLoginResult", "관리자 아이디와 비밀번호를 확인해주세요.");
			request.setAttribute("adminLoginError", "관리자 아이디와 비밀번호를 확인해주세요.");
		}
	}

}
