package com.lec.ex04_member;

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

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	
	
}
