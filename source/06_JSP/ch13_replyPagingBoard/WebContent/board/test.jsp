<%@page import="com.lec.dto.BoardDto"%>
<%@page import="java.util.ArrayList"%>
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
 	<a href="xx.jsp">xx</a>
<%--
	BoardDao bDao = BoardDao.getInstance();
	out.println("<h2>1. DB 글 갯수 : " + bDao.getBoardTotalCnt() + "개 입니다.</h2>");
	out.println("<h2>2. 글목록</h2>");
	ArrayList<BoardDto> dtos = bDao.listBoard();
	for(BoardDto dto : dtos){
		out.println("<h3>"+dto+"</h3>");
	}
	out.println("<h2>3. 원글 쓰기 </h2>");
	BoardDto dto = new BoardDto(0,"서예린","1등할거야!" , "안녕하세요 저는 1등을 할거에요 \n다 비켜주세요",null,0,"1",0,0,0,"127.0.0.2",null);
	int result = bDao.insertBoard(dto);
	if( result == bDao.SUCCESS){
		out.println("<h3>글쓰기 성공</h3>");
	} else {
		out.println("<h3>글쓰기 실패</h3>");
	}
	
	out.println("<h2>4와 5. 조회수 올리고 글번호로 dto 가져오기</h2> ");
	bDao.readcountUp(7);
	dto = bDao.getBoardOneLine(7);
	out.println(dto);
	
	out.println("<h2> 6. 글수정 </h2>");
	dto.setSubject("바꿀 제목xxxx");
	dto.setContent("바뀐 본문yyyyy");
	result = bDao.updateBoard(dto);
	if( result == BoardDao.SUCCESS){
		dto = bDao.getBoardOneLine(7);
		out.println("수정 후의 7번 글 : " + dto ); 
	} else {
		out.println("수정 실패");
	}
	
	out.println("<h2> 7. 글 삭제 </h2>");
	result = bDao.deleteBoard(7,"1111");
	out.println(result == bDao.SUCCESS ? " 7번글 삭제 성공" : "7번글 삭제 실패 (비밀번호 틀림)");
	result = bDao.deleteBoard(7,"1");
	out.println(result == bDao.SUCCESS ? " 7번글 삭제 성공(비번 맞음)" : "7번글 삭제 실패 (비밀번호 틀림)");
	
	
	
	
--%>    

 </body>
</html>
