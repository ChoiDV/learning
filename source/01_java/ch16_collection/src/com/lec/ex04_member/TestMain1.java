package com.lec.ex04_member;

import java.util.ArrayList;
import java.util.Scanner;

public class TestMain1 {

	public static void main(String[] args) {
		ArrayList<Member> member = new ArrayList<Member>();
		Scanner sc = new Scanner(System.in);
		do {
			System.out.print("����� �Ϸ��� Y | �����Ϸ��� X�� �������� : ");
			String msg = sc.next();
			if(msg.equalsIgnoreCase("x")) {
				System.out.println("����");
				break;
			}
			System.out.print("�̸��� �Է��ϼ��� : ");
			String name = sc.next();
			System.out.print("��ȣ�� �Է��ϼ��� : ");
			String tel = sc.next();
			System.out.print("�ּҸ� �Է��ϼ��� : ");
			sc.nextLine();
			String address = sc.nextLine();
			member.add(new Member(name,tel,address));			
		}while(true);
//		for(int i =0; i<member.size(); i++) {
//			System.out.println(member.get(i));
//		}
		for(Member m : member) {
			System.out.println(m);
		}
	}

}
