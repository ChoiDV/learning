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
<%--
	if(1+2==3){
		out.println("1+2는 3입니다.");
	} else {
		out.println("1+2는 3이 아닙니다.");
	}
--%> 
	<c:if test="${1+2 eq 3 }">
		<h2>1+2는 3입니다.</h2>   <!--  얘같은 경우는 else를 사용못함 else를 사용하려면 조건의 반대문으로 if문을 실행 -->
	</c:if>   
	<c:if test="${1+2 != 3 }" var="result" scope="page">
		<h2>1+2는 3이 아닙니다.</h2>
	</c:if>
	두번째 if문 조건에 대한 결과는  ${result } 입니다. 
 </body>
</html>
