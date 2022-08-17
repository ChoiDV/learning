package com.lec.ex05;

public class GrandChild extends Child1 {
	int gc;
	
	public GrandChild() {
		System.out.println("GrandChild 형 객체 생성");
	}

	public GrandChild(int gc) {	
		System.out.println("매개 변수 있는 GrandChild 형 객체 생성");
		this.gc = gc;
	}
	
}
