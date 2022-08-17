<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <link href="<%=conPath %>/css/header.css" rel="stylesheet" type="text/css">
  <style>
   
  </style>
</head>
 <body>
    <header>
 		<div id="nav">
 			<%
 				String loginChk = (String)session.getAttribute("loginChk");	
 				String cName = (String)session.getAttribute("cname");
 			%>			
 			<% if( loginChk == null){  // 로그인 전 헤더 메뉴  %>  
 				<ul>
 					<li><a href="<%=conPath %>/customer/join.jsp">회원가입</a>
 					<li><a href="<%=conPath %>/customer/login.jsp">로그인</a>
 					<li><a href="<%=conPath %>/customer/main.jsp">홈</a>
 				</ul>
 				<% } else { %>
 				<ul>
 					<li><a href="<%=conPath %>/customer/logout.jsp">로그아웃</a>
 					<li><a href="<%=conPath %>/customer/modify.jsp">정보 수정</a>
 					<li><a href="#"><%=cName %> 님</a>
 				</ul>	
 				<% } %>	
 			
 			
 		</div>
 	</header> 
 </body>
</html>
