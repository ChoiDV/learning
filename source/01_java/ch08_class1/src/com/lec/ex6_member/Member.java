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
//		System.out.println("���̵� : " + id);
//		System.out.println("�̸� : " + name);
//		System.out.println("�̸��� : " + email);
//		System.out.println("�ּ� : " + address);
//		System.out.println("���� : " + birth);
//		System.out.println("���� : " + gender);
//
//	}
	public String infoString() {
//		return "���̵� : " + id +
//				"�̸� : " + name +
//				"�̸��� : " +email +
//				"�ּ� : " + address +
//				"���� : " + birth;}
		return String.format("���̵� = %s\n�̸� = %s\n�̸��� = %s\n�ּ� = %s\n���� = %s\n���� = %s", 
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
