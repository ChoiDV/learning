package com.lec.ex07_home;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MemberTestMainPrintWriter {

	public static void main(String[] args) {
		ArrayList<Member> members = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		PrintWriter writer = null;
		Date birth;
		Date now = new Date();
		String answer, name, tel, address;
		String line = "\n";

		try {
			writer = new PrintWriter("homeFile/memberFile3.txt");
			do {
				System.out.print("회원가입을 하시려면 Y | 종료하시려면 X 를 누르세요 : ");
				answer = sc.next();
				if (answer.equalsIgnoreCase("x")) {
					System.out.println("종료되었습니다.");
					break;
				} else if (answer.equalsIgnoreCase("y")) {
					System.out.print("이름을 입력하세요 : ");
					name = sc.next();
					System.out.print("전화번호를 입력하세요 : ");
					tel = sc.next();
					System.out.print("태어난 연,월,일 을 입력하세요(yyyy-MM-dd) : ");
					String birthday = sc.next();
					StringTokenizer tokenizer = new StringTokenizer(birthday, "-");
					int y = (Integer.parseInt(tokenizer.nextToken()) - 1900);
					int m = (Integer.parseInt(tokenizer.nextToken()) - 1);
					int d = Integer.parseInt(tokenizer.nextToken());
					birth = new Date(y, m, d);
					System.out.print("주소를 입력하세요 : ");
					sc.nextLine();
					address = sc.nextLine();
					members.add(new Member(name, tel, birth, address));
				}
			} while (true);
			sc.close();
			if (members.isEmpty()) {
				System.out.println("가입한 사람이 없습니다.");
			} else {
				for (int i = 0; i < members.size(); i++) {
					writer.println(members.get(i).toString());
					String b = sdf.format(members.get(i).getBirthday());
					if (b.equals(sdf.format(now))) {
						System.out.println(members.get(i) + " 생일 축하합니다.");
					} else {
						System.out.println(members.get(i));
					}
				}
				String msg = "\t\t...이하 " + members.size() + " 명 가입";
				writer.println(msg);
				System.out.println(msg);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				writer.close();
			}
		}

	}

}
