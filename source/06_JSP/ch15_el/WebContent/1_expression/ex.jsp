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
	<h2>표현식(<%="표현식"  %>) 태그 이용</h2>
	<p>산술연산 : 10+1 = <%=10+1 %></p>
	<p>산술연산 : 10/0.0 = <%=10/0.0 %></p> <!--  0으로 나누면 에러, 0.0 으로 나누면 무한대 (에러 x) -->
	<p>관계연산 : 1==2 => <%=1==2 %></p>
	<p>관계연산 : 1 != 2 => <%=1 != 2 %></p>
	<p>관계연산 : 1 < 2 => <%=1 < 2 %></p>
	<p>관계연산 : 1 &lt; 2 => <%=1 < 2 %></p>  <!--  꺽새 괄호가 태그로 인식해서 안나오면 &lt; 로 사용해야함 -->
	<p>조건연산 : <%=(1>2)? "1이 2보다 큽니다" : "1이 2보다 작습니다." %></p>
	<p>논리연산 : (1>2) || (1<2) = <%= (1>2) || (1<2) %></p>
	<p>로그인 여부 : <%=session.getAttribute("customer")==null? "로그인 전" : "로그인 후" %></p>
	<p>로그인 여부 : <%=session.getAttribute("customer")!=null? "로그인 후" : "로그인 전" %></p>
	<p>pageNum 파라미터 여부 : <%=request.getParameter("pageNum")== null ? "pageNum 안옴" : "pageNum 넘어옴" %>
	<p>name 파라미터 : <%=request.getParameter("name") %></p>
<%-- 	<p>name 파라미터를 대문자로 : <%=request.getParameter("name").toUpperCase() %></p> --%>
	<hr>	
	<h2>EL 표기법을 이용한 (표현식 안에 쓸 수 있는 연산자는 다 사용 가능)</h2>
	<p>산술연산 : 10+1 = ${ 10+1 } </p>
	<p>산술연산 : 10/0.0 = ${ 10/0.0 }</p> <!--  0으로 나누면 에러, 0.0 으로 나누면 무한대 (에러 x) -->
	<p>관계연산 : 1==2 => ${1 eq 2 }</p>
	<p>관계연산 : 1 != 2 => ${1 != 2 }</p>
	<p>관계연산 : 1 < 2 => ${1 < 2 }</p>
	<p>관계연산 : 1 &lt; 2 => ${ 1 < 2 }</p>  <!--  꺽새 괄호가 태그로 인식해서 안나오면 &lt; 로 사용해야함 -->
	<p>조건연산 : ${ (1>2) ? "1이 2보다 큽니다" : "1이 2보다 작습니다." }</p>
	<p>논리연산 : (1>2) || (1<2) = ${ (1>2) || (1<2) }</p>
	<p>로그인 여부 : ${ customer == null ? "로그인 전" : "로그인 후" }</p>
	<p>로그인 여부 : ${ customer eq null ? "로그인 전" : "로그인 후" }</p>
	<p>로그인 여부 : ${ empty customer ? "로그인 전" : "로그인 후" }</p>  <!--  empty = null 이냐? 물어보는것 -->
	<p>로그인 여부 : ${ not empty customer ? "로그인 후" : "로그인 전" }</p>  <!--  not null 이냐? 물어보는것  -->
	<p>pageNum 파라미터 여부 :${ empty param.pageNum ? "pageNum 안옴" : "pageNum 넘어옴" }
	<p>name 파라미터 : ${ param.name } </p>
	<p>name 파라미터를 대문자로 : ${ param.name.toUpperCase() }</p> 
	
    
 </body>
</html>
