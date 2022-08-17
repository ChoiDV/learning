<%@page import="com.lec.dto.CustomerDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <link href="<%=conPath%>/css/header.css" rel="stylesheet">
</head>
 <body> <%-- .gnb(로그인전/로그인 후 ) - .logo  -.lnb(도서보기, 도서 등록(로그인 후에만))  --%>
	<header>
		<div class="gnb">
			<% if (session.getAttribute("customer") == null ){  // 로그인 전 %>
					<!-- 로그인 전 메뉴(우측부터) : 고객센터, 회원가입, 로그인 -->	
				<ul>
					<li><a href="<%=conPath %>/fileboard/fboardList.jsp">고객센터</a></li>
					<li><a href="<%=conPath %>/customer/joinForm.jsp">회원가입</a></li>
					<li><a href="<%=conPath %>/customer/loginForm.jsp">로그인</a></li>
				</ul>
			<% } else { %>  
					<!--  로그인 후 메뉴(우측부터) : 고객센터, 로그아웃, 정보수정  , 고객이름 -->
				<ul>
					<li><a href="<%=conPath %>/fileboard/fboardList.jsp">고객센터</a></li>
					<li><a href="<%=conPath %>/customer/logout.jsp">로그아웃</a></li>
					<li><a href="<%=conPath %>/customer/modifyForm.jsp">정보수정</a></li>
					<li><a href="#"><%=((CustomerDto) session.getAttribute("customer")).getCname() %> 님 </a>
				</ul>		
			<% } %>
		</div>
		<div class="logo" onclick="location.href='<%=conPath %>/main/main.jsp'">
			<img src="https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png">
		</div>
		<div class="lnb">
			<!--  우측부터 메뉴 : 도서보기, 도서등록 ( 로그인 후에만 보여야함) -->
			<ul>
				<li><a href="<%=conPath %>/book/ex3_list_productp.jsp">도서보기</a></li>
				<% if(session.getAttribute("customer")!= null){ %>
				<li><a href="<%=conPath %>/book/ex1_bookRegisterForm.jsp">도서등록</a></li>
				<% } %>
			</ul>
		</div>
	</header>    
 </body>
</html>
