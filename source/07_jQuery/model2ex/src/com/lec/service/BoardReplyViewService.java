package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.dao.FileBoardDao;

public class BoardReplyViewService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int fId = Integer.parseInt(request.getParameter("fId"));
		String pageNum = request.getParameter("pageNum");
		FileBoardDao dao = FileBoardDao.getInstance();
		request.setAttribute("BoardDto", dao.viewContent(fId));
		request.setAttribute("pageNum", pageNum);
		

	}

}
