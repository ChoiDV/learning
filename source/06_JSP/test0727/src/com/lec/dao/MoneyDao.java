package com.lec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.lec.dto.MoneyDto;

public class MoneyDao {
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	
	private static MoneyDao instance; 

	public static MoneyDao getInstance() {
		if (instance == null) {
			instance = new MoneyDao();
		}
		return instance;
	}

	private MoneyDao() {
	}

	// conn 객체 리턴하는 함수
	private Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
		return conn;
	}
	
	// 매출 조회
	public ArrayList<MoneyDto> moneyPrice(){
		ArrayList<MoneyDto> money = new ArrayList<MoneyDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT PCODE , SUM(PRICE) SUM FROM MONEY GROUP BY PCODE ORDER BY PCODE";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String pcode = rs.getString("pcode");
				int price = rs.getInt("sum");
				money.add(new MoneyDto(0, 0, 0, 0, price, pcode, null));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}  finally {
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
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		return money;
	}
}
