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
 <style>
  #content {
		width: 800px; height:350px;
		margin: 50px auto;
	}
	img{width: 100px;}
  </style>
  <link href="${conPath }/css/style.css" rel="stylesheet">
  <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
  <script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
  <script src="${conPath }/js/address.js"></script>  
</head>
  <body>
  <jsp:include page="../main/header.jsp"/>
  <div id="content">
		<form action="member.do?method=modify" method="post">
			<table>
				<caption>회원가입</caption>
				<tr>
					<th>아이디</th>
					<td>
						<input type="text" name="mid" value="${member.mid }" readonly="readonly">
					</td>
				</tr>	
				<tr>
					<th>비밀번호</th>
					<td>
						<input type="password" name="mpw" required="required" >
					</td>
				</tr>
				<tr>
					<th>이름</th>
					<td colspan="2">
						<input type="text" name="mname" value="${member.mname }" required="required">
					</td>
				</tr>
				<tr>
					<th >이메일</th>
					<td colspan="2">
						<input type="email" name="mmail" value="${member.mmail }" required="required">
					</td>
				</tr>	
				<tr>
					<th>우편번호</th>
					<td colspan="2">
						<input type="text" id="sample4_postcode" value="${member.mpost }" name="mpost" class="text_box"  placeholder="우편번호">
						<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기">
						<span id="guide"></span>
					</td>
				</tr>
				<tr>
					<th>주소</th>
					<td colspan="2">
						<input type="text" id="sample4_roadAddress" value="${member.maddr }" name="maddr"  placeholder="도로명주소">
						<input type="hidden" id="sample4_jibunAddress" placeholder="지번주소">
					</td>
				</tr>
				<tr>
					<td colspan="4">
						<input type="submit" value="정보수정">
						<input type="reset" value="취소">
						<input type="button" value="뒤로가기" onclick="history.back()">
					</td>
				</tr>
			</table>
		</form>
	</div>
	<jsp:include page="../main/footer.jsp"/>
  </body>
</html>