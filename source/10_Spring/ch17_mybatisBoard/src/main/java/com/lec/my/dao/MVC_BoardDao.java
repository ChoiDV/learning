package com.lec.my.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lec.my.dto.MVC_Board;

@Mapper
public interface MVC_BoardDao {
	// 리스트 출력
	public List<MVC_Board> boardList(MVC_Board board);
	// 글 개수
	public int totCnt();
	// 원글 작성
	public int insertBoard(MVC_Board board);
	// 조회수 올리기
	public int hitup(int bid);
	// 글 상세보기
	public MVC_Board detail(int bid);
	// stepA
	public int stepA(MVC_Board board);
	// 답변글 쓰기
	public int reply(MVC_Board board);
	// 글 수정하기
	public int update(MVC_Board board);
	// 글 삭제하기
	public int delete(int bid);
	
}
