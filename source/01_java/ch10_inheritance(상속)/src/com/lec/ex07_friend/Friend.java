package com.lec.ex07_friend;
// this.   : �� ��ü�� .~~~ 
// this()  : �� Ŭ������ ������ �Լ� 
public class Friend {
	private String name;
	private String tel;  // ��ȭ��ȣ ������ int �� �ϸ� 01044349878 �ϸ� �Ǿ��� 0�� �����.
	
	public Friend() {
		System.out.println("�Ű� ���� ���� ������ �Լ�");
	}
	public Friend(String name) {
		this(); // �̰Ŵ� �Ű����� ���� Friend() �����ڸ� ����
		this.name = name;
		System.out.println("�Ű� ���� �ϳ�¥�� ������ �Լ�");
	}
	public Friend(String name, String tel) {
		this(name);   // Friend(name)�� ȣ��    // �Ű����� name �ϳ�¥�� �����ڸ� ����
		this.tel = tel;			
		System.out.println("�Ű� ���� �ΰ�¥�� ������ �Լ�");
	}
	public String infoString() {
		return "[�̸�]" + name + " [��ȭ] " + tel;
	}
	
	

}
