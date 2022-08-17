package com.lec.ex13_Person;

public class Gangsa extends Person {
	private String subject;
	private static int cntGangsa;
	
	public Gangsa(String id, String name, String subject) {
		super(id, name);
		this.subject = subject;
		++cntGangsa;
		setNo("lec"+cntGangsa);
	}

	@Override
	public void print() {
		super.print();
		System.out.println("\t(°ú¸ñ) "+subject);
	}
}
