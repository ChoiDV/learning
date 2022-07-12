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
    <h2>예외처리</h2>
    <c:catch var="error"> <!--  catch 절에 var를 선언하면  catch절에서 예외가 발생할 경우, 예외 타입과 예외 메세지가 error에 저장된다.  -->
    <h2>테스트</h2>
    <%= 8/0 %>
    <p> 예외가 발생되는 즉시 catch절을 빠져나감. 이 p 태그 출력시 예외가 발생 안됨. </p>
    </c:catch>
    <h2>예외 발생해서 catch 빠져나옴.</h2>
    <h2>예외타입과 예외 메세지 : <c:out value="${error }" default="예외발생 안됨."/></h2>
    <h2>예외타입과 예외 메세지 : ${error } </h2>  <!--  이렇게 해도 똑같음 -->
 </body>
</html>
