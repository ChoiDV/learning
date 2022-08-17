<%@page import="com.lec.dao.MemberDao"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
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
 	<%
 		SimpleDateFormat sdft = new SimpleDateFormat("YYYYMMdd");
 		String date = sdft.format(new Date());
 		MemberDao dao = MemberDao.getInstance();
 		int maxno = dao.maxNo();
 	%>
   	<jsp:include page="../main/header.jsp"/>
   	<form action="<%=conPath %>/member/insertPro.jsp" method="post">
		<table>
			<caption>홈쇼핑 회원 등록</caption>
			<tr>
				<th>회원번호(자동발생)</th>
				<td>
					<input type="text" name="custno" value="<%=maxno %>" readonly="readonly">
				</td>
			</tr>
			<tr>
				<th>회원성명</th>
				<td>
					<input type="text" name="custname" required="required">
				</td>
			</tr>
			<tr>
				<th>회원전화</th>
				<td>
					<input type="text" name="phone" required="required">
				</td>
			</tr>
			<tr>
				<th>회원주소</th>
				<td>
					<input type="text" name="address" required="required">
				</td>
			</tr>
			<tr>
				<th>가입일자</th>
				<td>
					<input type="text" name="joindate" value="<%=date %>" readonly="readonly">
				</td>
			</tr>
			<tr>
				<th>
					고객등급<br>
					(A : VIP, B:일반, C:직원)
				</th>
				<td>
					<input type="text" name="grade" required="required">
				</td>
			</tr>
			<tr>
				<th>도시코드</th>
				<td>
					<input type="text" name="city" required="required">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="등록">
					<input type="button" value="조회" onclick="location='<%=conPath %>/member/memberList.jsp'">
				</td>
			</tr>
		</table>   	
   	</form>	 
 	<jsp:include page="../main/footer.jsp"/>
 </body>
</html>
