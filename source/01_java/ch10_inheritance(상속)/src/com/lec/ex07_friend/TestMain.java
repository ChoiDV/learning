package com.lec.ex07_friend;

public class TestMain {

	public static void main(String[] args) {
		Friend f1 = new Friend();
		System.out.println(f1.infoString());
		System.out.println("-----------------------\n");
		
		Friend f2 = new Friend("������");
		System.out.println(f2.infoString());
		
		System.out.println("-----------------------\n");
		
		Friend f3 = new Friend("��������","010-4434-9878");
		System.out.println(f3.infoString());
		

	}

}
