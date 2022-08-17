<%@page import="com.lec.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
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
	<jsp:useBean id="dto" class="com.lec.dto.BoardDto" />
	<jsp:setProperty property="*" name="dto"/>
	<!-- updateForm에서 들어온 파라미터는 : subject, content, email, pw, num이 들어옴 -->
	<!-- dao의 updateBoard를 사용하기 위해서는 : subject, content, email, pw, num, ip 가 필요 -->
	<%
		dto.setIp(request.getRemoteAddr()); // ip 가져오기
		BoardDao dao = BoardDao.getInstance();
		int result = dao.updateBoard(dto);
		if(result == BoardDao.SUCCESS){
	%>		
			<script>
				alert('글 수정 성공');
				location.href='list.jsp';
			</script>
<%		} else { %>
			<script>
				alert('글 수정 실패');
				history.back();
			</script>
<%		} %>
	
</body>
</html>