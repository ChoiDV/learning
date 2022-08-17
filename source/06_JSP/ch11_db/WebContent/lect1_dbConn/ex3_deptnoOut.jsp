<%@page import="java.sql.Date"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
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
 	String driver = "oracle.jdbc.driver.OracleDriver";
 	String url = "jdbc:oracle:thin:@localhost:1521:xe";   // 127.0.0.1  이 localhost 를 의미 
 	String uid = "scott";
 	String upw = "tiger"; 
 	Connection conn = null;
 	PreparedStatement pstmt = null;
 	ResultSet rs = null;
 	String sql = "SELECT * FROM EMP WHERE DEPTNO=?";
 	String deptnoStr = request.getParameter("deptno");
 	if (deptnoStr == null ){
 		deptnoStr = "0";		
 	}
 	int deptno = Integer.parseInt(deptnoStr);
 	try{
 		Class.forName(driver); // 1단계
 		conn = DriverManager.getConnection(url, uid, upw);// 2단계
 		pstmt = conn.prepareStatement(sql); // 3단계
 		pstmt.setInt(1, deptno);
 		rs = pstmt.executeQuery(); // 4단계 + 5단계
 		
 		if(rs.next()){ 			
 			out.println("<tr><th>사번</th><th>이름</th><th>직책</th><th>상사사번</th>");
			out.println("<th>입사일</th><th>급여</th><th>상여</th><th>부서번호</th>"); // 타이틀						
			do{ 
				// 변수이름과 db의 타이틀이름과 같게하는것을 추천
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				int mgr = rs.getInt("mgr");
				//String hiredate = rs.getString("hiredate");
				Date hiredate = rs.getDate("hiredate");
				int sal = rs.getInt("sal");
				int comm = rs.getInt("comm");
				out.println("<tr><td>"+empno+"</td><td>"+ename+"</td><td>"+job +"</td><td>"+mgr+"</td>");
				out.println("<td>"+hiredate+"</td><td>"+sal+"</td><td>"+comm+"</td><td>"+deptno+"</td></tr>");
			} while (rs.next());
 			
 		} else {
 			out.println("<tr><td>사원이 없습니다.</td></tr>");
 		}
 		
 		
 	}catch(Exception e){
 		
 	} finally {
 		try{ // 7단계 : 연결해제 
			if(rs != null) {
				rs.close();
			}
			if( pstmt != null){
				rs.close();
			}
			if ( conn != null ){
				conn.close();
			}
		}catch(Exception e){
			System.out.println("에러 메세지 : " + e.getMessage());
		}
 	}
 %>
</table>
 	<button onclick="location.href='ex3_deptnoin.jsp'">다시검색</button>

    
 </body>
</html>
