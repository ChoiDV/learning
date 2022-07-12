<%@page import="java.sql.Date"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
   <link href="../css/join.css" rel="stylesheet">
  <style>
   
  </style>
</head>
 <body>
		<%	
			request.setCharacterEncoding("utf-8");
			String name = request.getParameter("name");
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			String birth = request.getParameter("birth");
			Timestamp birth3=null;
			if(birth!="") {				
				birth3 = Timestamp.valueOf(request.getParameter("birth") + " 00:00:00");
			}
			String[] hobby = request.getParameterValues("hobby");  
			String gender = request.getParameter("gender");
			String email = request.getParameter("email");
			String[] mailSend = request.getParameterValues("mailSend");  
			Date date = new Date(System.currentTimeMillis());
			String ip = request.getRemoteAddr();
			out.println("<html>");
			out.println("<head>");
			// <link href="css/join.css" rel="stylesheet" >
			out.println("</head>");
			out.println("<body>");
			out.println("<div id='joinForm_wrap'>");
			out.println("<div id='join_title'>회원가입정보</div>");
			out.println("<h2>name : " + name + "</h2>");
			out.println("<h2>id : " + id + "</h2>");
			out.println("<h2>pw : ");
			for(int i = 0; i<pw.length(); i++) {
				out.println("*");
			}
			out.println("</h2>");
			out.println("<h2>birth : " + birth + "</h2>");
			out.println("<h2>birth2 :  " + birth3 + "</h2>");
			out.println("<h2>hobby : ");  // 취미 : 요리, 운동
			if ( hobby != null) {
				for(int i=0; i < hobby.length; i++) {
					if(i == hobby.length-1) {// 이러면 취미의 마지막 애 
						out.println(hobby[i]);
					} else {
						out.println(hobby[i]+" , " );
					}
				}
			} else {
				out.println("선택된 취미가 없음. </h2>");
			}
			out.println("</h2>");
			out.println("<h2>gender : " + gender + "</h2>");
			out.println("<h2>email : " + email + "</h2>");
			if( mailSend != null ){
				out.println("<h2>mailSend : " + Arrays.toString(mailSend) + "</h2>");					
			} else {
				out.println("<h2>mailSend : 모두 수신 거부 </h2>");
			}
			out.println("<h2>가입일 : " + date + "</h2>");
			out.println("<h2> 가입 IP : " + ip  + "</h2>");
			out.println("</div>");
			out.println("</body>");
			out.println("</html>");					
		%>
		<%@ include file="footer.jsp" %>
     
 </body>
</html>
