package com.lec.ex04_member2;

import java.util.ArrayList;
import java.util.Scanner;

public class TestMainArrayList {
	public static void main(String[] args) {
		ArrayList<Member> members = new ArrayList<Member>();
		Scanner sc = new Scanner(System.in);
		String answer, name, tel, address;
		
		do {
			System.out.print("����� �Ͻ÷��� Y | ���� �Ͻ÷��� X �� �������� : ");
			answer = sc.next();
			if(answer.equalsIgnoreCase("x")) {
				System.out.println("����Ǿ����ϴ�.");
				break;
			} else if(answer.equalsIgnoreCase("y")) {
				System.out.print("�̸��� �Է��ϼ��� : ");
				name = sc.next();
				System.out.print("��ȣ�� �Է��ϼ��� : ");
				tel = sc.next();
				System.out.print("�ּҸ� �Է��ϼ��� : ");
				sc.nextLine();
				address = sc.nextLine();
				members.add(new Member(name,tel,address));
			}					
		}while(true);
		
		if( members.isEmpty()) {
			System.out.println("������ ����� �����ϴ�.");
		} else {
			System.out.println("ȸ�� ���");
			for(Member m : members) {
				System.out.println(m);
			}
		}
		
	}
}
