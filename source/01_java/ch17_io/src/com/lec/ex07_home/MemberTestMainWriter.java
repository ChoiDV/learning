package com.lec.ex07_home;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MemberTestMainWriter {
	public static void main(String[] args) {
		ArrayList<Member> members = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		Writer writer = null;
		Date birth;
		Date now = new Date();
		String answer, name, tel, address;
		String line = "\n";
		try {
			writer = new FileWriter("homeFile/memberFile2.txt", true);
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
					System.out.print("�¾ ��,��,�� �� �Է��ϼ���(yyyy-MM-dd) : ");
					String birthday = sc.next();
					StringTokenizer tokenizer = new StringTokenizer(birthday, "-");
					int y = (Integer.parseInt(tokenizer.nextToken()) - 1900);
					int m = (Integer.parseInt(tokenizer.nextToken()) - 1);
					int d = Integer.parseInt(tokenizer.nextToken());
					birth = new Date(y, m, d);
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
					writer.write(members.get(i).toString());
					writer.write(line);
					String b = sdf.format(members.get(i).getBirthday());
					if (b.equals(sdf.format(now))) {
						System.out.println(members.get(i) + "\t���������մϴ�.");
					} else {
						System.out.println(members.get(i));
					}
				}
				System.out.println("\t\t.....���� " + members.size() + "�� ����");
				String tot = "\t\t.....���� " + members.size() + "�� ����";
				writer.write(tot);
				writer.write(line);
			}

		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (writer != null) {
					writer.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}
}
