package com.lec.ex0conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnMySQL {
	public static void main(String[] args) {

		String driver = "com.mysql.cj.jdbc.Driver"; // 8.0 버전
		String url = "jdbc:mysql://localhost:3306/kimdb?serverTimezone=UTC";
		Connection conn = null;
		try {
			// 1.드라이버 로드
			Class.forName(driver);  // 여기 클래스에 오라클 driver를 불러오는 과정 
			System.out.println("드라이버 로딩 성공");
			conn = DriverManager.getConnection(url, "root", "mysql");
			System.out.println("MYSQL DB 연결 성공");
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 오류 : " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("DB 연결 오류 : " + e.getMessage());
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());

			}

		}
	}

}
