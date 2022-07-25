package com.lec.ch19.service;

import javax.servlet.http.HttpSession;

import com.lec.ch19.dto.Member;

public interface MemberService {
	// 아이디 중복 체크
	public int idConfirm(String mid);
	
	// 회원가입
	public int joinMember(Member member, HttpSession httpSession);
	
	// 로그인
	public String loginCheck(String mid, String mpw, HttpSession httpSession);  // 메세지로 리턴 할거라서 리턴타입 String
	
	// id로 dto가져오기
	public Member getDetailMember(String mid);
	
	// 회원정보 수정하기
	public int modifyMember(Member member);
}  
