package com.lec.ex3insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertDept {

	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);
		System.out.print("입력할 부서 번호는 ? : ");
		int deptno = sc.nextInt();
		System.out.println("입력할 부서명은 ? : ");
		String dname = sc.next();
		System.out.println("입력할 부서위치는 ? : ");
		String loc = sc.next();
		String sql = "INSERT INTO DEPT VALUES(" + deptno + ",'" + dname + "','" + loc + "')";
		// sql = String.format("INSERT INTO DEPT VALUES(%d,'%s','%s')",deptno,dname,loc
		// );
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			int result = stmt.executeUpdate(sql);
			System.out.println(result > 0 ? "입력성공" : "입력실패");

		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println("SQL 오류 " + e.getMessage());
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}

			} catch (SQLException e) {
				
			}
		}
		// 입력을 했는데 결과가 뜨지않고 계속 실행만 된다면 어디선가 데이터를 넣고 COMMIT을 안했거나, close()를 안한것이다.
	}

}
