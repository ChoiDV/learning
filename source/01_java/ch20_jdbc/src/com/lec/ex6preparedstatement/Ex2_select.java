package com.lec.ex6preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Ex2_select {
// ����ڷκ��� �μ����� �Է¹޾� �ش� �μ� ����� ���,�̸�, ��å, �޿��� ����Ͻÿ�
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
				System.out.println("�μ����� �Է��ϼ��� : ");
				String dname = sc.next();
				Class.forName(driver);
				conn = DriverManager.getConnection(url, "scott", "tiger");
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, dname);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					System.out.println("���\t�̸�\t��å\t\t�޿�");
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
					System.out.println("���ºμ� �ٽ� �Է��ϼ���.");
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