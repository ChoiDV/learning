package com.lec.friend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class FriendDao {
	public static final int SUCCESS = 1; // 회원가입, 정보수정시 성공 리턴값
	public static final int FAIL = 0; // 회원가입, 정보수정시 실패 리턴값

	private static FriendDao instance;

	public static FriendDao getInstance() {
		if (instance == null) {
			instance = new FriendDao();
		}
		return instance;
	}

	private FriendDao() {
	}

	/*
	 * private Connection getConnection() { Connection conn = null; try {
	 * Class.forName("oracle.jdbc.OracleDriver"); conn =
	 * DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott",
	 * "tiger"); } catch (ClassNotFoundException e) { System.out.println("드라이버 오류");
	 * } catch (SQLException e) { System.out.println("url id pw오류"); }
	 * 
	 * return conn; }
	 */

	// 커넥션 풀을 이용한 getConnection함수 : getConnection()
	private Connection getConnection() throws SQLException { // 커넥션 풀 이용
		Connection conn = null;
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
			conn = ds.getConnection();
		} catch (NamingException e) {
			System.out.println(e.getMessage() + "context에러"); 
		}
		return conn;
	}

	// 친구추가하기
	public int joinFriend(FriendDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO FRIEND (NO, NAME, PHONE ) VALUES (FRIEND_SEQ.NEXTVAL, ? , ? )";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setNString(2, dto.getPhone());
			result = pstmt.executeUpdate();
			if (result == SUCCESS) {
				System.out.println("친구추가 성공");
			} else {
				System.out.println("친구추가 실패");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("친구추가 실패 : " + dto);
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}

	// 친구 출력
	public ArrayList<FriendDto> getFriend() {
		ArrayList<FriendDto> dto = new ArrayList<FriendDto>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM FRIEND  ORDER BY NO";
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) { // 없을수가 없음 추가 눌러야만 출력되기때문에 최소 1명이 있음
				int no = rs.getInt("no");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				dto.add(new FriendDto(no, name, phone));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage() + " : 출력 SQL에러");
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
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return dto;
	}

	// 친구 검색
	public ArrayList<FriendDto> searchFriend(String name, String phone) {
		ArrayList<FriendDto> dto = new ArrayList<FriendDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM FRIEND WHERE NAME LIKE '%'||?||'%' AND PHONE LIKE '%'||?||'%'";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, phone);
			rs = pstmt.executeQuery();
			while (rs.next()) { // 없을수가 없음 추가 눌러야만 출력되기때문에 최소 1명이 있음
				int no = rs.getInt("no");
				name = rs.getString("name");
				phone = rs.getString("phone");
				dto.add(new FriendDto(no, name, phone));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage() + " : 출력 SQL에러");
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
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return dto;
	}

}
