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
 <!--  ex1_forward.jsp?n=1 -->
 <!--  jsp 뒤에 ? 의 의미는 전달할 파라미터가 있다는 표시  -->
 <h2>ex1_forward.jsp 페이지입니다.</h2>
 <% response.sendRedirect("ex2_forward.jsp"); %>  <!--  얘로 실행하면 request를 새롭게 만들어서 전달하기때문에 파라미터가 사라짐  -->
 <jsp:forward page="ex2_forward.jsp"/> <!--  얘로 실행하면 내가 전달받은파라미터를 그대로 전달해줌  -->
 
    
 </body>
</html>
