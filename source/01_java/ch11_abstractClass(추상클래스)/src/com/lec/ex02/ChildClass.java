package com.lec.ex02;
// method1(추상메소드), method2 (일반 메소드) 들어옴
public class ChildClass extends SuperClass {

	@Override
	public void method1() {
		System.out.println("ChildClass의 method1 - 추상메소드라서 오버라이드 함.");
		
	}
	@Override
	public void method2() {
		System.out.println("ChildClass의 method2 - 걍 오버라이드 함");
	}
	
	
	
	

}
