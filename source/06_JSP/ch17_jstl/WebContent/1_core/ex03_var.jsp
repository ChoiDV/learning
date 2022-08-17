<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
</head>
 <body>
   	<h2>변수 선언과 출력</h2>
   	<c:set var="varName" value="varValue"/>
   	varName : ${varName } <br>
   	<c:set var="varName" value="abc <varValue>"/>
   	varName : ${varName } <br>
   	varName : 1. <c:out value="${varName }"/> <br>
   	varName : 2. <c:out value="${varName }" escapeXml="false"/> <br>   <!--  escapeXml="true" 는 특수문자 인식(default)  -->
   	<c:remove var="varName"/> <!--  변수 삭제 --> 
   	<c:out value="${varName }"/>
   	varName : ${varName } <br>
   	varName : ${empty varName ? "삭제되서 없음" : "남아있음" } <br>
   	varName : <c:out value="${varName }" default="없어진 변수"/>
   	
   	<!--  var에 14번줄같은 value가 들어가면  15번 방식이나 out 태그를 사용해서 출력할수 있음 근데 -->
   	<!--  value안에 특수문자 들어가면 출력하기 위해서 c:out 태그를 이용함  -->
   	
 </body>
</html>
