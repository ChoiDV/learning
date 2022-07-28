<%@page import="com.lec.dto.MoneyDto"%>
<%@page import="com.lec.dao.MoneyDao"%>
<%@page import="com.lec.dto.MemberDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %> 
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath%>/css/join.css" rel="stylesheet">
</head>
 <body>
 	<jsp:include page="../main/header.jsp"/>
    <%
    	MemberDao dao = MemberDao.getInstance();
    	ArrayList<MemberDto> memberPrice = dao.memberPrice();
    	
    	MoneyDao mdao = MoneyDao.getInstance();
    	ArrayList<MoneyDto> moneyPrice = mdao.moneyPrice();
    %>
    <table>
    	<tr>
    		<th>회원번호</th>
    		<th>회원성명</th>
    		<th>고객등급</th>
    		<th>매출</th>
    	</tr>
    	<%   for(MemberDto dto : memberPrice){ %>
    			<tr>
    				<td><%=dto.getCustno() %></td>
    				<td><%=dto.getCustname() %></td>
    				<td><%=dto.getGradename() %></td>
    				<td><%=dto.getSum() %></td>
    			</tr>
    	<% 	}%>
    </table>
    <table>
    	<tr>
    		<th>제품코드</th>
    		<th>매출</th>  		 
    	</tr>
    	<%   for(MoneyDto dto : moneyPrice){ %>
    			<tr>
    				<td><%=dto.getPcode() %></td>
    				<td><%=dto.getPrice() %></td>   				
    			</tr>
    	<% 	}%>
    </table>
    <jsp:include page="../main/footer.jsp"/>
 </body>
</html>
