<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <link href="<%=conPath %>/css/style.css" rel="stylesheet">
  <style>
   
  </style>
</head>
 <body>
 <%
 	boolean outOk = false;  // 
 	Cookie[] cs = request.getCookies();
 if( cs!=null){
	 for(Cookie c : cs){
		 String cname = c.getName();
		 String cvalue = c.getValue();
		 if( cname.equals("id") || cname.equals("name")){
			 out.println("<h3>" + cname + "(쿠키이름) / " + cvalue + " (쿠키값)</h3>");
			 outOk = true;  // count 변수 만들어서 count++ 해서 count가 0이면 생성된쿠키가없다고 해도됨.
		 } // if
	 } // for
 }  
 if ( !outOk) {
	 out.println("<h3>생성된 쿠키가 없습니다.(단, 시스템 쿠키는 제외)</h3>");
 }
 %>	
 	<button onclick="history.back()">이전 페이지</button>
 	<button onclick="location.href='welcome.jsp'">welcome 페이지</button>
    
 </body>
</html>
