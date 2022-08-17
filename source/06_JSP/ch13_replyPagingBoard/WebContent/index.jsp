<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>

</head>
 <body>
    <%-- <jsp:forward page="board/list.jsp"/> --%>   <!-- 얘를 사용하면 경로들 앞에 conPath를 넣어주어야함  -->
   <% response.sendRedirect("board/list.jsp");  // 얘로 하면 conPath 넣어주지 않아도 됌. %>
 </body> 
</html>
