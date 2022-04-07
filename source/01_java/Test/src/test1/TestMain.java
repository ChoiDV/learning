package test1;

import java.util.Date;
import java.util.Scanner;

public class TestMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Friend[] friends = { new Friend("홍길동", "010-9999-1234", "서울시 용산구", new Date(99, 4, 22)),
				new Friend("유길동", "010-8888-1134", "용인시 기흥구", new Date(99, 6, 7)),
				new Friend("박길동", "010-8888-1334", "용인시 처인구", new Date(99, 6, 7)) };
		String answer, searchaddress, searchphone;

		while (true) {
			System.out.print("검색할 주소 앞 글자 2자리(단, 종료를 원하시면 x를 입력하시오 : ");
			answer = sc.next();
			boolean ok = false;
			if (answer.equalsIgnoreCase("x")) {
				System.out.println("종료되었습니다.");
				break;
			}
			for (int i = 0; i < friends.length; i++) {
				searchaddress = friends[i].getAddress().substring(0, 2);
				if (answer.equals(searchaddress)) {
					System.out.println("찾으시는 분은 : " + friends[i]);
					ok = true;
				}
			}
			if (!ok) {
				System.out.println("찾으시는 사람은 없습니다.\n");
			}

		}

	}
}
