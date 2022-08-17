package com.lec.ex13_Person;

public class Person {
	private String no; // ��ȣ st10 , staff , lec   no+ (+1) ���ٰ�
	private String id; // ���̵� : A01,A02 , S01,S02 , G01 , G02 ��� �Է¹���
	private String name; // �̸� �Է¹�����

	public Person() {
	}

	public Person(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public void print() {
		System.out.print("(��ȣ) " + no + "\t(ID)" + id + "\t(�̸�):" + name);
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
