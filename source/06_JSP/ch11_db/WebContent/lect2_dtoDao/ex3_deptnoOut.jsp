
<%@page import="com.lec.dao.EmpDAO"%>
<%@page import="com.lec.dto.EmpDTO"%>
<%@page import="java.util.ArrayList"%>
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
 	<table>
 <%
 	int deptno = Integer.parseInt(request.getParameter("deptno"));
 	EmpDAO dao = EmpDAO.getInstance();
 	ArrayList<EmpDTO> dtos = dao.selectDeptno(deptno);
 		if(!dtos.isEmpty()){  // dtos에 데이터가 있는 경우( isEmpty() 는 비었냐? 라고 물어봐서 비었으면 true 차있으면 false)
 			//out.println("<tr><th>사번</th><th>이름</th><th>직책</th><th>상사사번</th>");
			//out.println("<th>입사일</th><th>급여</th><th>상여</th><th>부서번호</th>");
			for(EmpDTO dto : dtos){
				out.println("<tr><td>"+dto.getEmpno()+"</td><td>"+dto.getEname()+
						"</td><td>"+dto.getHiredate() +"</td><td>"+dto.getDeptno() +"</td>");						
			}
 		} else {
 			out.println("<tr><td>사원이 없습니다.</td></tr>");
 		}
 		
 %>
</table>
 	<button onclick="location.href='ex3_deptnoin.html'">다시검색</button>

    
 </body>
</html>
