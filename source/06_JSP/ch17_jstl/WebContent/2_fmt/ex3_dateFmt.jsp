<%@page import="java.sql.Timestamp"%>
<%@page import="java.sql.Date"%>
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
    <c:set var="nowDate" value="<%=new Date(System.currentTimeMillis()) %>"/>
    <c:set var="nowTimes" value="<%=new Timestamp(System.currentTimeMillis()) %>"/>
    <c:set var="nowDateUtil" value="<%= new java.util.Date() %>"/>
    <h3>기본 Date 타입</h3>
    ${nowDate }<br> -Date.sql
    ${nowTimes }<br> - Timestamp
    ${nowDateUtil }<br> -java.util.Date
    <hr>
     <!--  type=에 date, time, both  -->
	<h3>날짜만 출력</h3>
	<fmt:formatDate value="${nowDate }" type="date" dateStyle="short"/> -short <br>
	<fmt:formatDate value="${nowDate }" type="date" dateStyle="medium"/> - medium<br> 
	<fmt:formatDate value="${nowDate }" type="date" dateStyle="long"/> - long <br>
	<fmt:formatDate value="${nowDate }" type="date" dateStyle="full"/> - full  <br>
	
	<hr>
	<h3>시간만 출력</h3>
	<fmt:formatDate value="${nowDate }" type="time" timeStyle="short"/> -short <br>
	<fmt:formatDate value="${nowDate }" type="time" timeStyle="medium"/> - medium<br> 
	<fmt:formatDate value="${nowDate }" type="time" timeStyle="long"/> - long <br>
	<fmt:formatDate value="${nowDate }" type="time" timeStyle="full"/> - full  <br>
	
	<hr>
	<h3>날짜와 시간 모두 출력</h3>
	<fmt:formatDate value="${nowDate }" type="both" dateStyle="long" timeStyle="short"/>
	
	<hr>
	<h3>나만의 출력 패턴 만들기</h3>
	<fmt:formatDate value="${nowDate }" pattern="yyyy년MM월dd일(E요일) hh:mm:ss:SS(a)" /><br>  <!-- hh =  12시간  (a): 오전 오후 -->
	<fmt:formatDate value="${nowDate }" pattern="yy년MM월dd일(E요일) HH:mm:ss:SS(a)" /><br>  <!-- HH = 24시간 (a): 오전 오후 -->
	
 </body>
</html>
