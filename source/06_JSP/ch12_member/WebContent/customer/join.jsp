<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <link href="<%=conPath %>/css/join.css" rel="stylesheet">
   <script>
		function chkJoin(){
			if(frm.cPw.value != frm.cPwChk.value){
				alert('두 비밀번호가 일치하지 않습니다.' );
				frm.cPw.value='';
				frm.cPwChk.value='';
				frm.cPw.focus();
				return false;
				}
			}
  </script>
</head>
 <body>
<jsp:include page="header.jsp"/>
    		<div id="joinForm_wrap">
			<form action="joinPro.jsp" method="post" name="frm" onsubmit="return chkJoin()">
				<div id="join_title">회원가입</div>
				<table>
					<tr>
						<th><label for="cId">아이디</label></th>
						<td><input type="text" name="cId" id="cId" class="cId" required="required" ></td>
					</tr>
					<tr>
						<th><label for="cPw">비밀번호</label></th>
						<td><input type="password" name="cPw" id="cPw" class="cPw" required="required"></td>
						
					</tr>
					<tr>
						<th><label for="cPwChk">비밀번호 확인</label></th>
						<td><input type="password" name="cPwChk" id="cPwChk" class="cPwChk" ></td>						
					</tr>
					<tr>
						<th><label for="cName">이름</label></th>
						<td><input type="text" name="cName" id="cName" class="cName" required="required" autofocus="autofocus"></td>
						
					</tr>
					<tr>
						<th><label for="cTel">전화</label></th>
						<td><input type="text" name="cTel" class="cTel" required="required"></td>
					</tr>
					<tr>
						<th><label for="cEmail">이메일</label></th>
						<td><input type="text" name="cEmail" id="cEmail" class="cEmail"></td>	
					</tr>
					<tr>
						<th><label for="cAddress">주소</label></th>
						<td><input type="text" name="cAddress" id="cAddress" class="cAddress"></td>
					</tr>																
					<tr>
						<th><label for="cBirth">생년월일</label></th>
						<td><input type="date" name="tempbirth" id="cBirth" class="cBirth" ></td>					
					</tr>					
					<tr>
						<th>성별</th>
						<td>  					
							<input type="radio" name="cGender" value="m" id="m" checked="checked">
							<label for="m">남자</label>
							<input type="radio" name="cGender" value="f" id="f">
							<label for="f">여자</label>
						</td>
					</tr>
					<tr><td colspan="2"></td></tr>
					<tr>
						<td colspan="2">
							<input type="submit" value="가입하기" class="joinBtn_style">
							<input type="reset" value="다시하기" class="joinBtn_style">
							<input type="button" value="뒤로가기" class="joinBtn_style" onclick="history.back()">
						</td>
					</tr>
					
				</table>
			</form>
		</div>
		<jsp:include page="footer.jsp"/>
 
    
 </body>
</html>
