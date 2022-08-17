<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <link href="${conPath }/css/style.css" rel="stylesheet">
</head>
  <body>
	<form action="quizInput.do" method="post">
		<table>
			<caption>개인 정보 입력</caption>
			<tr>
				<th>이름</th>
				<td>
					<input type="text" name="name" value="${quiz.name }">
				</td>
			</tr>
			<tr>
				<th>국어</th>
				<td>
					<input type="number" name="kor" value="${quiz.kor }">
				</td>
			</tr>
			<tr>
				<th>영어</th>
				<td>
					<input type="number" name="eng" value="${quiz.eng }">
				</td>
			</tr>
			<tr>
				<th>수학</th>
				<td>
					<input type="number" name="mat" value="${quiz.mat }">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="입력">
				</td>			
			</tr>
		</table>
	</form>
	<h2>${nameError }</h2>
	<h2>${korError }</h2>
	<h2>${engError }</h2>
	<h2>${matError }</h2>
  </body>
</html>