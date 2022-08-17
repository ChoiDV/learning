<%@page import="com.lec.dto.CustomerDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.dao.CustomerDao"%>
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
    <jsp:include page="../main/header.jsp"/>
    <div id="content_form">
    <% // main.jsp 또는 main.jsp?pageNum=3 또는 main.jsp?pageNum=1 
    	String pageNum = request.getParameter("pageNum");
    	if(pageNum == null){
    		pageNum = "1";
    	}
    	int currentPage = Integer.parseInt(pageNum);
    	final int PAGESIZE = 5, BLOCKSIZE = 2;
    	int startRow = (currentPage-1)* PAGESIZE +1;
    	int endRow = startRow + PAGESIZE -1;
    	CustomerDao dao = CustomerDao.getInstance();
    	ArrayList<CustomerDto> customers = dao.listCustomer(startRow, endRow);
    %>
    <table>
    	<%
    		CustomerDto customer = (CustomerDto) session.getAttribute("customer");
    		if(customer != null){ %>
    			<tr>
    				<td colspan="5"><button onclick="location.href='../book/ex1_bookRegisterForm.jsp'">글쓰기</button></td>
    			</tr>
<%     		}
    	%>
    	<tr style="height:60px;">
    		<th>회원 ID</th>
    		<th>비밀번호</th>
    		<th>이름</th>
    		<th>메일</th>
    		<th>주소</th>
    	</tr>
    	<% if(customers.size()== 0){ %>
    		<tr>
    			<td colspan="5">
    				가입된 회원이 없습니다.
    			</td>
    		</tr>
    	<% } else { 
    			for(CustomerDto c : customers){
    				out.println("<tr style='height:60px;'><td>"+c.getCid()+"</td>");
    				out.println("<td>"+c.getCpw()+"</td>");
    				out.println("<td>"+c.getCname()+"</td>");
    				out.println("<td>"+(c.getCemail() != null ? c.getCemail() : "-" )+"</td>");
    				out.println("<td>"+(c.getCaddress() != null ? c.getCaddress() : "-")+"</td></tr>");
    			}
    	   } %>	
    </table><br>
    <div class="paging">
    <%
    	int totCnt = dao.getCustomerCnt(); // 회원수
    	int pageCnt = (int)Math.ceil((double)totCnt/PAGESIZE);
    	int startPage = ((currentPage-1)/BLOCKSIZE) * BLOCKSIZE +1;
    	int endPage = startPage + BLOCKSIZE -1;
    	if( endPage > pageCnt) {
    		endPage = pageCnt;
    	}
    	
        if(startPage > BLOCKSIZE){
    %>   
    	[ <a href="<%=conPath %>/main/main.jsp?pageNum=<%=1 %>">처음으로</a>]
    	[ <a href="<%=conPath %>/main/main.jsp?pageNum=<%=startPage-1 %>">이전</a> ]				
    <% 	}
    	for(int i=startPage; i<= endPage; i++){
    		if(i==currentPage){
    			out.println("[ <b>"+i+"</b> ]");
    		} else {
    			out.println("[ <a href='"+conPath+"/main/main.jsp?pageNum="+i+"'>"+i+"</a> ]");
    		}
    	}
    	if(endPage < pageCnt){
    %>		
    	[ <a href="<%=conPath %>/main/main.jsp?pageNum=<%=endPage+1 %>">다음</a> ]  
    	[ <a href="<%=conPath %>/main/main.jsp?pageNum=<%=pageCnt %>">맨끝으로</a>]	
    <%  } %>
    </div>
    </div>
    <jsp:include page="../main/footer.jsp"/>
 </body>
</html>
