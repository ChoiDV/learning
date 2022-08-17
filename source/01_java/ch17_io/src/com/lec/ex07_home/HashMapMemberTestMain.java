package com.lec.ex07_home;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class HashMapMemberTestMain {

	public static void main(String[] args) {
		HashMap<String, Member> members = new HashMap<String, Member>();
		Scanner sc = new Scanner(System.in);
		OutputStream os = null;
		String answer, name, tel, address;
		String line = "\n";
		int year, month, day;
		Date birth;
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd-HH시-mm분");

		try {
			os = new FileOutputStream("homeFile/hashmap.txt", true);
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
					members.put(name, (new Member(name, tel, birth, address)));
				}
			} while (true);
			sc.close();
			if (members.isEmpty()) {
				System.out.println("가입한 사람이 없습니다.");
			} else {
				Iterator<String> iterator = members.keySet().iterator();
				while (iterator.hasNext()) {
					String key = iterator.next();
					os.write(members.get(key).toString().getBytes());
					os.write(line.getBytes());
					String b = sdf.format(members.get(key).getBirthday());
					if(b.equals(sdf.format(now))) {
						System.out.println(key+" 님의 정보 : "+members.get(key)+" 생일 축하합니다.");
					} else {
						System.out.println(key+" 님의 정보 : "+members.get(key));
					}					
				}
				String msg = sdf2.format(now)+" 가입 \t\t...이하 "+members.size()+" 명 가입"; 
				os.write(msg.getBytes());
				os.write(line.getBytes());
				System.out.println(sdf2.format(now)+" 가입 \t\t...이하 "+members.size()+" 명 가입");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("string 내보내기 오류");
		} finally {
			try {
				if (os != null) {
					os.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
