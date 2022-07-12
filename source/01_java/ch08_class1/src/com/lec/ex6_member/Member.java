package com.lec.ex6_member;

public class Member {
	private String id;
	private String pw;
	private String name;
	private String email;
	private String address;
	private String birth;
	private String gender;

	public Member() {
	}

	public Member(String id, String pw, String name, String email, String address, String birth, String gender) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
		this.address = address;
		this.birth = birth;
		this.gender = gender;
	}

//	public void infoString() {
//		System.out.println("아이디 : " + id);
//		System.out.println("이름 : " + name);
//		System.out.println("이메일 : " + email);
//		System.out.println("주소 : " + address);
//		System.out.println("생일 : " + birth);
//		System.out.println("성별 : " + gender);
//
//	}
	public String infoString() {
//		return "아이디 : " + id +
//				"이름 : " + name +
//				"이메일 : " +email +
//				"주소 : " + address +
//				"생일 : " + birth;}
		return String.format("아이디 = %s\n이름 = %s\n이메일 = %s\n주소 = %s\n생일 = %s\n성별 = %s", 
				id, name, email, address, birth, gender);
	}

	
	// setter &  getter
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	

}
