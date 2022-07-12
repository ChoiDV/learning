package com.lec.ex04_member;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

// ���� Ű������ get�ϸ� null�� ����
public class TeacherTestMainHash {
	public static void main(String[] args) {
		HashMap<String, Member> members = new HashMap<String, Member>();
		Scanner sc = new Scanner(System.in);
		String answer, name, tel, address;

		do {
			System.out.print("ȸ������ �����Ͻðڽ��ϱ� (Y/N) : ");
			answer = sc.next();
			if (answer.equalsIgnoreCase("n")) {
				System.out.println("����Ǿ����ϴ�.");
				break;
			} else if (answer.equalsIgnoreCase("y")) {
				System.out.print("�̸��� �Է��ϼ��� : ");
				name = sc.next();
				System.out.print("��ȣ�� �Է��ϼ��� : ");
				tel = sc.next();
				// Ű�� �ߺ�Ȯ���ϴ� ���
				if (members.get(tel) != null) { // members�� tel�� Ű���� �ҷ��ͼ� �װ� null�� �ƴϸ� Ű���� �̹� telŰ ���� �ִٴ� �Ҹ��ϱ�
					// �ȳ����� ����ϰ� continue �ؼ� �ٽ� do�� �������� 
					System.out.println("�̹� ���ԵǾ� �ִ� ��ȭ��ȣ�Դϴ�. ��ȭ��ȣ�� �ߺ��� �� �����ϴ�.");
					continue;
				}
				// ������ ������ ��ȭ��ȣ���� Ȯ���ϴ¹��2
//				Iterator<String> iterator = members.keySet().iterator();
//				boolean telChk = false;

				System.out.print("�ּҸ� �Է��ϼ��� : ");
				sc.nextLine();
				address = sc.nextLine();
				members.put(tel, new Member(name, tel, address));
			}

		} while (true);
		sc.close();
		if(members.isEmpty()) {
			System.out.println("������ ȸ���� �����ϴ�.");
		} else {
			System.out.println("������ ȸ�� ����Ʈ ���");
			Iterator<String> iterator = members.keySet().iterator();
			while(iterator.hasNext()) {
				String key = iterator.next();
				System.out.println(key + " �� ������ : "+ members.get(key));
			}
		}
	}
}
