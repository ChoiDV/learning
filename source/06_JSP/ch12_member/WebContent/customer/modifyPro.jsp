<%@page import="com.lec.customer.CustomerDao"%>
<%@page import="com.lec.customer.CustomerDto"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>

</head>
 <body>
 	<%
		request.setCharacterEncoding("utf-8");
	%>
	<jsp:useBean id="dto" class="com.lec.customer.CustomerDto" />
	<jsp:setProperty name="dto" property="*" />
	<%
		String cBirth = request.getParameter("tempbirth");
	if (!cBirth.equals("")) {
		dto.setcBirth(Date.valueOf(cBirth));
	}
	CustomerDto customer = (CustomerDto) session.getAttribute("customer");
	String sessionPw = null;
	if (customer != null) {
		sessionPw = customer.getcPw(); 
	}
	String oldPw = request.getParameter("oldPw");
	if (sessionPw.equals(oldPw)) { 	
		if (dto.getcPw() == null) {
			dto.setcPw(sessionPw);
		}
		CustomerDao dao = CustomerDao.getInstance();
		int result = dao.modifyCustomer(dto);
		if (result == CustomerDao.SUCCESS) { 
			session.setAttribute("customer", dto); 
%>
	<script>
		alert("회원정보 수정이 완료되었습니다.");
		location.href="main.jsp";
	</script>
<%			
		} else { //수정실패  %> 
	<script>
		alert("회원정보 수정이 실패되었습니다. 정보가 너무 깁니다.");
		history.back();
	</script>		
<% 		}
	} else { 
	%>
	<script>
		alert("현재 비밀번호가 바르지 않습니다. 확인해주세요.");
		history.back();
	</script>
	<%
		}
	%>   
 </body>
</html>
