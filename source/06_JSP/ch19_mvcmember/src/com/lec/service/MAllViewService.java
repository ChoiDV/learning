package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.dao.MemberDao;

public class MAllViewService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null) {
			pageNum="1";
		}
		int currentPage = Integer.parseInt(pageNum);  // 현재 페이지 int로 형변환해서 currentPage에 넣기
		final int PAGESIZE = 3;   // 한페이지에 글 10개씩 
		final int BLOCKSIZE = 5;  // 한페이지에 페이지 블럭이 10개씩 나오게 1 2 3 4 ... 10 [다음] 이렇게
		int startRow = (currentPage -1) * PAGESIZE + 1;
		int endRow = startRow + PAGESIZE -1;
		MemberDao dao = MemberDao.getInstance();
		request.setAttribute("list", dao.listMember(startRow, endRow));
		// 이렇게 바로 value 로 dao.listBoard(startRow, endRow)); 넣어줘도 똑같음
		//  그럼  value 값으로 ArrayList 들어감.
		int totalCnt = dao.totalMember(); // 등록된 글 개수
		int pageCnt = (int)Math.ceil((double)totalCnt/PAGESIZE); // 페이지 수
		int startPage = ((currentPage -1 )/BLOCKSIZE) * BLOCKSIZE +1;
		int endPage = startPage + BLOCKSIZE - 1;
		if(endPage > pageCnt) {
			endPage = pageCnt;
		}
		// 반드시 request에 담아야 하는것들  startPage, endPage, currentPage , BLOCKSIZE, pageCnt
		request.setAttribute("BLOCKSIZE", BLOCKSIZE);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("pageNum", currentPage);  // currentPage넣는 이유 : int형을 넘겨주기 위해서?
		request.setAttribute("pageCnt", pageCnt);	

	}

}
