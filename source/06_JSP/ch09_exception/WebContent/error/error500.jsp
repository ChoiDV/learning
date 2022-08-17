<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true"  %>   <!-- // exception 내부 객체를 사용하기 위함 -->
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <style>
   
  </style>
</head>
 <body>
    <h2>공사중입니다. 빠른 시일내에 복구하겠습니다.</h2>
    <h4>관리자 문의 : 오동준@동준.com </h4>
    <%
    	System.out.println(exception.getMessage());
    	System.out.println(exception.getClass());
    %>
 </body>
</html>
