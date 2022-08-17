package com.lec.ex03_access;

public class AccessTest {
	private int privateMember;      // 프라이빗 : 같은 클래스내에서만 사용가능
	int defaultMember; 				// 디폴트 : 같은 패키지에서만 사용가능
	protected int protectedMember;  // 프로텍티드 : 같은 패키지나 상속받은 하위클래스에서만 사용가능
	public int publicMember; 		// 퍼블릭 : 아무데서나 사용가능
	
	private void privateMethod() {
		System.out.println("private 메소드 ");
	}
	void defaultMethod() {
		System.out.println("default 메소드");
	}
	protected void protectedMethod() {
		System.out.println("protected 메소드");
	}
	public void publicMethod() {
		System.out.println("public 메소드");
	}
	
}
