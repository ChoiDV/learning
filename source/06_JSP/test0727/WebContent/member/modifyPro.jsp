<%@page import="com.lec.dao.MemberDao"%>
<%@page import="com.lec.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <link href="${conPath }/css/style.css" rel="stylesheet" type="text/css">
</head>
 <body>
    <%
		request.setCharacterEncoding("utf-8");    
    %>
    <%
		String custnoStr = request.getParameter("custno");
		int custno = 0;
		if(custnoStr != null && !custnoStr.equals("")){
			custno = Integer.parseInt(custnoStr);
		}
		String custname = request.getParameter("custname");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String grade = request.getParameter("grade");
		String city = request.getParameter("city");
		MemberDto member = new MemberDto(custno, custname, phone, address, null, grade, null, city, 0 );
		MemberDao dao = MemberDao.getInstance();
		int result = dao.updateMember(member);
		if(result == 1){
	%>
		<script>
			alert('수정완료 되었습니다');
			location="../main/main.jsp";
		</script>
	<% 	
		} else {
	%>
		<script>
			alert('수정 실패');
			history.back();	
		</script>
	<% 		
		}
	%>
 </body>
</html>
