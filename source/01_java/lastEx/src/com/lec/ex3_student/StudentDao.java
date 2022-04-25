package com.lec.ex3_student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class StudentDao {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	private static StudentDao INSTANCE;
	public static int SUCCESS = 1;
	public static int FAIL = 0;

	public static StudentDao getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new StudentDao();
		}
		return INSTANCE;
	}

	private StudentDao() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	// 1. 학번검색
	public StudentDto selectSno(int sno) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;		
		StudentDto dto = null;
		String sql = "SELECT sNO, sNAME, mNAME, SCORE \r\n" + "   FROM STUDENT S, MAJOR M\r\n"
				+ "        WHERE S.mNO = M.mNO\r\n" + "            AND sNO = ? ";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sno);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String sname = rs.getString("sname");
				String mname = rs.getString("mname");
				int score = rs.getInt("score");
				dto = new StudentDto(sno, sname, mname, score);
			}

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
		return dto;

	}

	// 2. 이름검색
	public ArrayList<StudentDto> selectSname(String sname) {
		ArrayList<StudentDto> students = new ArrayList<StudentDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT sNO, sNAME, mNAME, SCORE\r\n" + "    FROM STUDENT S , MAJOR M \r\n"
				+ "        WHERE S.mNO = M.mNO\r\n" + "            AND sNAME = ? ";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sname);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int sno = rs.getInt("sno");
				String mname = rs.getString("mname");
				int score = rs.getInt("score");
				students.add(new StudentDto(sno, sname, mname, score));
			}
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
		return students;

	}

	// 3번 전공검색
	public ArrayList<StudentDto> selectMname(String mname) {
		ArrayList<StudentDto> students = new ArrayList<StudentDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT ROWNUM || '등' RANK, A.* "
				+ "    FROM (SELECT sNAME|| '(' || sNO|| ')'  sNAME, mNAME, SCORE " + "    FROM STUDENT S , MAJOR M "
				+ "        WHERE S.mNO = M.mNO AND mNAME = ? " + "            ORDER BY SCORE DESC) A;";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mname);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String rank = rs.getString("rank");
				int sno = rs.getInt("sno");
				String sname = rs.getString("sname");
				int score = rs.getInt("score");
				students.add(new StudentDto(rank, sno, sname, mname, score));
			}
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
		return students;
	}

	// 4번 학생입력
	public int insertStudent(StudentDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO STUDENT (sNO,sNAME,mNO,SCORE) VALUES "
				+ "    (TO_CHAR(SYSDATE,'YYYY') || TRIM(TO_CHAR(STD_SEQ.NEXTVAL,'000')), ? ,(SELECT mNO FROM MAJOR WHERE mNAME= ? ), ? );";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getSname());
			pstmt.setString(2, dto.getMname());
			pstmt.setInt(3, dto.getScore());
			result = pstmt.executeUpdate();
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
		return result;
	}

	// 5번 학생수정
	public int updateStudent(StudentDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE STUDENT SET sNAME = ? , mNO=(SELECT mNO FROM MAJOR WHERE mNAME= ? ), SCORE = ? "
				+ "        WHERE sNO= ? ";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getSname());
			pstmt.setString(2, dto.getMname());
			pstmt.setInt(3, dto.getScore());
			pstmt.setInt(4, dto.getSno());
			result = pstmt.executeUpdate();
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
		return result;

	}

	// 6번 학생 출력
	public ArrayList<StudentDto> selectStudent() {
		ArrayList<StudentDto> students = new ArrayList<StudentDto>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT ROWNUM || '등'  RANK, sNAME, mNAME|| '(' || mNO || ')'  mNAME, SCORE "
				+ "    FROM (SELECT sNAME|| '(' || sNO|| ')'  sNAME, mNAME, SCORE,S.mNO "
				+ "    FROM STUDENT S , MAJOR M " + "        WHERE S.mNO = M.mNO " + "            AND sEXPEL != 1 "
				+ "            ORDER BY SCORE DESC) A";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String rank = rs.getString("rank");
				String sname = rs.getString("sname");
				String mname = rs.getString("mname");
				int score = rs.getInt("score");
				students.add(new StudentDto(rank, sname, mname, score));

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
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
		return students;
	}

	// 7번 제적자 출력
	public ArrayList<StudentDto> selectSexple() {
		ArrayList<StudentDto> students = new ArrayList<StudentDto>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT ROWNUM || '등'  RANK, sNAME, mNAME|| '(' || mNO || ')'  mNAME, SCORE "
				+ "    FROM (SELECT sNAME|| '(' || sNO|| ')'  sNAME, mNAME, SCORE,S.mNO "
				+ "    FROM STUDENT S , MAJOR M " + "        WHERE S.mNO = M.mNO " + "            AND sEXPEL != 0 "
				+ "            ORDER BY SCORE DESC) A";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String rank = rs.getString("rank");
				String sname = rs.getString("sname");
				String mname = rs.getString("mname");
				int score = rs.getInt("score");
				students.add(new StudentDto(rank, sname, mname, score));

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
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
		return students;
	}

	// 8번 제직처리 업데이트
	public int updateSexple(StudentDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE STUDENT SET sEXPEL = 1 " + "    WHERE sNO = ? ";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getSno());
			result = pstmt.executeUpdate();
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
		return result;

	}

}
