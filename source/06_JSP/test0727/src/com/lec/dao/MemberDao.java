package com.lec.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.lec.dto.MemberDto;


public class MemberDao {
	
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	
	private static MemberDao instance; 

	public static MemberDao getInstance() {
		if (instance == null) {
			instance = new MemberDao();
		}
		return instance;
	}

	private MemberDao() {
	}

	// conn 객체 리턴하는 함수
	private Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
		return conn;
	}
	
	// 회원 등록
	public int insertMember(MemberDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO MEMBER VALUES (MEMBER_SQ.NEXTVAL, ? , ? , ?, SYSDATE ,?,?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getCustname());
			pstmt.setString(2, dto.getPhone());
			pstmt.setString(3, dto.getAddress());
			pstmt.setString(4, dto.getGrade());
			pstmt.setString(5,dto.getCity());
			result = pstmt.executeUpdate();
			System.out.println("회원가입 성공");
		} catch (Exception e) {
			System.out.println(e.getMessage()+"회원가입 실패 : " + dto);
		} finally {
			try {				
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
		return result;
	}
	
	// 회원 목록
	public ArrayList<MemberDto> memberList(){
		ArrayList<MemberDto> member = new ArrayList<MemberDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM MEMBER";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int custno = rs.getInt("custno");
				String custname = rs.getString("custname");
				String phone = rs.getString("phone");
				String address = rs.getString("address");
				Date joinDate = rs.getDate("joinDate");
				String grade = rs.getString("grade");
				String city = rs.getString("city");
				member.add(new MemberDto(custno, custname, phone, address, joinDate, grade, null, city, 0) );
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
		return member;
	}
	
	// 회원 매출 조회 
	public ArrayList<MemberDto> memberPrice(){
		ArrayList<MemberDto> member = new ArrayList<MemberDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT MEMBER.CUSTNO, MEMBER.CUSTNAME, GRADENAME, (SELECT SUM(PRICE) FROM MONEY WHERE CUSTNO = MEMBER.CUSTNO) SUM FROM" + 
				"    MEMBER MEMBER , GRADE G" + 
				"        WHERE MEMBER.GRADE = G.GRADE";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int custno = rs.getInt("custno"); 
				String custname = rs.getString("custname");
				String gradename = rs.getString("gradename");
				int sum = rs.getInt("sum");
				member.add(new MemberDto(custno, custname, null, null, null, null, gradename, null, sum));
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
		return member;
	}
	
	// 회원 dto 가져오기 
	public MemberDto getMember(int custno) {
		MemberDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM MEMBER " + 
				"    WHERE CUSTNO = ? ";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, custno);
			rs = pstmt.executeQuery();
			if (rs.next()) {				
				String custname = rs.getString("custname");
				String phone = rs.getString("phone");
				String address = rs.getString("address");
				Date joinDate = rs.getDate("joinDate");
				String grade = rs.getString("grade");
				String city = rs.getString("city");
				dto = new MemberDto(custno, custname, phone, address, joinDate, grade, null, city, 0);
			} else {
				 System.out.println("해당 custno으로 검색된 사람이 없습니다.");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if( rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if( conn != null) {
					conn.close();
				}
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return dto;
	}
	
	// 회원번호 자동발생
	public int maxNo() {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT (MAX(CUSTNO)+1) MAXNO FROM MEMBER";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			result = rs.getInt("maxno");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if( rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if( conn != null) {
					conn.close();
				}
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	
	// 5. 회원정보 수정
    public int updateMember(MemberDto dto) {
       int result = FAIL;
       Connection conn = null;
       PreparedStatement pstmt = null;
       String sql = "UPDATE MEMBER SET CUSTNAME =?," + 
       		"                                PHONE=?," + 
       		"                                   ADDRESS=?," + 
       		"                                     GRADE = ?," + 
       		"                                        CITY=?" + 
       		"                            WHERE CUSTNO = ?";
       
          try {
             conn = getConnection();
             pstmt = conn.prepareStatement(sql);
             pstmt.setString(1, dto.getCustname());
             pstmt.setString(2, dto.getPhone());
             pstmt.setString(3, dto.getAddress());
             pstmt.setString(4, dto.getGrade());
             pstmt.setString(5, dto.getCity());
             pstmt.setInt(6, dto.getCustno());;
             result = pstmt.executeUpdate();
             System.out.println("정보수정성공");
          } catch (Exception e) {
             System.out.println(e.getMessage());
          }finally {
          try {
             if(pstmt!=null) {
            	 pstmt.close();
             }
             if(conn!=null) {
            	 conn.close();
             }
          } catch (Exception e) {
             System.out.println(e.getMessage());
          }
       }
       return result;
    }
	
}
