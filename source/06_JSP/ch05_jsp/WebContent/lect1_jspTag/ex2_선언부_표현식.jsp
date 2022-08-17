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
 <%  // 여기는 자바라서 0으로 초기화 안해줌 
 	int j = 0; 
 	i++; j++;
 	strBuf.append("<span>♥</span>");
 	out.println("strBuf = " + strBuf+ "<br>");
  	out.println("sum(5,2) = " + sum(5,2) + "<br>");
 %>
  	전역변수 i = <%= i %><br>
  	지역변수 j = <%= j %><br>
  	strBuf = <%=strBuf %><br> 	
 
 <%!  // <선언부>  위에다 적어도 되고 아래에 적어도되고 위치 상관없음.
 	int i; // 처음에 0으로 초기화
 	// int i =0; 과 똑같음
 	StringBuffer strBuf = new StringBuffer("Good");
 	public int sum(int a, int b){
 		return a+b;
 		// 선언부 전역변수는 페이지를 처음 실행할때 한번만 선언됨 
 	}
 %>
    
 </body>
</html>
