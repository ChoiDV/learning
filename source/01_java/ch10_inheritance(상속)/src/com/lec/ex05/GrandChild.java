package com.lec.ex05;

public class GrandChild extends Child1 {
	int gc;
	
	public GrandChild() {
		System.out.println("GrandChild �� ��ü ����");
	}

	public GrandChild(int gc) {	
		System.out.println("�Ű� ���� �ִ� GrandChild �� ��ü ����");
		this.gc = gc;
	}
	
}
