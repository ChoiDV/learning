<%@page import="com.lec.dao.BoardDao"%>
<%@page import="com.lec.dto.BoardDto"%>
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
	int num = 0;
	BoardDto dto = new BoardDto();
	String pageNum = request.getParameter("pageNum"); // 원글쓰기에선 pageNum = null이 됨 들어오지않기때문에
	if (pageNum == null){
		pageNum = "1"; // 즉 원글쓰기로 들어옴
	} 
	if (request.getParameter("num") != null){ // num이 null이 아니란소리는 답변글이라는 소리  즉, 답변글을 위해 들어왔다면 원글의 정보를 dto에 넣어줘야함
		num = Integer.parseInt(request.getParameter("num"));
		BoardDao dao = BoardDao.getInstance();
		dto = dao.getBoardOneLine(num); // 원글에 대한 정보를 dto에 받아옴 우리는 dto에 있는 ref, re_step, re_indent 가 필요함
		System.out.println("writeForm.jsp에서 원글의 ref : " + dto.getRef());
		System.out.println("writeForm.jsp에서 원글의 re_step : " + dto.getRe_step());
		System.out.println("writeForm.jsp에서 원글의 re_indent : " + dto.getRe_indent());
	}
%>
    <form action="writePro.jsp" method="post">
    	<input type="hidden" name="pageNum" value="<%=pageNum %>">
    	<input type="hidden" name="num" value="<%=num %>" >   <!--  num이 0이면 원글이란 소리 -->
    	<input type="hidden" name="ref" value="<%=dto.getRef() %>">
    	<input type="hidden" name="re_step" value="<%=dto.getRe_step() %>">
    	<input type="hidden" name="re_indent" value="<%=dto.getRe_indent() %>">  <!--  원글이면 다 0이 들어갈것이고 답변글이면 각각의 값들이 들어감  -->
    	<table>
    		<caption>게시판</caption>
    		<tr>
    			<th>작성자</th>
    			<td>
    				<input type="text" name="writer" required="required">
    			</td>
    		</tr>
    		<tr>
    			<th>제목</th>
    			<td>
    				<input type="text" name="subject" required="required" value="<%
    					if(dto.getSubject() != null) {  // 제목이 null이 아니라면 답변글이라는 소리
    						 out.println("답 : " + dto.getSubject());
    					}
    				%>">
    			</td>
    		</tr>
    		<tr>
    			<th>이메일</th>
    			<td>
    				<input type="email" name="email">
    			</td>
    		</tr>
    		<tr>
    			<th>본문</th>
    			<td>
    				<textarea name="content" rows="5" cols="5" required="required"></textarea>
    			</td>
    		</tr>
    		<tr>
    			<th>비밀번호</th>
    			<td>
    				<input type="password" name="pw" required="required">
    			</td>
    		</tr>
    		<tr>
    			<td colspan="2">
    				<input type="submit" value="글쓰기" class="btn">
    				<input type="reset" value="취소" class="btn">
    				<input type= "button" value="목록"
    					onclick="location.href='list.jsp?pageNum=<%=pageNum %>'"> 
    			</td>
    		</tr>		
    	</table> 	
    </form>
 </body>
</html>
