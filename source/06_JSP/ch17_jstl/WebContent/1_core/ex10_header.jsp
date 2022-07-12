<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head> 
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <link href="${conPath }/css/style.css" rel="stylesheet" type="text/css">
</head>
 <body>
 	<% session.setAttribute("customer", "test"); %>
    <!--  사용자가 로그인 성공 : session.setAttribute("customer") -->
    <!--  관리자가 로그인 성공 : session.setAttribute("admin") session에 customer, admin 둘다 없으면 둘다 로그인 안한거  -->
    <c:if test="${empty customer && empty admin }">
    <!--  로그인 전 메뉴 -->
    <ul>
    	<li><a href="">로그인</a></li>
    </ul>  
    </c:if>
    <c:if test="${not empty customer && empty admin }">  
    	<!--  사용자 모드의 로그인 후 메뉴 -->
    	<ul>
    		<li><a href="">고객센터</a></li>
    	</ul>
    </c:if>
    <c:if test="${empty customer && not empty admin }">
    	<!--  관리자 모드의 로그인 후 메뉴  -->
    	<ul><a href="">공지사항</a></ul>
    </c:if>
 </body>
</html>
