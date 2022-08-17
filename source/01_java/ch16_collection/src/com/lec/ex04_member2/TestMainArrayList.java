package com.lec.ex04_member2;

import java.util.ArrayList;
import java.util.Scanner;

public class TestMainArrayList {
	public static void main(String[] args) {
		ArrayList<Member> members = new ArrayList<Member>();
		Scanner sc = new Scanner(System.in);
		String answer, name, tel, address;
		
		do {
			System.out.print("등록을 하시려면 Y | 종료 하시려면 X 를 누르세요 : ");
			answer = sc.next();
			if(answer.equalsIgnoreCase("x")) {
				System.out.println("종료되었습니다.");
				break;
			} else if(answer.equalsIgnoreCase("y")) {
				System.out.print("이름을 입력하세요 : ");
				name = sc.next();
				System.out.print("번호를 입력하세요 : ");
				tel = sc.next();
				System.out.print("주소를 입력하세요 : ");
				sc.nextLine();
				address = sc.nextLine();
				members.add(new Member(name,tel,address));
			}					
		}while(true);
		
		if( members.isEmpty()) {
			System.out.println("가입한 사람이 없습니다.");
		} else {
			System.out.println("회원 명단");
			for(Member m : members) {
				System.out.println(m);
			}
		}
		
	}
}
