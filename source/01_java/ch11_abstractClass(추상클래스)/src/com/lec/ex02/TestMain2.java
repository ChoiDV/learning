package com.lec.ex02;

public class TestMain2 {

	public static void main(String[] args) {
//		SuperClass s = new SuperClass(); �߻�Ŭ������ �̿��� ��ü ���� �Ұ�
//		ChildClass2 c = new ChildClass2(); �굵 �Ұ�����.
		GrandChild g = new GrandChild();
		ChildClass2 gg = new GrandChild();
		
		g.method1();
		g.method2();
		
	}

}
