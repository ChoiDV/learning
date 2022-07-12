<%@page import="com.lec.dto.MemberDto"%>
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
	<link href="${conPath }/css/header.css" rel="stylesheet">
</head>
<body> <%-- .gnb(로그인전/로그인후) - .logo - .lnb(도서보기, 도서등록(로그인후)) --%>
	<header>
		<div class="gnb">
			<c:if test="${member eq null }">
				<!-- 로그인 전 메뉴(우측부터) : 고객센터, 회원가입, 로그인 -->
				<ul>
					<li><a href="#">고객센터</a></li>
					<li><a href="${conPath }/joinView.do">회원가입</a></li>
					<li><a href="${conPath }/loginView.do">로그인</a></li>
				</ul>
			</c:if>
			<c:if test="${member != null }">
				<!-- 로그인 후 메뉴(우측부터) : 고객센터, 로그아웃, 정보 수정, 고객이름 -->
				<ul>
					<li><a href="#">고객센터</a></li>
					<li><a href="#">로그아웃</a></li>
					<li><a href="#">정보수정</a></li>
					<li><a href="#">${member.mname }</a> 
				</ul>
			</c:if>
		</div>
		<div class="logo" onclick="#">
			<img src="http://www.moel.go.kr/images/layout/logo.png">
		</div>
		<div class="lnb">
			<!-- 우측부터  메뉴 : 도서보기, 도서등록(로그인후) -->
			<ul>
				<c:if test="${member eq null }"> 
					<li><a href="#">로그인 전 메뉴1</a></li>
					<li><a href="#">로그인 전 메뉴2</a></li>
					<li><a href="#">로그인 전 메뉴3</a></li>
					<li><a href="#">로그인 전 메뉴4</a></li>
				</c:if>
				<c:if test="${member != null }">
					<li><a href="#">로그인 후 메뉴1</a></li>
					<li><a href="#">로그인 후 메뉴2</a></li>
					<li><a href="#">로그인 후 메뉴3</a></li>
					<li><a href="#">로그인 후 메뉴4</a></li>
				</c:if>
			</ul>
		</div>
	</header>
</body>
</html>














