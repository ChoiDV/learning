package com.lec.ex13_Person;

public class Person {
	private String no; // 번호 st10 , staff , lec   no+ (+1) 해줄거
	private String id; // 아이디 : A01,A02 , S01,S02 , G01 , G02 등등 입력받음
	private String name; // 이름 입력받을거

	public Person() {
	}

	public Person(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public void print() {
		System.out.print("(번호) " + no + "\t(ID)" + id + "\t(이름):" + name);
	}


	// setter & getter

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
