package com.lec.ex02;

public class TestMain {

	public static void main(String[] args) {
		SuperClass obj = new ChildClass();
		{
			obj.method1();
			obj.method2();
		}
//			@Override
//			public void method1() {
//				System.out.println("익명클래스 생성");
//
//			}
//		};

	}

}
