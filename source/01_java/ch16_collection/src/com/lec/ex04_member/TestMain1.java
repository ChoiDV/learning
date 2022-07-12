package com.lec.ex04_member;

import java.util.ArrayList;
import java.util.Scanner;

public class TestMain1 {

	public static void main(String[] args) {
		ArrayList<Member> member = new ArrayList<Member>();
		Scanner sc = new Scanner(System.in);
		do {
			System.out.print("등록을 하려면 Y | 종료하려면 X를 누르세요 : ");
			String msg = sc.next();
			if(msg.equalsIgnoreCase("x")) {
				System.out.println("종료");
				break;
			}
			System.out.print("이름을 입력하세요 : ");
			String name = sc.next();
			System.out.print("번호를 입력하세요 : ");
			String tel = sc.next();
			System.out.print("주소를 입력하세요 : ");
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
