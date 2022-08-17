package com.lec.ex01_string_friend;

import java.util.Scanner;

public class TestMain {

	public static void main(String[] args) {

		Friend[] friends = { new Friend("ȫ�浿", "010-9999-9999", "05-22"),
							 new Friend("�ű浿", "010-8888-8888", "09-22"),
							 new Friend("���浿", "010-8888-9999", "08-22"), 
							 new Friend("���浿", "010-7777-7777", "04-22"),
							 new Friend("��浿", "010-6666-7777", "03-22") };
		boolean searchOk = false;
		Scanner sc = new Scanner(System.in);
		String searchTel;
		do {
			System.out.print("��ȭ��ȣ ���ڸ��� �Է��ϼ��� (�����Ͻ÷��� x�� �Է��ϼ���) : ");
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
				System.out.println("�������� �ʴ� ģ���Դϴ�.");
			}
		} while (!searchTel.equalsIgnoreCase("x"));
		System.out.println("���� �Ǿ����ϴ�.");
		sc.close();

	}
}
