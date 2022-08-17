package com.lec.ex03_access;

public class AccessTest {
	private int privateMember;      // �����̺� : ���� Ŭ������������ ��밡��
	int defaultMember; 				// ����Ʈ : ���� ��Ű�������� ��밡��
	protected int protectedMember;  // ������Ƽ�� : ���� ��Ű���� ��ӹ��� ����Ŭ���������� ��밡��
	public int publicMember; 		// �ۺ� : �ƹ������� ��밡��
	
	private void privateMethod() {
		System.out.println("private �޼ҵ� ");
	}
	void defaultMethod() {
		System.out.println("default �޼ҵ�");
	}
	protected void protectedMethod() {
		System.out.println("protected �޼ҵ�");
	}
	public void publicMethod() {
		System.out.println("public �޼ҵ�");
	}
	
}
