package com.lec.ex10_customer;

public class Person {
	private String name;
	private String tel;  // Person p = new Person("�̸�","��ȭ��ȣ");
	
	public Person(String name, String tel) {
		this.name = name;
		this.tel = tel;
	}
	public String infoString() {
		return " [�̸�] " +name + " [��ȭ ��ȣ] "+tel;
	}
	
	// setter&getter
	
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
	
}
