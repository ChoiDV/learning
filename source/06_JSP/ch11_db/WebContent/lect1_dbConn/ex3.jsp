<%@page import="java.sql.Timestamp"%>
<%@page import="java.sql.Date"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
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
 <%
	String deptnoStr = request.getParameter("deptno");
	if ( deptnoStr == null){
		deptnoStr = "-1";
	}
	int deptno = Integer.parseInt(deptnoStr);
	
	// 드라이버 url 
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";   
	String uid = "scott";
	String upw = "tiger";
	
	// db 연결객체 선언
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	// sql문 작성
	String deptnoSql = "SELECT * FROM DEPT";
	String selectSql = "SELECT * FROM EMP WHERE DEPTNO="+deptno;
	
	
 %>
    <form action="">
    	부서번호<select name="deptno">
    			<option value="0"></option>
    			<!--  .. DB에서 가져온 부서번호를 option에 추가 -->
    			<%
    				try{
    					Class.forName(driver);
    					conn = DriverManager.getConnection(url,uid,upw);
    					stmt = conn.createStatement();
    					rs = stmt.executeQuery(deptnoSql);
    					while(rs.next()){
    						int deptnoDB = rs.getInt("deptno");
 							String dname = rs.getString("dname");
 							if(deptno != deptnoDB){
 								out.println("<option value='"+deptnoDB+"'>"+deptnoDB+"("+dname+")"+"</option>");
 							} else {
 								out.println("<option value='"+deptnoDB+"' selected='selected'>"+deptnoDB+"("+dname+")"+"</option>");
 							} // db에서 넘어온것과 내가 선택한것이 같을때만 selected='selected'를 넣어줘라. 즉 내가 고른것이 체크 되어있게 																
    					}  					
    				} catch(Exception e){
    					System.out.println("에러 메세지 : " + e.getMessage());
    				} finally{
    					if( rs!= null){
    						rs.close();
    					}
    					if( stmt != null){
    						stmt.close();
    					}
    					if(conn != null){
    						conn.close();
    					}    						    					
    				}
    			%>		
   			</select>
   		<input type="submit" value="검색">
   		<% if(deptno != -1){ %>
   		<table>
   			<!-- 파라미터로 받은 부서번호의 사원정보 테이블 추가 -->
   			<%
   			try{
   				// Class.forName(driver); 이거는 위에서 해줬기 때문에 한번만 해줘도 됨.
   				// 나머지 conn, stmt, rs 는 위에서 close() 를 했기때문에  null인 상태이기 때문에 다시 
				conn = DriverManager.getConnection(url,uid,upw);
				stmt = conn.createStatement();
   				rs = stmt.executeQuery(selectSql);
   			if(rs.next()){  // 해당 부서 사원이 있는 경우	
   	 			out.println("<tr><th>사번</th><th>이름</th><th>직책</th><th>상사사번</th>");
   				out.println("<th>입사일</th><th>급여</th><th>상여</th><th>부서번호</th>"); // 타이틀						
   				do{ 
   					// 변수이름과 db의 타이틀이름과 같게하는것을 추천
   					int empno = rs.getInt("empno");
   					String ename = rs.getString("ename");
   					String job = rs.getString("job");
   					int mgr = rs.getInt("mgr");
   					//String hiredate = rs.getString("hiredate");
   					Timestamp hiredate = rs.getTimestamp("hiredate");
   					int sal = rs.getInt("sal");
   					int comm = rs.getInt("comm");
   					out.println("<tr><td>"+empno+"</td><td>"+ename+"</td><td>"+job +"</td><td>"+mgr+"</td>");
   					out.println("<td>"+hiredate+"</td><td>"+sal+"</td><td>"+comm+"</td><td>"+deptno+"</td></tr>");
   				} while (rs.next());
   	 			
   	 		} else { // 해당부서 사원이 없는 경우
   	 			out.println("<tr><td>사원이 없습니다.</td></tr>");
   	 		}
   			} catch (Exception e) {
   				System.out.println("에러 메세지 : " + e.getMessage());
   			} finally{
				if( rs!= null){
					rs.close();
				}
				if( stmt != null){
					stmt.close();
				}
				if(conn != null){
					conn.close();
				}    						    					
			}
   			%>
   		</table>
   		<% } else { %>
   		<table>
   			<tr><td>동준좌 도망쳐!!!</td></tr>
   		</table>
   		<% } %>
    </form>
 </body>
</html>
