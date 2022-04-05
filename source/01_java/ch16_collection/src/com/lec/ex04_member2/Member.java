package com.lec.ex04_member2;

public class Member {
	private String name;
	private String tel;
	private String address;
	
	public Member() {
	}
	
	public Member(String name, String tel, String address) {
		this.name = name;
		this.tel = tel;
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "이름 : "+name+"  전화번호 : "+tel+"  주소 : "+address;
	}
	
	
	
	
	
}
