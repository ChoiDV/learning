<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String conPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=conPath%>/css/join.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="header.jsp" />
	<section>

		<h3>쇼핑몰 회원관리 프로그램</h3>

		쇼핑몰 회원정보와 회원매출정보 데이터베이스를 구출하고 <br>
		 회원관리 프로그램을 작성하는 프로그램이다. <br>
		<br>
		 프로그램 작성 순서 <br>
		 1. 회원 정보 테이블을 생성한다. <br>
		 2. 매출 정보 테이블을 생성한다. <br>
		  3. 회원정보 매출 정보 테이블에 제시된 문제지의 참조 데이터를 추가 생성한다. <br>
		4. 회원정보 입력 기능을 구현한다. <br>
		 5. 회원정보 조회 기능을 구현한다. <br>
		  6. 회원 매출 정보 조회 기능을 구현한다. <br>
	</section>
	<jsp:include page="footer.jsp" />
</body>
</html>
