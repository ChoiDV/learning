package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SelectService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// select 로직
		// int currentPage;
		// ArrayList<Dto> dtos = dao.list(startRow, endRow);
		// int pageCnt, startPage, endPage
		request.setAttribute("list", "list 결과");
		
		// 여기 로직이 끝나면 다시 frontController로 간다.
		
	}

}
