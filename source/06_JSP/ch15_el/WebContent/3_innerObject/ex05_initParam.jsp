<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
</head>
 <body>
    <h2>contextID : ${ initParam.contextID }</h2>
    <h2>contextPW : ${ initParam.contextPW }</h2>
    <h2>contextID : <%=getServletContext().getInitParameter("contextID") %></h2>
<!--     데이터공유 : 여러 서블릿에서 특정 데이터를 공유해야 할 경우 context Parameter를 이용해서 
			web.xml에 데이터를 기술하고 공유하면서 사용할 수 있다.  서블릿과 컨테이너 간의 통신 -->
 </body>
</html>
