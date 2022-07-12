package com.lec.ex13_Person;

public class Staff extends Person {
	private static int cntStaff;
	private String department;

	public Staff(String id, String name, String department) {
		super(id, name);
		this.department = department;
		++cntStaff;
		setNo("staff" + cntStaff);
	}

	@Override
	public void print() {
		super.print();
		System.out.println("\t(ºÎ¼­)" + department);
	}

}
