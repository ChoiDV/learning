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
 <style>
 
 </style>
 <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
 <script>
 	$(document).ready(function(){
 		
 	});
 </script>  
</head>
  <body>
<%--   	<c:if test="${not empty member}"> --%>
<!--   		<script> -->
<!--   			alert('로그아웃 후 관리자 로그인을 해주세요'); -->
<!--    			history.back(); -->
<!--   		</script> -->
<%--   	</c:if> --%>
	<jsp:include page="../main/header.jsp"/>
	<div id="content_form">
	<form action="${conPath }/adminLogin.do" method="post">
		<table>
			<caption>로그인</caption>
			<tr><th>ID</th><td><input type="text" name="aId" required="required"></td></tr>
			<tr><th>PW</th><td><input type="password" name="aPw" required="required"></td></tr>
			<tr><td colspan="2">
						<input type="submit" value="로그인" class="btn">
		</table>
	</form>
	</div>
	<jsp:include page="../main/footer.jsp"/>
  </body>
</html>