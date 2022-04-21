package com.lec.ex2selectwhere;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Ex2_SelectDeptnoEmp {
// ��
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);
		System.out.print("���ϴ� �μ� ��ȣ�� ? : ");
		int deptno = sc.nextInt();
		String sql1 = "SELECT * FROM DEPT WHERE DEPTNO=" + deptno;
		String sql2 = "SELECT W.EMPNO, W.ENAME, W.SAL, M.ENAME MANAGER\r\n" + "    FROM EMP W, EMP M\r\n"
				+ "        WHERE W.MGR = M.EMPNO AND W.DEPTNO=30 ";
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql1);
			if (rs.next()) {
				System.out.println("�μ���ȣ : " + deptno);
				System.out.println("�μ��̸� : " + rs.getString("dname"));
				System.out.println("�μ���ġ : " + rs.getString("loc"));
				rs.close();
				rs = stmt.executeQuery(sql2);  // empno,ename, sal, manager
				if(rs.next()) {
					System.out.println("���\t�̸�\t�޿�\t����");
					do {
						int empno = rs.getInt("empno");
						String ename = rs.getString("ename");
						int sal = rs.getInt("sal");
						String manager = rs.getString("manager");			
						System.out.println(empno+"\t"+ename+"\t"+sal+"\t"+manager);
					} while (rs.next());
				} else {
					System.out.println(deptno + " �� �μ� ����� �����ϴ�.");
				}
				
			} else {
				System.out.println(deptno + "�� �μ��� ��ȿ���� �ʽ��ϴ�.");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}

		}

	}

}
