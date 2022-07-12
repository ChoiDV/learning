package com.lec.ex6preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Ex1_insertDept {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO DEPT VALUES (?, ?, ?)";
		// �߰��� ������ �ޱ�
		System.out.print("�߰��� �μ� ��ȣ�� �Է��ϼ��� : ");
		int deptno = sc.nextInt();
		System.out.print("�߰��� �μ� �̸��� �Է��ϼ��� : ");
		String dname = sc.next();
		System.out.print("�߰��� �μ� ��ġ�� �Է��ϼ��� : ");
		String loc = sc.next();

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql); // SQL ���� ��ü
			// stmt = conn.createStatement(sql);
			pstmt.setInt(1, deptno); // sql�� ù��° ����ǥ�� int������ deptno�� setting
			pstmt.setString(2, dname); // sql�� �ι�° ����ǥ�� string������ dname �� setting
			pstmt.setString(3, loc); // sql�� ����° ����ǥ�� string������ loc �� setting
			int result = pstmt.executeUpdate();
			System.out.println(result > 0 ? deptno + "�� �μ� �Է� ����" : "�Է½���");

		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
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
