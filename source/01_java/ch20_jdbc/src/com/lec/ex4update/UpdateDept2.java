package com.lec.ex4update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
// 수정하고자 하는 부서번호 입력 -> 존재하는 부서번호인지 체크 -> 부서명과 위치를 받아 수정
public class UpdateDept2 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();				
			System.out.print("수정할 부서 번호를 입력하세요 : ");
			int deptno = sc.nextInt();
			// 입력한 부서번호가 있는지 없는지 체크
			String selectSQL = "SELECT * FROM DEPT WHERE DEPTNO="+deptno;
			rs = stmt.executeQuery(selectSQL);
			if( !rs.next()) {  
				System.out.println("그런부서번호는 없습니다.");
			} else {			
			System.out.print("수정할 부서명을 입력하세요 : ");
			String dname = sc.next();
			System.out.print("수정할 위치를 입력하세요 : ");
			String loc = sc.next();
			String sql = "UPDATE DEPT SET DNAME='" + dname + "',LOC='" + loc + "' WHERE DEPTNO=" + deptno;
			int result = stmt.executeUpdate(sql);
			System.out.println(result > 0 ? "수정 성공" : "해당 부서는 존재 안함");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}

	}
}
