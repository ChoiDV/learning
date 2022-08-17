<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <style>
   
  </style>
</head>
 <body>
 <% // 특정 세션 속성값 가져오기
 	String sessionName = (String)session.getAttribute("sessionName");
  	// session에는 객체도 들어갈수 있음 그래서 object로 리턴해줌
  	// 그래서 String으로 형변환 해줘야함 
  	Integer myNum = (Integer)session.getAttribute("myNum");
 	// 형변환 해주기 
 	out.println("sessionName : " + sessionName + "<br>");
 	out.println("myNum : " + myNum + "<br>");
 	out.println("id : " + session.getAttribute("id") + "<br>");
 	// 추가한 속성이 없을 경우 null
 	// 추가한 id 속성이 없으므로 null 
 	
 	
 	// 모든 세션 속성 리스트 출력
 	out.println("<h4>모든 세션 속성들 list<h4>");
 	Enumeration<String> sAttrNames = session.getAttributeNames();
 	int cnt=0;
 	while(sAttrNames.hasMoreElements()){  // 모든 세선 뽑아내기 
 		String sname = sAttrNames.nextElement(); // 세션(속성) 이름 
 		String svalue = session.getAttribute(sname).toString(); // 세션(속성 ) 값
 		out.println( "(세션이름) : " + sname + " / (세션값) : " + svalue + "<br>" );
 		cnt++;
 	}
 	if(cnt == 0) {
 		out.println("추가된 세션 속성이 없습니다.");
 	}
 	
 	// 특정 세션 삭제하기 (로그아웃시 사용)
 	session.removeAttribute("myNum"); // myNum 세션 속성 삭제
 	
 	out.println("<h4>myNum 세션 속성 삭제 후 </h4>");
 	sAttrNames = session.getAttributeNames();
 	cnt=0;
 	while(sAttrNames.hasMoreElements()){  // 모든 세선 뽑아내기 
 		String sname = sAttrNames.nextElement(); // 세션(속성) 이름 
 		String svalue = session.getAttribute(sname).toString(); // 세션(속성 ) 값
 		out.println( "(세션이름) : " + sname + " / (세션값) : " + svalue + "<br>" );
 		cnt++;
 	}
 	if(cnt == 0) {
 		out.println("추가된 세션 속성이 없습니다.<br>");
 	}
 	
 	// 모든 세션 삭제하기 (로그아웃시 사용)
 	session.invalidate(); // setAttribute했던 모든 세션 속성값이 다 삭제 ( )
 	if(request.isRequestedSessionIdValid()){ // 유효한 세션 속성이 있는지 여부 
 		out.println("session valid<br>");	 // 유효한 세션이 있다.
 	} else {
 		out.println("session invalid<br>");  // 유효한 세션이 없다.
 	}
 	out.println("<h4>세션 ID : " + session.getId() + "</h4>");
 	out.println("<h4>세션의 유효 시간 : " + session.getMaxInactiveInterval() + "<br>"); // 초로 뜸 
 	
 	
%>
    
 </body>
</html>
