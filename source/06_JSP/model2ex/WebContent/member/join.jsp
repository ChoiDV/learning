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
  <link href="${conPath }/css/join.css" rel="stylesheet" type="text/css">
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <script>
	$(document).ready(function() {
		$('input[name="mid"]').keyup(function() {
			var mid = $('input[name="mid"]').val();
			$.ajax({
				url : '${conPath }/idConfirm.do',
				data : 'mid=' + mid,
				type : 'get',
				dataType : 'html',
				success : function(data) {
					$('#idConfirmResult').html(data); // 사용가능한 ID입니다
				}
			}); // ajax 함수
		}); // keyup 이벤트
		$('input[name="mPwChk"]').keyup(function() { 
			var mpw = $('input[name="mpw"]').val();
			var mPwChk = $('input[name="mPwChk"]').val();
			if (mpw == mPwChk) {
				$('#pwChkResult').html('Ok');
			} else {
				$('#pwChkResult').html('No');
			}
		}); // mPwChk.keyup 이벤트
		$('input[name="memail"]').keyup(function() {
			var memail = $('input[name="memail"]').val();
			$.ajax({
				url : '${conPath }/mEmailConfirm.do',
				data : 'memail=' + memail,
				type : 'get',
				dataType : 'html',
				success : function(data) {
					$('#eMailConfirmResult').html(data); 
				}
			}); // ajax 함수
		}); // mEmail. keyup 이벤트
		$('form').submit(function() {
			var idConfirmResult = $('#idConfirmResult').text().trim();
			var pwChkResult = $('#pwChkResult').text().trim();
			var eMailConfirmResult = $('#eMailConfirmResult').text().trim();			
			if (idConfirmResult != "사용가능한 ID 입니다" ) {
				alert('사용가능한 ID로 가입하세요'); // 중복체크 다시해라!!!
				return false;
			} else if (pwChkResult != 'Ok') {
				alert('비밀번호를 확인하세요');
				return false;
			} else if (eMailConfirmResult != "사용가능한 Email 입니다" ){
				alert('중복된 이메일 입니다.');
				return false;
			}
		}); // form 태그 이벤트
	}); // ready
</script>
  <link rel="stylesheet"
	href="//code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>
<script>
	$(function() {
		$("#datepicker").datepicker(
				{
					dateFormat : 'yy-mm-dd',
					changeMonth : true, // 월을 바꿀 수 있는 셀렉트 박스 표시
					monthNamesShort : [ '1월', '2월', '3월', '4월', '5월', '6월',
											'7월', '8월', '9월', '10월', '11월', '12월' ],
					showMonthAfterYear : true,
					yearSuffix : '년', // "2020년 3월"
					showOtherMonths : true,
					dayNamesMin : [ '일', '월', '화', '수', '목', '금', '토' ],
					changeYear : true, // 년을 바꿀 수 있는 셀렉트 박스 표시
					minDate : '-100y', // 현재 날짜로부터 100년 이전까지 표시
					maxDate : 'y', // 현재 날짜이전까지만 표시
					yearRange : 'c-100:c+100', // 년도 선택 셀렉트 
				});
	});
</script>
</head>
 <body>
 	<jsp:include page="../main/header.jsp"/>
 	<div id="joinForm_wrap">
    <form action="${conPath }/join.do" method="post" enctype="multipart/form-data">
		<div id="join_title">회원가입</div>
		<table>
			<tr>
				<th>아이디</th>
				<td>
					<input type="text" name="mid" required="required">
				</td>	
			</tr>
			<tr>
				<td></td>
				<td>
					<div id="idConfirmResult"> &nbsp;</div>
				</td>
			<tr>
				<th>비밀번호</th>
				<td>
					<input type="password" name="mpw" required="required">
				</td>
			</tr>
			<tr>
				<th>비밀번호 확인</th>
				<td>
					<input type="password" name="mPwChk" required="required">
				</td>
			</tr>
			<tr>
			  	<td></td>
			  	<td>
			  		<div id="pwChkResult"> &nbsp; </div>
			  	</td>
			</tr>
			<tr>
				<th>이름</th>
				<td>
					<input type="text" name="mname" required="required">
				</td>
			</tr>
			<tr>
				<th>메일</th>
				<td>
					<input type="email" name="memail" required="required">
				</td>
			</tr>
			<tr>
				<td></td>
				<td>
					<div id="eMailConfirmResult"> &nbsp; </div>
				</td>
			</tr>
			<tr>
				<th>사진</th>
				<td>
					<input type="file" name="mphoto">
				</td>
			</tr>
			<tr>
				<th>생년월일</th>
				<td>
					<input type="text" name="mbirth" id="datepicker">
				<td>
			</tr>
			<tr>
				<th>주소</th>
				<td>
					<input type="text" name="maddress">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="회원가입">
					<input type="button" value="로그인" onclick="location.href='${conPath}/loginView.do'">
				</td>
			</tr>
		</table>
	</form>
	</div>
	<jsp:include page="../main/footer.jsp"/>
 </body>
</html>
