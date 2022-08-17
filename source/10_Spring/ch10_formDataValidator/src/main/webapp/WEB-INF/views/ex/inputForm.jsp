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
	<form action="${conPath }/input.do" method="get">
		<p>이름 : <input type="text" name="name" value="${student.name }"></p>  <!--  student는 잘못쳤을경우 넘어오는 model임 즉 value가 있으면 잘못쳐서 넘어온거. -->
		<p>ID : <input type="number" name="id" placeholder="ID는 자연수를 입력하세요" 
										value='<c:if test="${student.id != 0 }">${student.id }</c:if>'></p>
		 <input type="submit">
	</form>
	<h4>${nameError }</h4>  <!--  name에러가 등록된게 있으면 나오고 없으면 안나옴 -->
	<h4>${idError }</h4>    <!--  마찬가지로 id에러가 등록된게 있으면 나오고 없으면 안나옴  -->
  </body>
</html>