<%@page import="com.lec.friend.FriendDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.friend.FriendDao"%>
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
	<jsp:useBean id="dto" class="com.lec.friend.FriendDto" scope="page"/>
	<jsp:setProperty name="dto" property="*"/>
<%
	FriendDao fDao = FriendDao.getInstance();
	if(dto.getName() != null && dto.getPhone() != null){
	int result = fDao.joinFriend(dto);
	if( result == fDao.SUCCESS){ // 친구추가 성공
		out.println("<script>alert('친구추가 성공')</script>");
		out.println("<script>location.href='Friend.jsp'</script>");		
		}
	} else { %>
		<script>
			alert("친구 정보를 입력하세요");
			location.href="Friend.jsp";
		</script>
<% 	} %>

 </body>
</html>
