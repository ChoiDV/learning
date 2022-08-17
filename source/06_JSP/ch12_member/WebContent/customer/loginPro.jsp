<%@page import="com.lec.customer.CustomerDto"%>
<%@page import="com.lec.customer.CustomerDao"%>
<%@page import="java.net.URLEncoder"%>
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
 	request.setCharacterEncoding("utf-8");
 	String cId = request.getParameter("cId");
 	String cPw = request.getParameter("cPw");
 	CustomerDao dao = CustomerDao.getInstance();
 	int result = dao.loginCheck(cId, cPw);
 	if( result == CustomerDao.SUCCESS){ // 로그인 성공
 		CustomerDto customer = dao.getCustomer(cId);
 		session.setAttribute("customer", customer);
 		session.setAttribute("cname", customer.getcName());
 		session.setAttribute("loginChk","y");
 		response.sendRedirect("main.jsp");  
 	} else  { // 비밀번호 오류
 %>		<script>
 			alert("아이디와 비밀번호를 확인하세요");
<% 			String msg = URLEncoder.encode("id 와 pw를 체크하세요" , "utf-8"); 
			response.sendRedirect("login.jsp?msg="+msg);
%> 			
 		</script>			
 <% 	} %>		
 
    
 </body>
</html>
