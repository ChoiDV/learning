package com.lec.ex4update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
// �����ϰ��� �ϴ� �μ���ȣ �Է� -> �����ϴ� �μ���ȣ���� üũ -> �μ���� ��ġ�� �޾� ����
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
			System.out.print("������ �μ� ��ȣ�� �Է��ϼ��� : ");
			int deptno = sc.nextInt();
			// �Է��� �μ���ȣ�� �ִ��� ������ üũ
			String selectSQL = "SELECT * FROM DEPT WHERE DEPTNO="+deptno;
			rs = stmt.executeQuery(selectSQL);
			if( !rs.next()) {  
				System.out.println("�׷��μ���ȣ�� �����ϴ�.");
			} else {			
			System.out.print("������ �μ����� �Է��ϼ��� : ");
			String dname = sc.next();
			System.out.print("������ ��ġ�� �Է��ϼ��� : ");
			String loc = sc.next();
			String sql = "UPDATE DEPT SET DNAME='" + dname + "',LOC='" + loc + "' WHERE DEPTNO=" + deptno;
			int result = stmt.executeUpdate(sql);
			System.out.println(result > 0 ? "���� ����" : "�ش� �μ��� ���� ����");
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
