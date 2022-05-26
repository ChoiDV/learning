<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <link href="<%=conPath %>/css/style.css" rel="stylesheet" type="text/css">
  <style>
   
  </style>
</head>
 <body>
 <%
 	Enumeration<String> names = session.getAttributeNames(); // 세션 속성 이름들
 	int cnt = 0;
 	while(names.hasMoreElements()){
 		String sname = names.nextElement(); // 속성이름
 		String svalue = (String)session.getAttribute(sname);
 		out.println("<h2> (세션 속성명) : " + sname + "/  (세션 속성값 ) : " + svalue + "</h2>" );
 		cnt++;
 	}
 	if(cnt==0){
 		out.println("<h2>유효한 세션 속성이 없습니다.</h2>");
 		out.println("<button onclick=\"location.href='login.jsp'\">로그인</button>");
 	}else {
 		out.println("<button onclick=\"location.href='logout.jsp'\">로그아웃</button>");
 	}
 %>
    <button onclick="history.go(-1)">이전 페이지</button>
    <button onclick="location.href='welcome.jsp'">welcome페이지 </button>
 </body>
</html>
