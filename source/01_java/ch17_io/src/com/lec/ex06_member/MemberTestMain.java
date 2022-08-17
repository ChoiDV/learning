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
//			writer = new FileWriter("memberFile/member.txt", true);      //  writer ����
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
					y = (Integer.parseInt(tokenizer.nextToken()) - 1900);
					m = (Integer.parseInt(tokenizer.nextToken()) - 1);
					d = Integer.parseInt(tokenizer.nextToken());
					birth = new Date(y, m, d);
//					System.out.print("�¾ ������ �Է��ϼ��� : ");
//					int year = ((sc.nextInt()) - 1900);
//					System.out.print("������ �� �� �Է��ϼ��� (MM): ");
//					int month = (sc.nextInt() - 1);
//					System.out.print("������ �� �� �Է��ϼ��� (dd): ");
//					int day = (sc.nextInt());
//					birth = new Date(year, month, day);
					System.out.print("�ּҸ� �Է��ϼ��� : ");
					sc.nextLine();
					address = sc.nextLine();
					members.add(new Member(name, tel, birth, address));
//					int a =Integer.parseInt(members.toString());		

				}
			} while (true);
			sc.close();
//			if (members.isEmpty()) {
//				System.out.println("������ ����� �����ϴ�.");
//			} else {
//				for (int i = 0; i < members.size(); i++) {                   ***  // writer ���� ****
//					writer.write(members.get(i).toString());
//					String line = "\n";
//					write.write(line);
//				String d = sdf.format(members.get(i).getBirthday());
//				if (d.equals(sdf.format(new Date()))) {
//					System.out.println(members.get(i) + "   ���� �����մϴ�.");
//				} else {
//					System.out.println(members.get(i));
//				}
//					
//				}
//				System.out.println("... ���� " + members.size() + " �� ����");
//			}

			if (members.isEmpty()) {
				System.out.println("������ ����� �����ϴ�.");
			} else {
				String msg = "\t\t... ���� " + members.size() + " �� ����";
				String line = "\n";
				for (int i = 0; i < members.size(); i++) {
					os.write(members.get(i).toString().getBytes());
					os.write(line.getBytes());
					String x = sdf.format(members.get(i).getBirthday());
					if (x.equals(sdf.format(now))) {
						System.out.println(members.get(i) + "   ���� �����մϴ�.");
					} else {
						System.out.println(members.get(i));
					}
				}
				os.write(msg.getBytes());
				os.write(line.getBytes());
				System.out.println("\t\t... ���� " + members.size() + " �� ����");

			}

		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (os != null) {
					os.close();
				}
//				if (writer != null) {       *******writer ���� ***********
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
