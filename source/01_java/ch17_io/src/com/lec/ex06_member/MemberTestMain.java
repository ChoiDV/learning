package com.lec.ex06_member;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MemberTestMain {

	public static void main(String[] args) {
		ArrayList<Member> members = new ArrayList<Member>();
		Scanner sc = new Scanner(System.in);
		OutputStream os = null;
		Writer writer = null;
		String answer, name, tel, address;
		int y, m, d;
		Date birth = null;
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		try {
			os = new FileOutputStream("memberFile/member.txt", true);
//			writer = new FileWriter("memberFile/member.txt", true);      //  writer 사용시
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
					y = (Integer.parseInt(tokenizer.nextToken()) - 1900);
					m = (Integer.parseInt(tokenizer.nextToken()) - 1);
					d = Integer.parseInt(tokenizer.nextToken());
					birth = new Date(y, m, d);
//					System.out.print("태어난 연도를 입력하세요 : ");
//					int year = ((sc.nextInt()) - 1900);
//					System.out.print("생일의 월 을 입력하세요 (MM): ");
//					int month = (sc.nextInt() - 1);
//					System.out.print("생일의 일 을 입력하세요 (dd): ");
//					int day = (sc.nextInt());
//					birth = new Date(year, month, day);
					System.out.print("주소를 입력하세요 : ");
					sc.nextLine();
					address = sc.nextLine();
					members.add(new Member(name, tel, birth, address));
//					int a =Integer.parseInt(members.toString());		

				}
			} while (true);
			sc.close();
//			if (members.isEmpty()) {
//				System.out.println("가입한 사람이 없습니다.");
//			} else {
//				for (int i = 0; i < members.size(); i++) {                   ***  // writer 사용시 ****
//					writer.write(members.get(i).toString());
//					String line = "\n";
//					write.write(line);
//				String d = sdf.format(members.get(i).getBirthday());
//				if (d.equals(sdf.format(new Date()))) {
//					System.out.println(members.get(i) + "   생일 축하합니다.");
//				} else {
//					System.out.println(members.get(i));
//				}
//					
//				}
//				System.out.println("... 이하 " + members.size() + " 명 가입");
//			}

			if (members.isEmpty()) {
				System.out.println("가입한 사람이 없습니다.");
			} else {
				String msg = "\t\t... 이하 " + members.size() + " 명 가입";
				String line = "\n";
				for (int i = 0; i < members.size(); i++) {
					os.write(members.get(i).toString().getBytes());
					os.write(line.getBytes());
					String x = sdf.format(members.get(i).getBirthday());
					if (x.equals(sdf.format(now))) {
						System.out.println(members.get(i) + "   생일 축하합니다.");
					} else {
						System.out.println(members.get(i));
					}
				}
				os.write(msg.getBytes());
				os.write(line.getBytes());
				System.out.println("\t\t... 이하 " + members.size() + " 명 가입");

			}

		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (os != null) {
					os.close();
				}
//				if (writer != null) {       *******writer 사용시 ***********
//					writer.close();
//				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			} catch (NumberFormatException e) {
				System.out.println(e.getMessage());
			}

		}
//		for (Member member : members) {
//			try {
//				os.write(Integer.parseInt(member.toString()));
//			} catch (NumberFormatException | IOException e) {
//				System.out.println(e.getMessage());
//			}
//		}

	}

}
