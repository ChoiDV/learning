package com.lec.ex04_member;

import java.util.ArrayList;
import java.util.Scanner;

public class TeacherTestMain {
	public static void main(String[] args) {
		ArrayList<Member> members = new ArrayList<Member>();
		Scanner sc = new Scanner(System.in);
		String answer, name, phone, address;
		do {
			System.out.print("ȸ������ �����Ͻðڽ��ϱ� (Y/N) : ");
			answer = sc.next();
			if (answer.equalsIgnoreCase("n")) {
				System.out.println("����Ǿ����ϴ�.");
				break;
			} else if (answer.equalsIgnoreCase("y")) {
//				Member member = new Member();
//				System.out.print("�̸��� �Է��ϼ��� : ");
//				member.setName(sc.next());
//				System.out.print("��ȣ�� �Է��ϼ��� : ");
//				member.setTel(sc.next());
//				System.out.print("�ּҸ� �Է��ϼ��� : ");
//				sc.nextLine();
//				member.setAddress(sc.nextLine());
//				members.add(member);
				
				System.out.print("�̸��� �Է��ϼ��� : ");
				 name = sc.next();
				System.out.print("��ȣ�� �Է��ϼ��� : ");
				 phone = sc.next();
				System.out.print("�ּҸ� �Է��ϼ��� : ");
				sc.nextLine();
				 address = sc.nextLine();
				members.add(new Member(name,phone,address));				
			}
		} while (true);
		sc.close();
		if (members.isEmpty()) {
			System.out.println("������ ȸ���� �����ϴ�.");
		} else {
			System.out.println("������ ȸ�� ����Ʈ ���");
			for (Member m : members) {
				System.out.println(m);
			}
		}

	}
}
