package com.lec.ex01;

public class TestMain {

	public static void main(String[] args) {
//		InterfaceEx2 ex1 = new InterfaceEx2();  �������̽� ��ü ���� �Ұ�
		InterfaceClass obj1 = new InterfaceClass();
		obj1.method1();
		obj1.method2();
		// ��ü ������ static access ����
		System.out.println(obj1.CONSTANT_NUM);
		System.out.println(obj1.CONSTANT_STRING);

		// �̷� ������� static access ��õ
		System.out.println(InterfaceEx1.CONSTANT_NUM);
		System.out.println(InterfaceEx2.CONSTANT_STRING);

		InterfaceEx1 obj2 = new InterfaceClass(); // �̷��Ե� ����
		obj2.method1();

		if (obj2 instanceof InterfaceClass) { // ����ȯ
			((InterfaceClass) obj2).method2();
		}
//		System.out.println(obj2.CONSTANT_NUM);
		
		InterfaceEx2 obj3 = new InterfaceClass();
//		obj3.method1();
		obj3.method2();
		
	}

}
