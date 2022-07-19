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
  <link href="${conPath }/css/style.css" rel="stylesheet">
</head>
  <body>
  	 <h2>현재 총 ${cnt }명</h2>
	 <table>
	 	<caption>결과는 다음과 같습니다.</caption>
	 	<tr>
	 		<th>이름 : </th>
	 		<td>${quiz.name }</td>
	 	</tr>
	 	<tr>
	 		<th>국어 : </th>
	 		<td>${quiz.kor }</td>
	 	</tr>
	 	<tr>
	 		<th>영어 : </th>
	 		<td>${quiz.eng }</td>
	 	</tr>
	 	<tr>
	 		<th>수학 : </th>
	 		<td>${quiz.mat }</td>
	 	</tr>
	 	<tr>
	 		<th>총점 : </th>
	 		<td>${sum }</td>
	 	</tr>
	 	<tr>
	 		<th>평균 : </th>
	 		<td><fmt:formatNumber value="${avg }" pattern="#,###.00" /></td>
	 	</tr>
	 </table>
  </body>
</html>