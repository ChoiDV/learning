package com.lec.ex01;

public class TestMain {

	public static void main(String[] args) {
//		InterfaceEx2 ex1 = new InterfaceEx2();  인터페이스 객체 생성 불가
		InterfaceClass obj1 = new InterfaceClass();
		obj1.method1();
		obj1.method2();
		// 객체 변수로 static access 비추
		System.out.println(obj1.CONSTANT_NUM);
		System.out.println(obj1.CONSTANT_STRING);

		// 이런 방식으로 static access 추천
		System.out.println(InterfaceEx1.CONSTANT_NUM);
		System.out.println(InterfaceEx2.CONSTANT_STRING);

		InterfaceEx1 obj2 = new InterfaceClass(); // 이렇게도 가능
		obj2.method1();

		if (obj2 instanceof InterfaceClass) { // 형변환
			((InterfaceClass) obj2).method2();
		}
//		System.out.println(obj2.CONSTANT_NUM);
		
		InterfaceEx2 obj3 = new InterfaceClass();
//		obj3.method1();
		obj3.method2();
		
	}

}
