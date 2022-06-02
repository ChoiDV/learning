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
	<script>
		function search(){
			var name = frm.name.value;
			var phone = frm.phone.value;
			location.href = 'Friend.jsp?name='+name+'&phone='+phone;
		}  
	</script>
 <body>
 	<%
 		String name = request.getParameter("name");
 		String phone = request.getParameter("phone");
 	%>
 	<form action="FriendOk.jsp" method="get" name="frm">
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
 					<input type="button" value="검색" onclick="search()">
 					<input type="submit" value="나랑 친구하자!!!">
 				</td>
 			</tr>
 			<tr>
 				<td colspan="4">
 					<% 
 					FriendDao fDao = FriendDao.getInstance();
 					ArrayList<FriendDto> friends = fDao.searchFriend(name, phone);
 					if(!friends.isEmpty()){//데이터가 들어있으면 true
 						for(FriendDto f : friends){
 							out.println("<h4>번호 : "+f.getNo()+", 이름 : "+f.getName()+" , 전화번호 : "+f.getPhone()+"</h3><br>");
 						}
 					} else{//없을 경우 
 						out.println("없습니다");
 					}
 					%>
 				</td>
 			</tr>
 		</table>
 	</form>
    
 </body>
</html>
