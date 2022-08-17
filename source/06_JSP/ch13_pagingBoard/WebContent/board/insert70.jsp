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
    	// 임의로 글 70개 insert(원글) 하기
    	BoardDao dao = BoardDao.getInstance();
    	BoardDto dto = new BoardDto();
    	for(int i = 154 ; i < 500; i++){
    		dto.setWriter("최진영 "+i);
    		dto.setSubject("제목 "+i+" 입니다.");
    		dto.setContent("본문 "+ i + " 입니다.");
    		dto.setEmail("choi"+i+"@choi.com");
    		dto.setPw("1");
    		dto.setIp("192.168.10."+i);
    		int result = dao.insertBoard(dto);
    		if( result == BoardDao.SUCCESS){
    			System.out.println("성공"+i);
    		}
    		// System.out.println(result == BoardDao.SUCCESS ? i+" 번째 글쓰기 성공" : i + " 번째 글쓰기 실패");
    	}
    %>
 </body>
</html>
