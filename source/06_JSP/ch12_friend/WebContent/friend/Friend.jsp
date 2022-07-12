<%@page import="com.lec.friend.FriendDao"%>
<%@page import="com.lec.friend.FriendDto"%>
<%@page import="java.util.ArrayList"%>
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
 	<form action="FriendOk.jsp" method="post" name="friendOk">
 		<table>
 			<caption>친구추가</caption>
 			<tr>
 				<th>친구이름</th>
 				<td>
 					<input type="text" name="name">
 				</td>
 				<th>전화</th>
 				<td>
 					<input type="text" name="phone">
 				</td>				
 			</tr> 			
 			<tr>
 				<td colspan="4">
 					<input type="submit" value="나랑 친구하자!!!">
 				</td>
 			</tr>
 			<tr>
 				<td colspan="4">
 					<% 
 					FriendDao fDao = FriendDao.getInstance();
 					ArrayList<FriendDto> friends = null;
 					friends = fDao.getFriend();
 					if(friends != null){
 						for(FriendDto f : friends){
 							out.println("<h4>번호 : "+f.getNo()+", 이름 : "+f.getName()+" , 전화번호 : "+f.getPhone()+"</h3><br>");
 						}
 					} 
 					%>
 				</td>
 			</tr>
 		</table>
 	</form>
    
 </body>
</html>
