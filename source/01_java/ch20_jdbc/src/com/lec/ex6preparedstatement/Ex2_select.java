package com.lec.ex6preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Ex2_select {
// 사용자로부터 부서명을 입력받아 해당 부서 사원의 사번,이름, 직책, 급여를 출력하시오
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT EMPNO, ENAME, JOB, SAL" + "    FROM EMP E, DEPT D\r\n"
				+ "        WHERE E.DEPTNO=D.DEPTNO\r\n" + "            AND DNAME=UPPER(?)";

		try {
			do {
				System.out.println("부서명을 입력하세요 : ");
				String dname = sc.next();
				Class.forName(driver);
				conn = DriverManager.getConnection(url, "scott", "tiger");
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, dname);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					System.out.println("사번\t이름\t직책\t\t급여");
					while (rs.next()) {
						int empno = rs.getInt("empno");
						String ename = rs.getString("ename");
						String job = rs.getString("job");
						int sal = rs.getInt("sal");
						if (job.length() >= 8) {
							System.out.println(empno + "\t" + ename + "\t" + job + "\t" + sal);
						} else {
							System.out.println(empno + "\t" + ename + "\t" + job + "\t\t" + sal);
						}
					}
					break;
				} else {
					System.out.println("없는부서 다시 입력하세요.");
				}

			} while (true);

		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
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