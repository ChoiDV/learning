<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	<script>
	  $(document).ready(function(){
			
  	  });
	</script>
</head>
  <body>
	<h2>파일 업로드 결과 : ${fileResult }</h2>
	<p>file1 : ${filename[0] }</p>
	<p>file2 : ${filename[1] }</p>
	<p>file3 : ${filename[2] }</p>
	<c:if test="${not empty filename[0] }">
		<img src="${conPath }/upload/${filename[0] }">
	</c:if>
	<c:if test="${empty filename[0] }">
		첫번째 첨부파일 첨부 안함
	</c:if>
	<c:if test="${not empty filename[1] }">
		<img src="${conPath }/upload/${filename[1] }">
	</c:if>
	<c:if test="${empty filename[1] }">
		두번째 첨부파일 첨부 안함
	</c:if>
	<c:if test="${not empty filename[2] }">
		<img src="${conPath }/upload/${filename[2] }">
	</c:if>
	<c:if test="${empty filename[2] }">
		세번째 첨부파일 첨부 안함
	</c:if>
  </body>
</html>