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
 	<h3> ex3_suView.jsp입니다.</h3>
    <h3> 1부터 ${ param.su } 까지 누적합은 : ${ sum } 입니다. </h3>
    <button onclick="history.back()">이전</button>
    <button onclick="location.href='<%=conPath %>/1_dispatcher/ex3_suInput.jsp'">다시</button>
    		<!--  location 링크를 왜  폴더명부터 시작하는지는 forward로 넘어왔기때문에 현재 위치는 루트라서    -->
    		<!--  그래서 생각하기 귀찮고 어려우니까 conPath 넣고 하기 추천  -->
 </body>
</html>
