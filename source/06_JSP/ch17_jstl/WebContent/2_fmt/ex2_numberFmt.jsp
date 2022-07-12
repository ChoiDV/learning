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
    <c:set var="num" value="1234567.8"/>
    <p>num : ${num } </p>
    <p>세자리 마다, 찍기 : <fmt:formatNumber value="${num }" groupingUsed="true"/></p> <!--  세자리마다  , 를 찍겠다 . -->
    <p>세자리 마다, 찍기 : <fmt:formatNumber value="${num }" pattern="#,###.#"/></p>  <!--  pattern 으로도 표현 가능 3자리마다 , 찍는건 groupingUsed 많이사용 -->
    <p>소수점 2자리 (소수점 한자리의 경우 뒤에 0) : <fmt:formatNumber value="${num }" pattern="#,###.00"/> </p> <!-- 반드시 소수점 2자리 -->
    
    <p>
    	소수점 2자리(소수점 유효한자리까지만 출력) : <fmt:formatNumber value="${num }" pattern="#,###.##"/>  
    	<!--  3자리인데 2자리까지만 출력하라고 하면 반올림해서 2자리로 표현  -->
    </p>
    <c:set var="num" value="3.149"/>
    <p>
    	소수점 2자리(소수점 두자리 이상의 반올림) :
    		<fmt:formatNumber value="${num }" pattern="#,###.##"/>
    </p>
 </body>
</html>
