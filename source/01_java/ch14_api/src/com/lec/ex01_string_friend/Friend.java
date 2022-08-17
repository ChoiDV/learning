package com.lec.ex01_string_friend;

public class Friend {
	private String name;
	private String phone;
	private String birthday;
	
	public Friend() {	
	}
	
	public Friend(String name, String phone, String birthday) {
		this.name = name;
		this.phone = phone;
		this.birthday = birthday;		
	}
	
	@Override
	public String toString() {
		return "이름 : "+name+", 전화번호 :" + phone + ", 생일 : "+ birthday;
	}

	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

	public String getBirthday() {
		return birthday;
	}
	
	
	
}
