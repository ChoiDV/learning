package com.lec.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.lec.dto.FileBoardDto;

public class FileBoardDao {
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;

	private static FileBoardDao instance = new FileBoardDao();

	public static FileBoardDao getInstance() {
		return instance;
	}

	private FileBoardDao() {
	}

	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
			conn = ds.getConnection();
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}

	// 1. 글목록 top-N
	public ArrayList<FileBoardDto> listBoard(int startRow, int endRow) {
		ArrayList<FileBoardDto> dtos = new ArrayList<FileBoardDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM " + "    (SELECT ROWNUM RN, A.* FROM "
				+ "    (SELECT F.*, MNAME FROM FILEBOARD F, MVC_MEMBER M WHERE F.MID=M.MID "
				+ "                ORDER BY FGROUP DESC, FSTEP) A)" + "    WHERE RN BETWEEN ? AND ? ";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int fId = rs.getInt("fid");
				String mId = rs.getString("mid");
				String fTitle = rs.getString("ftitle");
				String fContent = rs.getString("fcontent");
				String fFileName = rs.getString("ffilename");
				Date fRdate = rs.getDate("frdate");
				int fHit = rs.getInt("fhit");
				int fGroup = rs.getInt("fgroup");
				int fStep = rs.getInt("fstep");
				int fIndent = rs.getInt("findent");
				String fIp = rs.getString("fip");
				dtos.add(new FileBoardDto(fId, mId, fTitle, fContent, fFileName, fRdate, fHit, fGroup, fStep, fIndent,
						fIp));
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
		return dtos;
	}

	// 2. 글 개수 가져오기
	public int totalCnt() {
		int totalCnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) FROM FILEBOARD";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			totalCnt = rs.getInt(1);
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
		return totalCnt;
	}

	// 3. 글쓰기 (원글)
	public int writeBoard(String mId,String fTitle,String fContent,String fFileName,String fIp) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO FILEBOARD (FID, MID, FTITLE, FCONTENT, fFILENAME,"
				+ "        FGROUP, FSTEP, FINDENT, FIP)" + "    VALUES (FILEBOARD_SEQ.NEXTVAL, ?, ?, ?, ?, "
				+ "        FILEBOARD_SEQ.CURRVAL, 0 , 0 , ? )";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mId);
			pstmt.setString(2, fTitle);
			pstmt.setString(3, fContent);
			pstmt.setString(4, fFileName);
			pstmt.setString(5, fIp);
			result = pstmt.executeUpdate();
			System.out.println(result == SUCCESS ? "글 작성 성공" : "글 작성 실패");
		} catch (SQLException e) {
			System.out.println(e.getMessage()+"글 작성 실패");
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

	// 4. 조회수 올리기
	private void fHitUp(int fid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE FILEBOARD SET FHIT = FHIT +1 WHERE FID=? ";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fid);
			pstmt.executeUpdate();
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

	// 5. fId로 글 dto 보기 ( 글 상세보기 ) 글번호로 글 상세보기
	public FileBoardDto viewContent(int fId) {
		FileBoardDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT F.*, MNAME FROM FILEBOARD F, MVC_MEMBER M WHERE M.MID=F.MID AND FID= ? ";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				fHitUp(fId);  // 조회수 올리기
				String mId = rs.getString("mid");
				String fTitle = rs.getString("ftitle");
				String fContent = rs.getString("fcontent");
				String fFileName = rs.getString("ffilename");
				Date fRdate = rs.getDate("frdate");
				int fHit = rs.getInt("fhit");
				int fGroup = rs.getInt("fgroup");
				int fStep = rs.getInt("fstep");
				int fIndent = rs.getInt("findent");
				String fIp = rs.getString("fip");
				dto = new FileBoardDto(fId, mId, fTitle, fContent, fFileName, fRdate, fHit, fGroup, fStep, fIndent,
						fIp);
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

	// 6. -- (6) 글 수정하기(FId, FTitle, FContent, FILENAME, FIp, FDATE)
	public int updateBoard(FileBoardDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE FILEBOARD SET FTITLE = ? ," + 
				"                    FCONTENT = ?," + 
				"                    fFILENAME =? ," + 
				"                    FIP = ? ," + 
				"                    FRDATE = SYSDATE" + 
				"            WHERE FID = ? ";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getfTitle());
			pstmt.setString(2, dto.getfContent());
			pstmt.setString(3, dto.getfFileName());
			pstmt.setString(4, dto.getfIp());
			pstmt.setInt(5, dto.getfId());
			result = pstmt.executeUpdate();	
			System.out.println(result == SUCCESS ? "글 수정 성공" : "글 수정 실패");
		} catch (SQLException e) {
			System.out.println(e.getMessage()+"글 수정 실패");
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
	
	// 7.글 삭제하기 fid로 
	public int deleteBoard(int fId) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM FILEBOARD WHERE FID=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fId);
			result = pstmt.executeUpdate();	
			System.out.println(result == SUCCESS ? "글 삭제 성공" : "글 삭제 실패");
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "글 삭제 실패");
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
	// 답변글 추가 전 step A
	private void stepA(int fGroup, int fStep) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE FILEBOARD SET FSTEP = FSTEP+1 " + 
				"    WHERE FGROUP = ? AND FSTEP>?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fGroup);
			pstmt.setInt(2, fStep);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "stepA 실패");
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
	
	// 9.답변글 쓰기
	public int reply(String mId,String fTitle,String fContent,String fFileName,int fGroup,int fStep,int fIndent,String fIp) {
		int result = FAIL;
		stepA(fGroup, fStep);
		Connection conn = null;
		PreparedStatement pstmt = null;		
		String sql = "INSERT INTO FILEBOARD (FID, MID, FTITLE, FCONTENT, fFILENAME," + 
				"        FGROUP, FSTEP, FINDENT, FIP)" + 
				"    VALUES (FILEBOARD_SEQ.NEXTVAL, ? ,? ,?, ?," + 
				"        ?, ?, ?, ?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mId);
			pstmt.setString(2, fTitle);
			pstmt.setString(3, fContent);
			pstmt.setString(4, fFileName);
			pstmt.setInt(5, fGroup);
			pstmt.setInt(6, fStep+1);  // 꼭 +1 쓰기   
			pstmt.setInt(7, fIndent+1);
			pstmt.setString(8, fIp);
			result = pstmt.executeUpdate();
			System.out.println(result == SUCCESS ? "답변글 성공" : "답변글 실패 ");
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "reply 답변글 실패");
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
