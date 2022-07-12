<%@page import="com.lec.dto.BoardDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String conPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=conPath%>/css/style.css" rel="stylesheet">
</head>
<body>
	<table>
		<caption>게시판</caption>
		<tr>
			<td><a href="<%=conPath%>/board/writeForm.jsp">글쓰기</a></td>
		</tr>
	</table>
	<table>
		<tr>
			<th>글번호</th>
			<th>작성자</th>
			<th>글제목</th>
			<th>메일</th>
			<th>조회수</th>
		</tr>
		<%
		/***************************************************************************************************/
		// list.jsp 또는 list.jsp?pageNum=11 또는 list.jsp?pageNum=1 이런식으로 호출이 일어날거임
		final int PAGESIZE = 10, BLOCKSIZE = 10; // 변하지않는 수들 선언 final 대문자로
		// PAGESIZE 는 한페이지에 나오는 개수
		// BLOCKSIZE는 밑에 나오는 페이지 개수
		String pageNum = request.getParameter("pageNum");
		if (pageNum == null) {
			pageNum = "1"; // 전달 받은 pageNum 파라미터가 없으면 1페이지로 ( 처음 들어갔을때는 1페이지 )
		}
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage - 1) * PAGESIZE + 1; // 시작 글 번호
		int endRow = startRow + PAGESIZE - 1; // 끝 글 번호  즉 startRow 부터 endRow 까지 출력되게 하기
		//       startRow 가 21이면  21 + 10 - 1 = 30    21~30 까지 10개 출력
		/***************************************************************************************************/
		BoardDao dao = BoardDao.getInstance();
		int totalCnt = dao.getBoardTotalCnt(); // 등록된 글 갯수
		if (totalCnt == 0) {
			out.println("<tr><td colspan='5'>등록된 글이 없습니다.</td></tr>");
		} else {
			ArrayList<BoardDto> dtos = dao.listBoard(startRow, endRow);
			for (BoardDto dto : dtos) {
				out.println("<tr><td>" + dto.getNum() + "</td>"); // 글번호 
				out.println("<td>" + dto.getWriter() + "</td>"); // 글 작성자
				// 글 제목 
				out.println("<td class = left>");
				// 답변글 들여쓰기 - re.gif 출력
				if(dto.getRe_indent() > 0 ){  // 0보다 크면 답변글이 있다는 소리?
					int width = (dto.getRe_indent()-1) * 10;
					// <imf src='../img/level.gif' wieth=wieth,height = '10'>
					// <img src='../img/re.gif' width=width, height='10' > 
					out.println("<img src='../img/level.gif' width='"+width+"'height='10'>");
					out.println("<img src='../img/re.gif'>");
				}
				
				// 조회수가 10초과시 hot.gif 이미지 출력
				if (dto.getReadcount() > 10) {
			out.println("<img src='" + conPath + "/img/hot.gif'>");
				}
				// <a href='content.jsp?num=글번호&pageNum=현페이지수'>글제목 </a>
				out.println("<a href='" + conPath + "/board/content.jsp?num=" + dto.getNum() + 
										"&pageNum="+pageNum+"'>"
											+ dto.getSubject() + "</a></td>");
				// 메일 조회수
				out.println("<td>" + (dto.getEmail() != null ? dto.getEmail() : "") + "</td>");
				out.println("<td>" + dto.getReadcount() + "</td></tr>");
			}
		}
		%>
	</table>
	<div class="paging">
	<%
		int pageCnt = (int)Math.ceil((double)totalCnt / PAGESIZE); // 페이지 개수 ( 다음 블록 여부)
		int startPage = ((currentPage-1)/BLOCKSIZE)* BLOCKSIZE+1; // 현재 블록에서 시작 페이지
		int endPage = startPage + BLOCKSIZE - 1;   // 현재 블록에서 마지막 페이지
		if(endPage > pageCnt){
			endPage = pageCnt;  // endPage가 페이지 총 개수보다 크면 페이지 총개수가 endPage가 된다.
								// 끝이라는 뜻이니까
		}
		if ( startPage > BLOCKSIZE){ // 이전 블록이 있는지 여부
			// 밑의 페이지 목록에서 시작페이지가 2이면 이전 페이지가 없어야하고
			//  11이면 1~10 페이지가 있어야하니 이전페이지가 있어야함
			out.println("[ <a href='list.jsp?pageNum="+1+"'>처음 블록</a> ]");
			out.println("[ <a href='list.jsp?pageNum="+(startPage-1)+"'>이전 블록</a> ]"); // startPage - PAGESIZE 하면 이전블록 누르면 전 블록에서 첫번째 페이지로 
		}
		for(int i=startPage; i <= endPage; i++){
			if( i == currentPage){ // i와 페이지가 같으면 페이지 수만 출력 ( a 태그 안넣고)(현재 페이지 빨간색 글씨로)
				out.println("[ <b>"+i+"</b> ]");
			} else{  // a 태그를 포함한 페이지 수 출력
				out.println("[ <a href='list.jsp?pageNum="+i+"'>"+i+"</a> ]");
			}
		}
		if(endPage < pageCnt){
			out.println("[ <a href='list.jsp?pageNum="+(endPage+1)+"'>다음 블록</a> ]");
			out.println("[ <a href='list.jsp?pageNum="+(pageCnt)+"'>맨끝 블록</a> ]");
		}		
	%>
	</div>

</body>
</html>
