
<%@page import="com.lec.member.MemberDaoConn"%>
<%@page import="com.lec.member.MemberDto"%>
<%@page import="java.sql.Timestamp"%>
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
<link href="<%=conPath%>/css/style.css" rel="stylesheet">
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
	%>
	<jsp:useBean id="dto" class="com.lec.member.MemberDto" />
	<jsp:setProperty name="dto" property="*" />
	<%
		String tempbirth = request.getParameter("tempbirth");
	if (!tempbirth.equals("")) {
		dto.setBirth(Timestamp.valueOf(tempbirth + " 00:00:00"));
	}
	MemberDto member = (MemberDto) session.getAttribute("member");
	String sessionPw = null;
	if (member != null) {
		sessionPw = member.getPw(); // 세션의 pw를 sessionPw에 할당
	}
	String oldPw = request.getParameter("oldPw");
	if (sessionPw.equals(oldPw)) { // 원래의 pw와 입력한 원래 비밀번호가 일치할시 정보 수정 진행 
		// 새비밀번호(pw 파라미터)가 null("")일 경우 비밀번호 변경을 안한다는소리니까 oldPw나 sessionPw를 넣어주고 수정하기.
		if (dto.getPw() == null) {
			dto.setPw(sessionPw);
		}
		MemberDaoConn mDao = new MemberDaoConn();
		int result = mDao.modifyMember(dto);
		if (result == MemberDaoConn.SUCCESS) { // 수정성공
			session.setAttribute("member", dto); // 수정된 DB내용을 session 속성에도 수정
%> 
	<script>
		alert("회원정보 수정이 완료되었습니다.");
		location.href="main.jsp";
	</script>
<%			
		} else { //수정실패  %> 
	<script>
		alert("회원정보 수정이 실패되었습니다. 정보가 너무 깁니다.");
		location.href = 'modify.jsp';
	</script>		
<% 		}
	} else { // 정보수정하려고 비밀번호입력하라했는데 그 비밀번호가 틀렸을때 ( 정보 수정 안돼 )
	%>
	<script>
		alert("현재 비밀번호가 바르지 않습니다. 확인해주세요.");
		history.back();
	</script>
	<%
		}
	%>

</body>
</html>
