<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <style>
  	#wrap {
  		border : 1px solid blue;
  		width: 300px;
  		text-align: center;
  	}
  	#wrap p {
  		width:300px;
  		height: 30px;
  		border-bottom: 1px solid blue;
  	}
  	#wrap h3 {
  		text-align: center; 	
  		color:red;	
  	} 
	
   
  </style>
</head>
 <body>
 <div id="wrap">
		 <p>동전이 있는 곳을 맞춰봐</p>	 
 	 <%
 		int where = Integer.parseInt(request.getParameter("where"));
 	 	int su = (int)(Math.random()*3)+1;
 	 	if( where == su){
 	 		out.println("<h3>정답입니다<h3>");
 	 		out.println("동전이 있던 곳은 " + su + "<br>");	 		
 	 	} else {
 	 		String msg = "<h3>Wrong! Try Again!<h3><h3>("+ where + " 은(는) 아니고 정답은 " + su + ")<h3>"; 		
 	 		msg = URLEncoder.encode(msg,"utf-8");	 		
 	 		response.sendRedirect("ex.jsp?msg=" + msg); 	
 	 		
 	 	} 	 	
 	 %>
 	 	<button onclick="location.href='ex.jsp'">다시하기</button>
    </div>
 </body>
</html>
