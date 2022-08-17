<%@page import="com.lec.dao.CustomerDao"%>
<%@page import="com.lec.dto.CustomerDto"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String conPath = request.getContextPath();
%>
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
	%>
	<jsp:useBean id="customer" class="com.lec.dto.CustomerDto" scope="page" />
	<jsp:setProperty property="*" name="customer" />
	<%
		String tempbirth = request.getParameter("tempbirth");
	if (tempbirth != null) {
		customer.setCbirth(Date.valueOf(tempbirth));
	}
	// customer에 joinForm.jsp 에서 입력한것들을 다 집어넣음
	// 이제 id 중복체크후 회원가입 진행
	CustomerDao dao = CustomerDao.getInstance();
	int result = dao.confirmCid(customer.getCid());
	if( result == CustomerDao.CUSTOMER_NONEXISTENT){
		// 아이디 없음 회원가입 진행
		result = dao.insertCustomer(customer);
		if(result == CustomerDao.SUCCESS){
			// 회원가입 성공
			session.setAttribute("cid", customer.getCid());  // 로그인창에 보내줄 세션 생성
			session.setAttribute("cpw", customer.getCpw());  // 정보수정에서 원래 pw가 필요하니까 생성해주기 
%>			
			<script>
				alert('회원가입 성공! 로그인 페이지로 이동합니다.');
				location.href="loginForm.jsp";
			</script>
<% 		} else {  
 			// 회원가입 실패
%>
			<script>
				alert('회원가입 실패 유효한 입력값이 아닙니다.');
				history.back();
			</script>			
<% 		}  
	} else {
		// 중복된 아이디 회원가입 진행 불가
%>		
		<script>
			alert('중복된 아이디 입니다. 아이디를 다시 입력해주세요.');
			history.back();
		</script>
<% 	} %>
	
	

</body>
</html>