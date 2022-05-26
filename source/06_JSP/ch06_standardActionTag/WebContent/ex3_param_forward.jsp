<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <style>
   
  </style>
</head>
 <body>
 	<h1>ex3._param_forward 페이지입니다</h1>
 	<jsp:forward page="ex4.jsp">
 		<jsp:param name="id" value="hong"/>
 		<jsp:param name="pw" value="1111"/>
 	</jsp:forward>
    
 </body>
</html>
