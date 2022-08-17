<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Date"%>
<%@page import="com.lec.customer.CustomerDao"%>
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
%>
	<jsp:useBean id="dto" class="com.lec.customer.CustomerDto" scope="page"/>
	<jsp:setProperty name="dto" property="*"/>
<% 	
	String cBirth = request.getParameter("tempbirth");	 
	if( !cBirth.equals("")){
		dto.setcBirth(Date.valueOf(cBirth)); 
	}
	CustomerDao dao = CustomerDao.getInstance();
	int result = dao.comfirmId(dto.getcId()); // ID 중복체크
	if(result == 1 ){ // 사용가능한 ID
		result = dao.joinMember(dto); // 회원가입 
		if ( result == CustomerDao.SUCCESS){ // 회원가입 성공
			session.setAttribute("cid", dto.getcId());	
%>	    
<script>
			alert("회원가입 감사합니다. 로그인 후 서비스를 이용해주세요.");
			location.href="login.jsp";
		</script>
<% 		} else {  %>
		<script>
			alert('회원가입 실패되었습니다. 너무 긴 데이터는 가입 불가합니다. 다시 가입해주세요.');
			location.href='join.jsp';  
		</script>
<% 		}
	} else { // 중복된 ID	
%>
	<script>
		alert("중복된 ID입니다. 다른 아이디를 사용하세요");
		history.back();
	</script>
	<% } %>
 </body>
</html>
