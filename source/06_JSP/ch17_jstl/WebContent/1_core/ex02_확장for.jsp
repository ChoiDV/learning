<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
</head>
 <body>
<%
	String[] names = {"홍길동","김길동", "신길동"};
// 	for(String name : names){
// 		out.println("<p>"+name+"</p>");
// 	}
// 	for(int i= 0; i<names.length; i++){
// 		out.println("<p>"+i+"번째 이름 : "+names[i]+"</p>");
// 	}
%>
	<c:set var="names" value="<%=names%>"/> <!--  변수 선언 -->
	<c:forEach var="name" items="${names }">
		<p> ${name }</p>
	</c:forEach>
	<hr>
	<c:set var="idx" value="0"/> <!--  idx 변수 선언 --> <!-- c:set var에는 객체만 넣거나, ${} 로 값을 넣는다. -->
	<c:forEach var="name" items="${names }">
		<p>${idx }번째 이름은 ${name }</p>
		<c:set var="idx" value="${idx+1 }"/> <!--  idx변수 재선언  이게 idx++ 같은 느낌  idx에는 원래 String이지만 알아서 int로 바꿔서 계산해줌-->
	</c:forEach>
	<p>최종 idx 값은 ${idx }</p>
 </body>
</html>
