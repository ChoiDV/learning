package com.lec.ex04_member2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class TestMainHashMap {
	public static void main(String[] args) {
		HashMap<String, Member> members = new HashMap<String, Member>();
		Scanner sc = new Scanner(System.in);
		String answer, name, tel, address;

		do {
			System.out.print("����� �Ͻ÷��� Y | ���� �Ͻ÷��� X �� �������� : ");
			answer = sc.next();
			if (answer.equalsIgnoreCase("x")) {
				System.out.println("����Ǿ����ϴ�.");
				break;
			} else if (answer.equalsIgnoreCase("y")) {
				System.out.print("�̸��� �Է��ϼ��� : ");
				name = sc.next();
				System.out.print("��ȣ�� �Է��ϼ��� : ");
				tel = sc.next();
				if (members.get(tel) != null) {
					System.out.println("�̹� ������ ��ȭ��ȣ�� �ֽ��ϴ�.");
					continue;
				}
				System.out.print("�ּҸ� �Է��ϼ��� : ");
				sc.nextLine();
				address = sc.nextLine();
				members.put(tel, new Member(name, tel, address));
			}
		} while (true);	
		
		if (members.isEmpty()) {
			System.out.println("������ ����� �����ϴ�.");
		} else {
			System.out.println("������ ȸ�� ���");
			Iterator<String> iterator = members.keySet().iterator();		
			while (iterator.hasNext()) {
				String key = iterator.next();
				System.out.println(key + " �� ������ : " + members.get(key));
			}
		}
	}
}
