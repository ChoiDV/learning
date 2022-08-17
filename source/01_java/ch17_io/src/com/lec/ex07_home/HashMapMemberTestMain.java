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
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd-HH��-mm��");

		try {
			os = new FileOutputStream("homeFile/hashmap.txt", true);
			do {
				System.out.print("ȸ�������� �Ͻ÷��� Y | �����Ͻ÷��� X �� �������� : ");
				answer = sc.next();
				if (answer.equalsIgnoreCase("x")) {
					System.out.println("����Ǿ����ϴ�.");
					break;
				} else if (answer.equalsIgnoreCase("y")) {
					System.out.print("�̸��� �Է��ϼ��� : ");
					name = sc.next();
					System.out.print("��ȭ��ȣ�� �Է��ϼ��� : ");
					tel = sc.next();
					System.out.print("��������� �Է��ϼ��� (yyyy-MM-dd) : ");
					StringTokenizer tokenizer = new StringTokenizer(sc.next(), "-");
					year = (Integer.parseInt(tokenizer.nextToken()) - 1900);
					month = (Integer.parseInt(tokenizer.nextToken()) - 1);
					day = Integer.parseInt(tokenizer.nextToken());
					birth = new Date(year, month, day);
					System.out.print("�ּҸ� �Է��ϼ��� : ");
					sc.nextLine();
					address = sc.nextLine();
					members.put(name, (new Member(name, tel, birth, address)));
				}
			} while (true);
			sc.close();
			if (members.isEmpty()) {
				System.out.println("������ ����� �����ϴ�.");
			} else {
				Iterator<String> iterator = members.keySet().iterator();
				while (iterator.hasNext()) {
					String key = iterator.next();
					os.write(members.get(key).toString().getBytes());
					os.write(line.getBytes());
					String b = sdf.format(members.get(key).getBirthday());
					if(b.equals(sdf.format(now))) {
						System.out.println(key+" ���� ���� : "+members.get(key)+" ���� �����մϴ�.");
					} else {
						System.out.println(key+" ���� ���� : "+members.get(key));
					}					
				}
				String msg = sdf2.format(now)+" ���� \t\t...���� "+members.size()+" �� ����"; 
				os.write(msg.getBytes());
				os.write(line.getBytes());
				System.out.println(sdf2.format(now)+" ���� \t\t...���� "+members.size()+" �� ����");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("string �������� ����");
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
