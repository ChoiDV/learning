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
 <body> <!-- 127.0.0.1 -->
 	<h2>요청한 곳의 주소 : ★ <%= request.getRemoteAddr() %></h2>
     <!--  추후에 데이터베이스 저장할때 이것을 사용해서 작성자의 ip주소를 저장함 -->
    <h2>컨텍스트 path : ★ <%= request.getContextPath() %></h2>
    <h2>요청 방식 :  <%= request.getMethod() %></h2>
    <h2>세션객체 :  ★ <%= request.getSession() %></h2>
    <h2>요청 URL :  <%= request.getRequestURL() %></h2>
    <h2>요청 URI : ★ <%= request.getRequestURI() %></h2>
    <h2>해당 프로토콜 : <%= request.getProtocol() %></h2>
    <h2>서버 이름 : <%= request.getServerName() %></h2>
    <h2>포트번호 : <%= request.getServerPort() %></h2>
 </body>
</html>
