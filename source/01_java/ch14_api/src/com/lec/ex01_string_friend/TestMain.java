package com.lec.ex01_string_friend;

import java.util.Scanner;

public class TestMain {

	public static void main(String[] args) {

		Friend[] friends = { new Friend("홍길동", "010-9999-9999", "05-22"),
							 new Friend("신길동", "010-8888-8888", "09-22"),
							 new Friend("마길동", "010-8888-9999", "08-22"), 
							 new Friend("윤길동", "010-7777-7777", "04-22"),
							 new Friend("김길동", "010-6666-7777", "03-22") };
		boolean searchOk = false;
		Scanner sc = new Scanner(System.in);
		String searchTel;
		do {
			System.out.print("전화번호 뒷자리를 입력하세요 (종료하시려면 x를 입력하세요) : ");
			searchTel = sc.next();
			if (searchTel.equalsIgnoreCase("x")) {
				break;
			}
			for (int idx = 0; idx < friends.length; idx++) {
				String tel = friends[idx].getPhone();
				String post = tel.substring(tel.lastIndexOf('-') + 1);
				if (post.equals(searchTel)) {
					System.out.println(friends[idx].toString());
					searchOk = true;
				} // if
			} // for
			if (!searchOk) {
				System.out.println("존재하지 않는 친구입니다.");
			}
		} while (!searchTel.equalsIgnoreCase("x"));
		System.out.println("종료 되었습니다.");
		sc.close();

	}
}
