package test1;

import java.util.Date;
import java.util.Scanner;

public class TestMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Friend[] friends = { new Friend("ȫ�浿", "010-9999-1234", "����� ��걸", new Date(99, 4, 22)),
				new Friend("���浿", "010-8888-1134", "���ν� ���ﱸ", new Date(99, 6, 7)),
				new Friend("�ڱ浿", "010-8888-1334", "���ν� ó�α�", new Date(99, 6, 7)) };
		String answer, searchaddress, searchphone;

		while (true) {
			System.out.print("�˻��� �ּ� �� ���� 2�ڸ�(��, ���Ḧ ���Ͻø� x�� �Է��Ͻÿ� : ");
			answer = sc.next();
			boolean ok = false;
			if (answer.equalsIgnoreCase("x")) {
				System.out.println("����Ǿ����ϴ�.");
				break;
			}
			for (int i = 0; i < friends.length; i++) {
				searchaddress = friends[i].getAddress().substring(0, 2);
				if (answer.equals(searchaddress)) {
					System.out.println("ã���ô� ���� : " + friends[i]);
					ok = true;
				}
			}
			if (!ok) {
				System.out.println("ã���ô� ����� �����ϴ�.\n");
			}

		}

	}
}
