<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

</style>
</head>
<body>
<%! String name, id, pw; %>  <% // 위에서 따로 선언 가능. %>
<% 
	request.setCharacterEncoding("utf-8"); //post방식으로 파라미터를 받을때 utf-8 로 인코딩 처리한다 post방식으로받으면 무조건 이거 사용해줘야 한글 안깨짐
	id = request.getParameter("id");
	name = request.getParameter("name");
	pw = request.getParameter("pw");
%>
	<div id="wrap">
		<h2>결과 화면</h2>
		<p>
		아이디는 <%= id%> 이고
		</p>
		<p>
		이름은 <%= name %>이고
		</p>
		<p>
		비밀번호는 <%= pw %> 이다!!!!!!!
		</p>
	</div>




</body>
</html>
