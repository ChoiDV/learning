package com.lec.ex04_access;

import com.lec.ex03_access.AccessTest;

public class AccessMainTest {

	public static void main(String[] args) {
		//com.lec.ex3_access.AccessTest obj;
		// AccessTest obj = new AccessTest(); �� import com.lec.ex3_access.AccessTest; �Ѱ� �������� ���� ����
		AccessTest obj = new AccessTest();
		//System.out.println(obj.privateMember); private�� ���� Ŭ������ �ƴϿ��� ����Ҽ�����
		//System.out.println(obj.defaultMember); default�� ���� ��Ű���� �ƴϿ��� ����Ҽ�����
		//System.out.println(obj.protectedMember); protected�� ��ӹްų� ������Ű���� �ƴϿ��� ����Ҽ�����
		System.out.println(obj.publicMember);
		
//		obj.privateMethod();
//		obj.defaultMethod();
//		obj.protectedMethod();
		obj.publicMethod();
		
		

	}
	

}
