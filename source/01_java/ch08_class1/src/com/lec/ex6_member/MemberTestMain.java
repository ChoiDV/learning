package com.lec.ex6_member;

public class MemberTestMain {
//String id, String pw, String name, String email, String address, String birth, String gender
	public static void main(String[] args) {
		Member member = new Member("chlwlsdud","wlsdud12","������",
										"chlwlsdud69@naver.com","������ �Ǽ���","1999.12.03","��");
		 //member.infoString();

		System.out.println(member.infoString());
	}

}
