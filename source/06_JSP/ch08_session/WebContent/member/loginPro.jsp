<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <style>
   
  </style>
</head>
 <body>
 <%
 	request.setCharacterEncoding("utf-8");
 	String msg="";
 	String id = request.getParameter("id");
 	String pw = request.getParameter("pw");
	if(id == null || !id.equals("aaa") || pw == null || !pw.equals("111")){
		msg = URLEncoder.encode("id 와 pw를 체크하세요" , "utf-8");
		response.sendRedirect("login.jsp?msg="+msg);
	} else {	
		// 로그인 처리 ( 세션 생성)
		session.setAttribute("name","홍길동");
		session.setAttribute("loginChk","y"); // 이름 : loginChk 값 : y
		response.sendRedirect("main.jsp");
	}
 %>
    
 </body>
</html>
