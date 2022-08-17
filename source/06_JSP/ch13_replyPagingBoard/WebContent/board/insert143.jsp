<%@page import="com.lec.dto.BoardDto"%>
<%@page import="com.lec.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <link href="<%=conPath%>/css/style.css" rel="stylesheet">
</head>
<body>
<%
	// 임의로 143개 글 insert 하기
	BoardDao dao = BoardDao.getInstance();
	BoardDto dto = new BoardDto();
	for ( int i = 1; i <= 143; i++){
		dto.setWriter("최진영" + i);
		dto.setSubject("글 " + i + " 번째 글 입니다.");
		dto.setContent("본문입니다 " +i);
		dto.setEmail("choi"+i+"@jin.young");
		dto.setPw("1");
		dto.setIp("192.168.10.30");
		int result = dao.insertBoard(dto);
		System.out.println(result == BoardDao.SUCCESS ? i+"번째 글쓰기 성공" : i+"번쨰 글쓰기 실패");
	}
	response.sendRedirect("list.jsp");
%>

</body>
</html>