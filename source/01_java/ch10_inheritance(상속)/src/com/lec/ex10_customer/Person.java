package com.lec.ex10_customer;

public class Person {
	private String name;
	private String tel;  // Person p = new Person("이름","전화번호");
	
	public Person(String name, String tel) {
		this.name = name;
		this.tel = tel;
	}
	public String infoString() {
		return " [이름] " +name + " [전화 번호] "+tel;
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
