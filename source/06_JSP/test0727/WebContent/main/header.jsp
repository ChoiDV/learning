<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %> 
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath%>/css/join.css" rel="stylesheet">
</head>
 <body>
 	<header>
 		애플리케이션 배포
 	</header>
 	<nav>
 		<button onclick="location='<%=conPath %>/member/insert.jsp'">회원등록</button>
    	<button onclick="location='<%=conPath %>/member/memberList.jsp'">회원조회/수정</button>
    	<button onclick="location='<%=conPath %>/member/priceList.jsp'">매출조회(회원/제품)</button>
    	<button onclick="location='<%=conPath %>/main/main.jsp'">홈으로</button>
 	</nav>
   
 </body>
</html>
