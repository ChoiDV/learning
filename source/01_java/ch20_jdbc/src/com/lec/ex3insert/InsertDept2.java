package com.lec.ex3insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//�μ���ȣ�� �Է¹޾� �ߺ�üũ�� Ȯ���� �Է�����
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
				System.out.print("�Է��� �μ� ��ȣ�� ? : ");
				deptno = sc.nextInt();
				String selectSQL = "SELECT COUNT(*) \"CNT\" FROM DEPT WHERE DEPTNO=" + deptno;
				rs = stmt.executeQuery(selectSQL);
				rs.next(); // �̰� �ؾ� ù��° ���� ������
				int cnt = rs.getInt("cnt");
				if (cnt == 0) {
					break;
				} else {
					System.out.println("�ߺ��Դϴ�. �ٽ� �Է��ϼ���.");
				}
			} while (true);
			System.out.println("�Է��� �μ����� ? : ");
			String dname = sc.next();
			System.out.println("�Է��� �μ���ġ�� ? : ");
			String loc = sc.next();
			String sql = "INSERT INTO DEPT VALUES(" + deptno + ",'" + dname + "','" + loc + "')";
			int result = stmt.executeUpdate(sql);
			System.out.println(result > 0 ? "�Է¼���" : "�Է½���");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println("SQL ���� " + e.getMessage());
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
	// �Է��� �ߴµ� ����� �����ʰ� ��� ���ุ �ȴٸ� ��𼱰� �����͸� �ְ� COMMIT�� ���߰ų�, close()�� ���Ѱ��̴�.
}
