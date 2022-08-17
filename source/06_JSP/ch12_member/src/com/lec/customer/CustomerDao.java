package com.lec.customer;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class CustomerDao {
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	
	private static CustomerDao instance;

	public static CustomerDao getInstance() {
		if (instance == null) {
			instance = new CustomerDao();
		}
		return instance;
	}

	private CustomerDao() {
	}

	private Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
		return conn;
	}
	
	// 로그인
	public int comfirmId(String cId) {
		int result = SUCCESS; 
		// 중복인지 사용가능인지 sql으로 조회 : SELECT * FROM MEMBER WHERE ID='aaa';
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM CUSTOMER WHERE CID= ? ";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setNString(1, cId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = FAIL; // 있는 ID 라는 의미
			} else {
				result = SUCCESS;  // 없는 ID
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
		return result;
	}
	
	//-- 2. 회원가입 : public int joinMember(MemberDto dto)
		public int joinMember(CustomerDto dto) {
			int result= FAIL;
			// dto DB에 insert
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql = "INSERT INTO CUSTOMER (CID, CPW, CNAME, CTEL, CEMAIL, CADDRESS, CGENDER, CBIRTH) " + 
					"    VALUES ( ? , ? , ? , ? , ? , ? , ? , ? )";
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,  dto.getcId());
				pstmt.setString(2,  dto.getcPw());
				pstmt.setString(3,  dto.getcName());
				pstmt.setString(4,  dto.getcTel());
				pstmt.setString(5,  dto.getcEmail());
				pstmt.setString(6,  dto.getcAddress());
				pstmt.setString(7,  dto.getcGender());
				pstmt.setDate(8,  dto.getcBirth());
				result = pstmt.executeUpdate();
				System.out.println(result == SUCCESS ? "회원가입성공" : "회원가입실패");			
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("회원가입 실패 : " + dto);
			} finally {
				try {				
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
			
		
	//-- 3. 로그인( id / pw )  : public int loginCheck(String id, String pw)
		public int loginCheck(String cId, String cPw) {
			int result = FAIL ; // 초기화
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = "SELECT * FROM CUSTOMER WHERE CID= ? AND CPW= ? ";
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, cId);
				pstmt.setString(2, cPw);
				rs = pstmt.executeQuery();
				if (rs.next()) { // 유효한 ID를 입력
					String cPwDB = rs.getString("cpw");
					if(cPwDB.equals(cPw)) { // 매개변수로 들어온 pw와  db에 id로 검색했을때 저장된 pw를 pwDB로 불러와 pwDB와 매개변수pw와 비교해서 같으면 로그인 성공 
						result= SUCCESS;  // 로그인 성공
					}else {
						result= FAIL;
						System.out.println("비밀번호 틀림");
					}
				} else {  // 유요하지 않은 ID
					result = FAIL;
					System.out.println("아이디 틀림");
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
			return result;
		}
	//-- 4. ID로 dto 가져오기 : public MemberDto getMember(String id)
		public CustomerDto getCustomer(String cId) {
			CustomerDto dto = null;
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = "SELECT * FROM CUSTOMER WHERE CID= ? ";
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, cId);
				rs = pstmt.executeQuery();
				if (rs.next()) {				
					String cPw = rs.getString("cpw");
					String cName = rs.getString("cname");
					String cTel = rs.getString("ctel");
					String cEmail = rs.getString("cemail");
					String cAddress = rs.getString("caddress");
					String cGender = rs.getString("cgender");
					Date cBirth = rs.getDate("cbirth");
					Date cRdate = rs.getDate("crdate");
					dto = new CustomerDto(cId, cPw, cName, cTel, cEmail, cAddress, cGender, cBirth, cRdate);
				} else {
					 System.out.println("해당 id로 검색된 사람이 없습니다.");
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
		
	//-- 5. 회원정보 수정 : public int modifyMember(MemberDto dto)
		public int modifyCustomer(CustomerDto dto) {
			int result= FAIL;
			// dto DB에 insert  
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql = "UPDATE CUSTOMER SET CPW=?," + 
					"                                                CNAME=?," + 
					"                                                    CTEL=?," + 
					"                                                        CEMAIL=?," + 
					"                                                            CADDRESS =?," + 
					"                                                                CBIRTH=?," + 
					"                                                                    CGENDER=?" + 
					"                                                                WHERE CID=?";
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);			
				pstmt.setString(1,  dto.getcPw());
				pstmt.setString(2,  dto.getcName());
				pstmt.setString(3,  dto.getcTel());
				pstmt.setString(4,  dto.getcEmail());
				pstmt.setString(5,  dto.getcAddress());
				pstmt.setDate(6,  dto.getcBirth());
				pstmt.setString(7,  dto.getcGender());
				pstmt.setString(8, dto.getcId());
				result = pstmt.executeUpdate();
				System.out.println(result == SUCCESS ? "회원수정성공" : "회원수정실패");			
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("회원수정 실패 : " + dto);
			} finally {
				try {				
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
	

}
