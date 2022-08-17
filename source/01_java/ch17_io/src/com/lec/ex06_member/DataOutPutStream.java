package com.lec.ex06_member;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;

public class DataOutPutStream {

	public static void main(String[] args) {
		ArrayList<Member> members = new ArrayList<Member>();
		Scanner sc = new Scanner(System.in);
		OutputStream os = null;
		DataOutputStream dos = null;
		String answer, name, tel, address;
		String line = "\n";
		int year, month, day;
		Date birth;
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd-HH-mm");
		try {
			os = new FileOutputStream("memberFile/memberFile4.txt", true);
			dos = new DataOutputStream(os);
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
					System.out.print("생년월일을 입력하세요 (yyyy-MM-dd) : ");
					StringTokenizer tokenizer = new StringTokenizer(sc.next(), "-");
					year = (Integer.parseInt(tokenizer.nextToken()) - 1900);
					month = (Integer.parseInt(tokenizer.nextToken()) - 1);
					day = Integer.parseInt(tokenizer.nextToken());
					birth = new Date(year, month, day);
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
					dos.writeUTF(members.get(i).toString());
					dos.writeUTF(line);
					String b = sdf.format(members.get(i).getBirthday());
					if (b.equals(sdf.format(now))) {
						System.out.println(members.get(i) + "\t생일축하합니다.");
					} else {
						System.out.println(members.get(i));
					}
				}
				String msg = sdf2.format(now) + " 가입 \t\t...이하 " + members.size() + " 명 가입";
				System.out.println("\t\t...이하 " + members.size() + " 명 가입");
				dos.writeUTF(msg);
				dos.writeUTF(line);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (dos != null) {
					dos.close();
				}
				if (os != null) {
					os.close();
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}

		}

	}

}
		

