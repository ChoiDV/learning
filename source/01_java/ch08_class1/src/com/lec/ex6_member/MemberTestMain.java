package com.lec.ex6_member;

public class MemberTestMain {
//String id, String pw, String name, String email, String address, String birth, String gender
	public static void main(String[] args) {
		Member member = new Member("chlwlsdud","wlsdud12","최진영",
										"chlwlsdud69@naver.com","수원시 권선구","1999.12.03","남");
		 //member.infoString();

		System.out.println(member.infoString());
	}

}
