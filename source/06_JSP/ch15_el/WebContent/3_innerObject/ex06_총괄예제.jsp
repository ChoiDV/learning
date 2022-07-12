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
    <form>
    <p>
    	<input type="number" name="su1" value="<%=(int)(Math.random()*9)+1 %>">*
    	<input type="number" name="su2" value="<%=(int)(Math.random()*9)+1 %>">=
    	<input type="number" name="R" autofocus="autofocus">
    </p>
    <p>
    	<input type="submit" value="확인">
    </p>
    </form>
    <p>
    	 ${ param.su1 } * ${ param.su2 } = ${param.R } 는  ${param.R  eq param.su1*param.su2  } <br>   	 
    	 ${ param.su1 } * ${ param.su2 } = ${param.R } 는  ${param.R eq param.su1*param.su2} ${param.R eq param.su1*param.su2 ? "정답" : "오답"}  	
    </p>
 </body>
</html>
