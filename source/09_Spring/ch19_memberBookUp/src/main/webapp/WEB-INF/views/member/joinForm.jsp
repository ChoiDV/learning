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
  <link href="${conPath }/css/style.css" rel="stylesheet">
  <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	<script>
	  $(document).ready(function(){
			
  	  });
	</script>
</head>
  <body>
  <div id="content">
		<form action="member.do?method=join" method="post">
			<table>
				<caption>회원가입</caption>
				<tr>
					<th rowspan="2">아이디</th>
					<td>
						<input type="text" name="mid" required="required">
					</td>
				</tr>
				<tr>
					<td>
						<span id="idConfirmResult"> &nbsp; </span>
					</td>
				</tr>
				<tr>
					<th rowspan="2">비밀번호</th>
					<td>
						<input type="password" name="mpw" required="required" >
					</td>
				</tr>
				<tr>
					<td>
						<span id="pwCheckResult"> &nbsp; </span>
					</td>
				</tr>
				<tr>
					<th>이름</th>
					<td>
						<input type="text" name="mname" required="required">
					</td>
				</tr>
				<tr>
					<th>이메일</th>
					<td>
						<input type="email" name="mmail" required="required">
					</td>
				</tr>	
				<tr>
					<th>우편번호</th>
					<td>
						<input type="text" name="mpost" required="required">
					</td>
				</tr>
				<tr>
					<th>주소</th>
					<td>
						<input type="text" name="maddr" required="required">
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="회원가입">
						<input type="reset" value="취소">
						<input type="button" value="뒤로가기" onclick="history.back()">
					</td>
				</tr>
			</table>
		</form>
	</div>
  </body>
</html>