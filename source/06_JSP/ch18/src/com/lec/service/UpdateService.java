package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// update 로직
		// int result = dao.update(dto);
		int result = 1;
		request.setAttribute("updateResult", result);

	}

}
