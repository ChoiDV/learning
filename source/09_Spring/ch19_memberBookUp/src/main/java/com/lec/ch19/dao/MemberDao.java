package com.lec.ch19.dao;

import org.apache.ibatis.annotations.Mapper;

import com.lec.ch19.dto.Member;

@Mapper
public interface MemberDao {
	// 아이디 중복체크 
	public int idConfirm(String mid);
	
	// 회원가입
	public int joinMember(Member member);
	
	// id로 dto가져오기
	public Member getDetailMember(String mid);
	
	// 회원 정보 수정하기
	public int modifyMember(Member member);
}
