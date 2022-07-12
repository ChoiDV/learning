package com.lec.ex3insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//부서번호를 입력받아 중복체크를 확인후 입력진행
public class InsertDept2 {

	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		int deptno;
		// sql = String.format("INSERT INTO DEPT
		// VALUES(%d,'%s','%s')",deptno,dname,loc);
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			do {
				System.out.print("입력할 부서 번호는 ? : ");
				deptno = sc.nextInt();
				String selectSQL = "SELECT COUNT(*) \"CNT\" FROM DEPT WHERE DEPTNO=" + deptno;
				rs = stmt.executeQuery(selectSQL);
				rs.next(); // 이걸 해야 첫번째 행을 가져옴
				int cnt = rs.getInt("cnt");
				if (cnt == 0) {
					break;
				} else {
					System.out.println("중복입니다. 다시 입력하세요.");
				}
			} while (true);
			System.out.println("입력할 부서명은 ? : ");
			String dname = sc.next();
			System.out.println("입력할 부서위치는 ? : ");
			String loc = sc.next();
			String sql = "INSERT INTO DEPT VALUES(" + deptno + ",'" + dname + "','" + loc + "')";
			int result = stmt.executeUpdate(sql);
			System.out.println(result > 0 ? "입력성공" : "입력실패");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println("SQL 오류 " + e.getMessage());
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
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
	// 입력을 했는데 결과가 뜨지않고 계속 실행만 된다면 어디선가 데이터를 넣고 COMMIT을 안했거나, close()를 안한것이다.
}
