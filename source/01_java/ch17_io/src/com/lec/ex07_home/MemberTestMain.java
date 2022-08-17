package com.lec.ex07_home;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
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
		String answer, name, tel, address;
		String line = "\n";
		int year, month, day;
		Date birth;
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd-HH-mm");
		try {
			os = new FileOutputStream("homeFile/member.txt", true);
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
					members.add(new Member(name, tel, birth, address));
				}
			} while (true);
			sc.close();
			if (members.isEmpty()) {
				System.out.println("������ ����� �����ϴ�.");
			} else {
				for (int i = 0; i < members.size(); i++) {
					os.write(members.get(i).toString().getBytes());
					os.write(line.getBytes());
					String b = sdf.format(members.get(i).getBirthday());
					if (b.equals(sdf.format(now))) {
						System.out.println(members.get(i) + "\t���������մϴ�.");
					} else {
						System.out.println(members.get(i));
					}
				}
				String msg = sdf2.format(now) + " ���� \t\t...���� " + members.size() + " �� ����";
				System.out.println("\t\t...���� " + members.size() + " �� ����");
				os.write(msg.getBytes());
				os.write(line.getBytes());
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (os != null) {
					os.close();
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
