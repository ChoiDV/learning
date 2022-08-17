<%@page import="com.lec.dto.MemberDto"%>
<%@page import="com.lec.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %> 
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath%>/css/join.css" rel="stylesheet">
</head>
 <body>
    <%request.setCharacterEncoding("utf-8");%>
	<%	
		String custname = request.getParameter("custname");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String grade = request.getParameter("grade");
		String city = request.getParameter("city");
		MemberDto member = new MemberDto(0, custname, phone, address, null, grade, null, city, 0);
		MemberDao dao = MemberDao.getInstance();
		int result = dao.insertMember(member);
		if(result == MemberDao.SUCCESS){
	%>
		<script>
			alert('회원등록 성공');
			location="<%=conPath %>/member/memberList.jsp";
		</script>
	<% 		
		} else {
	%>
		<script>
			alert('회원등록 실패');
			history.back();
		</script>
	<%		
		}
	%>
 </body>
</html>
