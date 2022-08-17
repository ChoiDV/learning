<%@page import="com.lec.dao.CustomerDao"%>
<%@page import="com.lec.dto.CustomerDto"%>
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
		String cid = request.getParameter("cid");
		String cpw = request.getParameter("cpw");
		CustomerDao dao = CustomerDao.getInstance();
		CustomerDto customer = dao.getCustomer(cid);
		int result = dao.loginCheck(cid, cpw);
		if(result == 1){  // 로그인 성공 %>
			<script>
				<%session.setAttribute("customer", customer); %>
				alert('로그인 성공');
				location.href="../main/main.jsp";
			</script>
<% 		} else {  // 로그인 실패  %>
			<script>
				alert('id와 pw를 확인해주세요.');
				location.href="loginForm.jsp";
			</script>
<% 		} %>
		
	
</body>
</html>