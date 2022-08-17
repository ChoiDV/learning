package com.lec.ex04_member;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

// 없는 키값으로 get하면 null이 나옴
public class TeacherTestMainHash {
	public static void main(String[] args) {
		HashMap<String, Member> members = new HashMap<String, Member>();
		Scanner sc = new Scanner(System.in);
		String answer, name, tel, address;

		do {
			System.out.print("회원가입 진행하시겠습니까 (Y/N) : ");
			answer = sc.next();
			if (answer.equalsIgnoreCase("n")) {
				System.out.println("종료되었습니다.");
				break;
			} else if (answer.equalsIgnoreCase("y")) {
				System.out.print("이름을 입력하세요 : ");
				name = sc.next();
				System.out.print("번호를 입력하세요 : ");
				tel = sc.next();
				// 키값 중복확인하는 방법
				if (members.get(tel) != null) { // members의 tel의 키값을 불러와서 그게 null이 아니면 키값에 이미 tel키 값이 있다는 소리니까
					// 안내문구 출력하고 continue 해서 다시 do의 시작으로 
					System.out.println("이미 가입되어 있는 전화번호입니다. 전화번호는 중복될 수 없습니다.");
					continue;
				}
				// 기존에 가입한 전화번호인지 확인하는방법2
//				Iterator<String> iterator = members.keySet().iterator();
//				boolean telChk = false;

				System.out.print("주소를 입력하세요 : ");
				sc.nextLine();
				address = sc.nextLine();
				members.put(tel, new Member(name, tel, address));
			}

		} while (true);
		sc.close();
		if(members.isEmpty()) {
			System.out.println("가입한 회원이 없습니다.");
		} else {
			System.out.println("가입한 회원 리스트 목록");
			Iterator<String> iterator = members.keySet().iterator();
			while(iterator.hasNext()) {
				String key = iterator.next();
				System.out.println(key + " 의 정보는 : "+ members.get(key));
			}
		}
	}
}
