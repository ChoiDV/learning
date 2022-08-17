package com.lec.ex03_access;

public class AccessMainTest {
	
	public static void main(String[] args) {
		AccessTest obj = new AccessTest();
		// System.out.println(obj.privateMember()); 는 private 라 안보임
		System.out.println(obj.defaultMember);
		System.out.println(obj.protectedMember);
		System.out.println(obj.publicMember);
		
		// obj.privateMethod();
		obj.defaultMethod();
		obj.protectedMethod();
		obj.publicMethod();
	}

}
