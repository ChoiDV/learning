<%@page import="com.lec.dto.CustomerDto"%>
<%@page import="com.lec.dao.CustomerDao"%>
<%@page import="java.sql.Date"%>
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
	<jsp:useBean id="customer" class="com.lec.dto.CustomerDto"  scope="page"/>
	<jsp:setProperty property="*" name="customer"/>
<%	// modifyForm 에서 입력한것들을 customer에 받아옴
	String cbirth = request.getParameter("tempbirth");
	if( cbirth != null){
		customer.setCbirth(Date.valueOf(cbirth));
	}
	String oldPw = request.getParameter("oldPw");
	String sessionPw = (String)session.getAttribute("cpw");
	CustomerDao dao = CustomerDao.getInstance();
	CustomerDto dto = dao.getCustomer(customer.getCid());
	if( dto != null){
		// 아이디로 회원정보 가져온뒤
		// db에 있는 pw와 입력한 oldpw가 일치한지 확인
		if(dto.getCpw().equals(oldPw)){
			//  입력한 현재 비밀번호와 db의 pw가 같은경우 :  즉 , 회원정보 수정 진행 
			/* if(customer.getCpw() == null ){ 
				customer.setCpw(sessionPw);
			}  cpw가 필수입력사항이라서 이과정 필요없음 */
			int result = dao.updateCustomer(customer);
			if(result == CustomerDao.SUCCESS){
				// 정보 수정 성공 
				session.invalidate(); 
%>
				<script>
		 			alert('회원정보 수정 성공했습니다. 다시 로그인후 이용 부탁드립니다.');
		 			location.href="loginForm.jsp";
 				</script>
<% 			} else { %>
				<!--  정보 수정 실패  -->
				<script>
		 			alert('회원정보 수정을 실패했습니다. 현재 비밀번호를 확인해주세요.');
		 			history.back();
 				</script>
<% 			}  %>	

<% 		} else {
		  //  입력한 pw와 db의 pw가 다른경우 즉, 정보수정 하면 안됌.  %>
		  	<script>
		  		alert('현재 비밀번호를 확인해주세요!');
		  		history.back();
		  	</script>
		  
<% 		}
	}  %> 
	
	
		
		

 			
 
 	
 				





</body>
</html>