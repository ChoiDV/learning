package com.lec.ex05;

// 		     Super
// 	  Child1          Child2
// GrandChild                        // �� �� ����
public class TestMain {

	public static void main(String[] args) {
		Super s = new Super();            // s = Super
		System.out.println(s.s);		  // c1 = Child1
										  // c2 = Child2
										  // gc = GrandChild
		Child1 c1 = new Child1();
		System.out.println("c1.s = " + c1.s + "c1.c1 = " + c1.c1);
		Child2 c2 = new Child2();
		System.out.println("c2.s = " + c2.s + "c2.c2 = " + c2.c2);
// 		System.out.println("c2.c1 = " + c2.c1);  //  ���� ���̶� �Ұ���
		GrandChild gc = new GrandChild(100);
		System.out.println("gc.s = " + gc.s + " gc.c1 = " + gc.c1 + " gc.gc = " + gc.gc);
		// gc�� Super�� ��ӹ��� Child1 �� ��ӹ޾ұ� ������ Super�� Child1 �� �Ѵ� ��밡��.

	}

}
