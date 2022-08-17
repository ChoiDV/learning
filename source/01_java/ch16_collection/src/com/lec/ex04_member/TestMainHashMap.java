package com.lec.ex04_member;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class TestMainHashMap {
	public static void main(String[] args) {
		HashMap<String,Member> hashMap = new HashMap<String, Member>();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("����� �Ϸ��� Y | �����Ϸ��� X �� �������� : ");
			String msg = sc.next();
			if(msg.equalsIgnoreCase("x")) {
				System.out.println("����Ǿ����ϴ�.");
				break;
			}
			System.out.print("�̸��� �Է��ϼ��� : ");
			String name = sc.next();
			System.out.print("��ȣ�� �Է��ϼ��� : ");
			String tel = sc.next();
			System.out.print("�ּҸ� �Է��ϼ��� : ");
			sc.nextLine();
			String address = sc.nextLine();
			hashMap.put(tel,new Member(name,tel,address));		
		}
		Iterator<String> iterator = hashMap.keySet().iterator();
		while(iterator.hasNext()) {
			String key = iterator.next();
			System.out.println(key + " �� ������ : "+ hashMap.get(key));
		}
		
	}
}
