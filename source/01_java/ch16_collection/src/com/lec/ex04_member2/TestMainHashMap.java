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
			System.out.print("등록을 하시려면 Y | 종료 하시려면 X 를 누르세요 : ");
			answer = sc.next();
			if (answer.equalsIgnoreCase("x")) {
				System.out.println("종료되었습니다.");
				break;
			} else if (answer.equalsIgnoreCase("y")) {
				System.out.print("이름을 입력하세요 : ");
				name = sc.next();
				System.out.print("번호를 입력하세요 : ");
				tel = sc.next();
				if (members.get(tel) != null) {
					System.out.println("이미 가입한 전화번호가 있습니다.");
					continue;
				}
				System.out.print("주소를 입력하세요 : ");
				sc.nextLine();
				address = sc.nextLine();
				members.put(tel, new Member(name, tel, address));
			}
		} while (true);	
		
		if (members.isEmpty()) {
			System.out.println("가입한 사람이 없습니다.");
		} else {
			System.out.println("가입한 회원 명단");
			Iterator<String> iterator = members.keySet().iterator();		
			while (iterator.hasNext()) {
				String key = iterator.next();
				System.out.println(key + " 의 정보는 : " + members.get(key));
			}
		}
	}
}
