package com.lec.ex13_Person;

public class Student extends Person {
	private String ban;
	private static int cntStudent;
	
	public Student() {		
	}
	public Student(String id, String name,String ban) {
		super(id, name);
		this.ban = ban;
		++cntStudent;
		setNo("st10"+cntStudent);		
	}

	@Override
	public void print() {
		super.print();
		System.out.println("\t(¹Ý)"+ban);
	}
	

}
