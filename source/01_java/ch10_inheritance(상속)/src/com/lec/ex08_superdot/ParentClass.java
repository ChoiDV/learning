package com.lec.ex08_superdot;

// super.     : 내 부모단의
// super()	  : 내 부모단의 생성자 함수  - 많이 쓰임.
public class ParentClass {
	private int i = 20;

	public ParentClass() {
		System.out.println("ParentClass 생성자");
	}

	public void method() {
		System.out.println("ParentClass의 method super단의 i 는 " + i);
		
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}
	

}
