<%@page import="com.lec.dao.FileBoardDao"%>
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
    	String pageNum = request.getParameter("pageNum");
    	int fnum = Integer.parseInt(request.getParameter("fnum"));
    	String fpw = request.getParameter("fpw");
    	FileBoardDao dao = FileBoardDao.getInstance();
    	int result = dao.deleteBoard(fnum, fpw);
    	if(result == FileBoardDao.SUCCESS){  
    %>	
    		<script>
    			alert('<%=fnum %> 번 글 삭제 성공');
    			location.href='fboardList.jsp.?pageNum=<%=pageNum %>';
    		</script>	
    <% 	} else {%>
    		<script>
    			alert('<%=fnum %> 번 글 삭제 실패. 비번을 확인하세요');
    			history.back();
    		</script>
    <%  } %>	
 </body>
</html>
