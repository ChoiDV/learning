<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <style>  
  #mainForm_wrap{
   		width:800px;
  		margin: 0 auto;	
  		height: 620px;
  		line-height: 620px;
  		text-align: center;
  		font-size:1.5em;
  		font-weight:bold;
   	}
   
  </style>
</head>
 <body>
 	<jsp:include page="header.jsp"/>
 	<div id="mainForm_wrap">
    <% // 로그인 상태 : id, name 세션 속성이 있음
 	String loginChk = (String)session.getAttribute("loginChk");
 	if(loginChk != null){		
 		session.invalidate();
 		 %>		
    	 로그아웃 되었습니다. 잠시후 페이지 이동이 있겠습니다. 		
 		<script>	
 		// 메인화면에 content 대신 로그아웃되었습니다를 띄워주고 3초뒤 페이지이동 
 			setTimeout(function() { 				
 				location.href="<%=conPath %>/member/main.jsp";
 			},3000);			
 		</script> 	
 <% 	}  %>
 	</div>
 	<jsp:include page="footer.jsp"/>		
 		 
 
 </body>
</html>
