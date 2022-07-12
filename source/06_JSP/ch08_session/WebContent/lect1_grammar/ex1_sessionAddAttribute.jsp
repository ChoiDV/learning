<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <style>
   
  </style>
</head>
 <body>
<%
	// 세션에 속성 추가 (객체 타입으로 추가)
	session.setAttribute("sessionName","sessionValue");
						// 세션 이름, 세션 값 (객체)
	session.setAttribute("myNum", 123);
	// session.setAttribute("myNum",new Integer(123));  으로 내부적으로 object타입으로 바꿔줌 	
%>
	<h1>세션에 sessionName 속성 추가 </h1>
	<h1>세션에 myNum 속성 추가 </h1>
	<a href="ex2_sessionGet.jsp">세션 GET</a>
 </body>
</html>
