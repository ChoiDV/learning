package com.lec.ex05_employee;

public abstract class Employee {
	private String name;
	
	public Employee(String name) {
		this.name = name;
	}

	public abstract int computePay(); // 월급

	public final int computeIncentive() { // 인센티브
		int pay = computePay();   // int pay에 메소드를 넣는이유는 우리는 못느끼지만 컴퓨터는 computePay()메소드에 
		if (pay > 2000000) {  	// 갔다가 오는것이다. 그래서 메소드안에 메소드를 여러번 넣어야할때는 아싸리 변수에 메소드를 넣어주는것이 효율적.
			return ((int) (pay * 0.5));
		}
			return 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
