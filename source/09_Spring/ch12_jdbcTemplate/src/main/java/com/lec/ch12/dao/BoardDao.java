package com.lec.ch12.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.lec.ch12.dto.BoardDto;
import com.lec.ch12.util.Constant;
public class BoardDao {
	public static final int FAIL = 0;
	public static final int SUCCESS = 1;
	public JdbcTemplate template;
	private static BoardDao instance = new BoardDao();
	public static BoardDao getInstance() {
		return instance;
	}
	private BoardDao() {
		template = Constant.template;
	}
	
	// 글 목록
	public ArrayList<BoardDto> boardList(){
		String sql="SELECT * FROM MVC_BOARD ORDER BY BGROUP DESC, BSTEP";
		return (ArrayList<BoardDto>) template.query(sql, new BeanPropertyRowMapper<BoardDto>(BoardDto.class));
		       											 // 첫번째 매개변수에 sql을 담고, 두번째 매개변수에 어떤 리턴타입이 담길건지 적어준다.
	}
	// 글목록
	public ArrayList<BoardDto> boardList(final int startRow, final int endRow){
		String sql = "SELECT * FROM (SELECT ROWNUM RN, A.* " + 
				"           FROM (SELECT * FROM MVC_BOARD ORDER BY BGROUP DESC, BSTEP) A)" + 
				"    WHERE RN BETWEEN ? AND ?";
		return (ArrayList<BoardDto>) template.query(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setInt(1, startRow);
				pstmt.setInt(2, endRow);
				// 이때 이것을 사용하려면 boardList에서 매개변수로 들어온 변수들이 final 변수여야한다
				// 실행할때 변경되면 안되기 때문에 final 상수 변수를 사용해야한다.
			}
		}, new BeanPropertyRowMapper<BoardDto>(BoardDto.class));	
	}
	// 글 개수
	public int getBoardTotCnt() {
		String sql = "SELECT COUNT(*) FROM MVC_BOARD";
		return template.queryForObject(sql, Integer.class);
		//  queryForObject는 한줄만 입력받을때 사용 
	}
	//원글쓰기
	public int write(final BoardDto bDto) {
		String sql = "INSERT INTO MVC_BOARD "
				+ "(bID, bNAME, bTITLE, bCONTENT, bGROUP, bSTEP, bINDENT, bIP)" + 
				"    VALUES (MVC_BOARD_SEQ.NEXTVAL, ?, ?, ?, " + 
				"            MVC_BOARD_SEQ.CURRVAL, 0,0, ?)";
		return template.update(sql,new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, bDto.getBname());
				pstmt.setString(2, bDto.getBtitle());
				pstmt.setString(3, bDto.getBcontent());
				pstmt.setString(4, bDto.getBip());
			}
		});	
	}
	// hit수 올리기
	private void hitUp(int bid) {
		String sql = "UPDATE MVC_BOARD SET BHIT = BHIT+1 WHERE BID="+bid;
		template.update(sql);
	}
	
	// 글 상세보기(글 상세볼 때 조회수도 올림)
	public BoardDto contentView(int bid) {
		hitUp(bid);
		String sql = "SELECT * FROM MVC_BOARD WHERE BID="+bid;
		return template.queryForObject(sql, new BeanPropertyRowMapper<BoardDto>(BoardDto.class));
	}
	// bid로 dto 가져오기 (답글쓰기 + 수정)
	public BoardDto modifyView_replyView(int bid) {
		String sql = "SELECT * FROM MVC_BOARD WHERE BID="+bid;
		return template.queryForObject(sql, new BeanPropertyRowMapper<BoardDto>(BoardDto.class));
	}
	// 글 수정하기
	public int modify(final BoardDto bDto) {
		String sql = "UPDATE MVC_BOARD SET BNAME=?, " + 
				"                    BTITLE = ?, " + 
				"                    BCONTENT = ?, " + 
				"                    BIP = ?" + 
				"        WHERE BID=?";
		return template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, bDto.getBname());
				pstmt.setString(2, bDto.getBtitle());
				pstmt.setString(3, bDto.getBcontent());
				pstmt.setString(4, bDto.getBip());
				pstmt.setInt(5, bDto.getBid());
			}
		});
		
	}
	// 글 삭제
	public int delete(int bid) {
		String sql = "DELETE FROM MVC_BOARD WHERE BID="+bid;
		return template.update(sql);		
	}
	// 답변글 쓰기 전 작업 : stepA
	private void preReplyStepA(final int bgroup, final int bstep) {
		String sql = "UPDATE MVC_BOARD SET BSTEP = BSTEP+1 WHERE BGROUP=? AND BSTEP>?";
		template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setInt(1, bgroup);
				pstmt.setInt(2, bstep);
			}
		});		
	}
	// 답변글 쓰기
	public int reply(final BoardDto bDto) { 
		preReplyStepA(bDto.getBgroup(), bDto.getBstep());
		String sql = "INSERT INTO MVC_BOARD" + 
				" (BID, BNAME, BTITLE, BCONTENT, BGROUP, BSTEP, BINDENT, BIP) " + 
				"    VALUES (MVC_BOARD_SEQ.NEXTVAL, ?,?,?, ?, ?, ?, ?)";
		return template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, bDto.getBname());
				pstmt.setString(2, bDto.getBtitle());
				pstmt.setString(3, bDto.getBcontent());
				pstmt.setInt(4, bDto.getBgroup());
				pstmt.setInt(5, bDto.getBstep()+1);
				pstmt.setInt(6, bDto.getBindent()+1);
				pstmt.setString(7, bDto.getBip());
				
			}
		});
	}
}