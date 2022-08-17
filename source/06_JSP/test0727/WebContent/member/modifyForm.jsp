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
 	<jsp:include page="../main/header.jsp"/>
    <%
    	String custnoStr = request.getParameter("custno");
    	int custno = 0;
    	if(custnoStr != null && !custnoStr.equals("")){
    		custno = Integer.parseInt(custnoStr);
    	}
    	MemberDao dao = MemberDao.getInstance();
    	MemberDto member = dao.getMember(custno);
   		if(member != null){
   	%>
   	<form action="<%=conPath %>/member/modifyPro.jsp" method="post">
		<table>
			<caption>홈쇼핑 회원 수정</caption>
			<tr>
				<th>회원번호(자동발생)</th>
				<td>
					<input type="text" name="custno" value="<%=member.getCustno() %>" readonly="readonly">
				</td>
			</tr>
			<tr>
				<th>회원성명</th>
				<td>
					<input type="text" name="custname" value="<%=member.getCustname() %>" required="required">
				</td>
			</tr>
			<tr>
				<th>회원전화</th>
				<td>
					<input type="text" name="phone" value="<%=member.getPhone() %>" required="required">
				</td>
			</tr>
			<tr>
				<th>회원주소</th>
				<td>
					<input type="text" name="address" value="<%=member.getAddress() %>" required="required">
				</td>
			</tr>
			<tr>
				<th>가입일자</th>
				<td>
					<input type="text" name="joindate" value="<%=member.getJoinDate() %>" readonly="readonly">
				</td>
			</tr>
			<tr>
				<th>
					고객등급<br>
					(A : VIP, B:일반, C:직원)
				</th>
				<td>
					<input type="text" name="grade" value="<%=member.getGrade() %>" required="required">
				</td>
			</tr>
			<tr>
				<th>도시코드</th>
				<td>
					<input type="text" name="city" value="<%=member.getCity() %>" required="required">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="수정">
					<input type="button" value="조회" onclick="location='<%=conPath %>/member/memberList.jsp'">
				</td>
			</tr>
		</table>   	
   	</form>	  	
   	<% 		
   		}
    %>
    		

 	<jsp:include page="../main/footer.jsp"/>
 </body>
</html>
