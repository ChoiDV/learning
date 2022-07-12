package com.lec.ex1selectall;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

public class SelectAllOracle {
	// 오라클과 MySQL 은 driver와 url만 다르고 다 똑같다.
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection conn = null; // DB 연결 객체 변수
		Statement stmt = null; // SQL 전송 객체 변수
		ResultSet rs = null; // SELECT문 결과 받는 객체 변수 select 받을때만 사용
		// select문 - 결과가 여러줄
		// insert, update, delete문 - 결과가 정수
		String query = "SELECT * FROM EMP";
		try {
			// (1) 드라이버 로드 
			Class.forName(driver);
			// (2) DB 연결
			conn = DriverManager.getConnection(url, "scott", "tiger");
			//  (3)SQL문 전송 객체 생성
			stmt = conn.createStatement();  
			// (4) SQL 전송 + (5) rs에 SQL전송 결과 받기
			rs = stmt.executeQuery(query);
			// (6) 결과 받아 원하는 로직 수행
			System.out.println("사번\t이름\t직책\t\t상사사번\t입사일\t급여\t상여\t부서번호");
			while(rs.next()) {   // rs.next() : 한줄 한줄 받아오다가 끝이 되서 다음에 받아올것이 없으면 false return;
				//  rs.getInt("여기") 에는 테이블이 타이틀을 적는것
				//  rs.getString("여기") 도 마찬가지
				int empno = rs.getInt("empno");  // 정수형으로 가져오기 
				//String empno = rs.getString("empno"); // 문자열로 가져오기 
				String ename = rs.getString("ename");  // varchar2 는 String으로 받기
				String job = rs.getString("job");
				int mgr = rs.getInt("mgr");
//				String hiredate = rs.getString("hiredate");  // date형은 date로 받아도되고 문자열로 받아도되고 Timestamp로 받아도됨
				Date hiredate = rs.getDate("hiredate");   // import sql로 하기
//				Timestamp hiredate = rs.getTimestamp("hiredate");  // import sql로 하기
				int sal = rs.getInt("sal");
				int comm = rs.getInt("comm");
				int deptno = rs.getInt("deptno");			
				if(job.length() < 8) {
					System.out.println(empno+"\t"+ename+"\t"+job+"\t\t"+mgr+"\t"+hiredate+"\t"+sal+"\t"+comm+"\t"+deptno);
//					System.out.printf("%d\t%s\t%s\t\t%d\t%TF\t%d\t%d\t%d\n",
//					empno,ename,job,mgr,hiredate,sal,comm,deptno);
				} else {
					System.out.println(empno+"\t"+ename+"\t"+job+"\t"+mgr+"\t"+hiredate+"\t"+sal+"\t"+comm+"\t"+deptno);
//					System.out.printf("%d \t %s \t %s \t %d \t %TF \t %d \t %d \t %d\n",
//					empno,ename,job,mgr,hiredate,sal,comm,deptno);
					
				}

			}
		} catch (ClassNotFoundException e ) {
			System.out.println(e.getMessage()); // driver 로딩 오류
		} catch (SQLException e) {
			System.out.println(e.getMessage()); // DB 연결 오류
		} finally {
			// (7) 연결해제
			try {        //  종료할때 만든순서 반대로  
				// 만든순서 : conn > stmt > rs
				// 닫는순서 : rs > stmt > conn 
				if (rs != null) {
					rs.close();
				}
				if( stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());

			}

		}
	}
}
