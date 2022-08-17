<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
</head>
 <body>
    <form action="ex02_scope.jsp">
    	<p>이름 <input type="text" name="name"></p>
    	<p>ID <input type="text" name="id"></p>
    	<p><input type="submit"></p>	
    </form>
    <%
    	pageContext.setAttribute("pageName","pageValue");  // 페이지를 벗어나면 없어지는 속성
    	request.setAttribute("requestName", "requestValue");  // 새로운 request객체를 생성하면 없어지는 속성 
    	session.setAttribute("sessionName", "sessionValue"); // 브라우저를 닫으면 없어지는 속성
    	application.setAttribute("applicationName", "applicationValue"); // 톰캣 재실행하면 없어지는 속성
    // forward 할 객체 (dispatcher)
    	RequestDispatcher dispatcher = request.getRequestDispatcher("ex02_scope.jsp?name=kim&id=aaa");
    	dispatcher.forward(request, response);
    	// jsp의 forward를 자바에서 사용하기 위해서는 위의 방법으로 사용해야함.
    	// jsp:forward 한거랑 똑같음
    %>
<%--     <jsp:forward page="ex02_scope.jsp"/> --%>
    <h3>페이지내 속성변수 값 : <%=pageContext.getAttribute("pageName") %></h3>
    <h3>request내 속성변수 값 : <%=request.getAttribute("requestName") %></h3>
    <h3>session 속성변수 값 : <%=session.getAttribute("sessionName") %></h3>
    <h3>application내 속성변수 값 : <%=application.getAttribute("applicationName") %></h3>
    <hr>
    <h3>페이지내 속성변수 값 : ${ pageScope.pageName }</h3>
    <h3>request내 속성변수 값 : ${ requestScope.requestName }</h3>
    <h3>session 속성변수 값 : ${ sessionScope.sessionName }</h3>
    <h3>application내 속성변수 값 : ${ applicationScope.applicationName }</h3>
    <hr>
    <h3>페이지내 속성변수 값 : ${ pageName }</h3>
    <h3>request내 속성변수 값 : ${ requestName }</h3>
    <h3>session 속성변수 값 : ${ sessionName }</h3>
    <h3>application내 속성변수 값 : ${ applicationName }</h3>
    <!--  el 은 Scope 객체를 생략할수있음  -->
    
    
 </body>
</html>
