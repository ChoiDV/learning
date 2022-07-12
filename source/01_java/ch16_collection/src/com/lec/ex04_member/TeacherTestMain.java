package com.lec.ex04_member;

import java.util.ArrayList;
import java.util.Scanner;

public class TeacherTestMain {
	public static void main(String[] args) {
		ArrayList<Member> members = new ArrayList<Member>();
		Scanner sc = new Scanner(System.in);
		String answer, name, phone, address;
		do {
			System.out.print("회원가입 진행하시겠습니까 (Y/N) : ");
			answer = sc.next();
			if (answer.equalsIgnoreCase("n")) {
				System.out.println("종료되었습니다.");
				break;
			} else if (answer.equalsIgnoreCase("y")) {
//				Member member = new Member();
//				System.out.print("이름을 입력하세요 : ");
//				member.setName(sc.next());
//				System.out.print("번호를 입력하세요 : ");
//				member.setTel(sc.next());
//				System.out.print("주소를 입력하세요 : ");
//				sc.nextLine();
//				member.setAddress(sc.nextLine());
//				members.add(member);
				
				System.out.print("이름을 입력하세요 : ");
				 name = sc.next();
				System.out.print("번호를 입력하세요 : ");
				 phone = sc.next();
				System.out.print("주소를 입력하세요 : ");
				sc.nextLine();
				 address = sc.nextLine();
				members.add(new Member(name,phone,address));				
			}
		} while (true);
		sc.close();
		if (members.isEmpty()) {
			System.out.println("가입한 회원이 없습니다.");
		} else {
			System.out.println("가입한 회원 리스트 목록");
			for (Member m : members) {
				System.out.println(m);
			}
		}

	}
}
