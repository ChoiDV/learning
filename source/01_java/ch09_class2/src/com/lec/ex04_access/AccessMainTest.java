package com.lec.ex04_access;

import com.lec.ex03_access.AccessTest;

public class AccessMainTest {

	public static void main(String[] args) {
		//com.lec.ex3_access.AccessTest obj;
		// AccessTest obj = new AccessTest(); 와 import com.lec.ex3_access.AccessTest; 한게 위에꺼랑 같은 뜻임
		AccessTest obj = new AccessTest();
		//System.out.println(obj.privateMember); private라 같은 클래스가 아니여서 사용할수없음
		//System.out.println(obj.defaultMember); default라 같은 패키지가 아니여서 사용할수없음
		//System.out.println(obj.protectedMember); protected라 상속받거나 같은패키지가 아니여서 사용할수없음
		System.out.println(obj.publicMember);
		
//		obj.privateMethod();
//		obj.defaultMethod();
//		obj.protectedMethod();
		obj.publicMethod();
		
		

	}
	

}
