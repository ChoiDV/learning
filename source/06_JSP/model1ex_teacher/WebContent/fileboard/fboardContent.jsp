<%@page import="com.lec.dto.CustomerDto"%>
<%@page import="com.lec.dto.FileBoardDto"%>
<%@page import="com.lec.dao.FileBoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <link href="<%=conPath%>/css/style.css" rel="stylesheet">
  <style>
		#content_form{
			height: 570px; 
			padding-top:30px;
		}
	</style> 
</head>
 <body>
 	<jsp:include page="../main/header.jsp"/>
 	<div id="content_form">
 	<%
 		String pageNum = request.getParameter("pageNum");
 		int fnum = Integer.parseInt(request.getParameter("fnum"));
 		FileBoardDao dao = FileBoardDao.getInstance();
 		dao.hitUp(fnum);
 		FileBoardDto dto = dao.getBoard(fnum); 
 	%>
 		<table>
 			<caption>글 상세보기</caption>
 			<tr>
 				<th>글번호</th>
 				<td><%=dto.getFnum() %></td>
 			</tr>
 			<tr>
 				<th>글제목</th>
 				<td><%=dto.getFsubject() %></td>
 			</tr>
 			<tr>
 				<th>작성자</th>
 				<td>
 				<%=dto.getCname() %>
 					( <a href="mailto:<%=dto.getCemail() != null ? dto.getCemail() : " - " %>">
 					<%=dto.getCemail() != null ? dto.getCemail() : " - " %>
 					</a>)	
 				</td>
 			</tr>
 			<tr>
 				<th>첨부파일</th>
 				<td>
 					<%
 						if(dto.getFfilename() == null){
 							out.println("첨부파일 없음.");
 						} else {
 							out.println("<a href='../fileboardUpload/"+dto.getFfilename()+"'>"+dto.getFfilename() + "</a>");
 						}
 					%>
 				</td>
 			</tr>
 			<tr>
 				<th>본문</th>
 				<td>
 					<pre><%=dto.getFcontent() %></pre>
 				</td>
 			</tr>
 			<tr>
 				<th>작성일</th>
 				<td>
 					<pre><%=dto.getFrdate() %></pre>
 				</td>
 			</tr>
 			<tr>
 				<th>조회수</th>
 				<td>
 					<pre><%=dto.getFhit() %></pre>
 				</td>
 			</tr>
 			<tr>
 				<th>IP</th>
 				<td>
 					<pre><%=dto.getFip() %></pre>
 				</td>
 			</tr>
			<tr>
				<td colspan="2">  <!--  목록/수정/답변/삭제 -->
						<button onclick="location='fboardList.jsp?pageNum=<%=pageNum %>'">목록</button>
					<%
						String cid = null;
						CustomerDto customer = (CustomerDto) session.getAttribute("customer");
						if(customer != null){ 
							cid = customer.getCid();  // 세션에 있는 id를 cid에 넣음  // customer가 null이 아니면 로그인 했다는 소리 
						}
						if(dto.getCid().equals(cid)){
					%>	
						<button onclick="location='fboardUpdateForm.jsp?fnum=<%=fnum %>&pageNum=<%=pageNum %>' ">수정</button>	
					<% 	} %>
					<%
						if(customer != null){ // 로그인했으면 답변글 가능
					%>
						<button onclick="location='fboardWriteForm.jsp?fnum=<%=fnum %>&pageNum=<%=pageNum %>' " >답변</button>  		
					<% 	} %>
						<button onclick="location='fboardDeleteForm.jsp?fnum=<%=fnum %>&pageNum=<%=pageNum %>' ">삭제</button>
				</td>
			</tr>			
 		</table>
 	</div>
    <jsp:include page="../main/footer.jsp"/>
 </body>
</html>
