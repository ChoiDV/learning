package com.lec.condition_���ǹ�;

import java.util.Scanner;

// 0 <= Math.random() < 1 �߻�
// 0 <= Math.random()*3 <3
// 0 <= (int)(Math.random()*3) : 0,1,2 ���� �ϳ�
public class Quiz5_2 {
	// ------------------Quiz5 �� �ٸ����� �ι�° ����. ---------------------------------------------
	public static void main(String[] args) {
		// ��ǻ�Ϳ� ���������� ������ �ϴ� ���α׷��� �����Ͻÿ�. ��,
		// ����ڴ� ������ ������ �� ���� 0�� �Է��ϰ� ������ �����ϰ��� �� ���� 1�� �Է��ϰ�,
		// ���� �����ϰ��� �� ���� 2�� �Է��Ͽ� ������ �����մϴ�

		Scanner sc = new Scanner(System.in);
		System.out.print("����(0) ����(1) ��(2) �� �ϳ��� ������ : ");
		int user, computer = (int) (Math.random() * 3);
		user = sc.nextInt();

		if (user == 0) {
			System.out.print("����ڴ� ���� \t");
		} else if (user == 1) {
			System.out.print("����ڴ� ���� \t");
		} else if (user == 2) {
			System.out.print(" ����� ���ڱ� \t");
		} else {
			System.out.println("����� �߸� �½��ϴ�. ���α׷��� �����մϴ�.");
			user = 3; // ������ ���� ����.
		}

		if (user != 3) { // ����ڰ� �ùٸ� ���� �Է��������� ��ǻ�Ͱ� ������ ����� ���� ���.
			String msg = (computer == 0) ? "��ǻ�ʹ� ����" : (computer == 1) ? "��ǻ�ʹ� ����" : "��ǻ�ʹ� ��";
			System.out.println(msg);

			// ����� �� 3���� : ����. �̰�� , ����.
			// if((user ==0 && computer==1) || (user==1) || (computer==2)){
			// �̷������� ������ Ȱ���ؼ� �ص��ǰ�

			// ����ȭ �ؼ� �ص���. �ؿ�

			if ((user + 1) % 3 == computer) {
				System.out.println("����� �й�.");
			} else if (user == computer) {
				System.out.println("���º�");
			} else {
				System.out.println("����� �¸�.");
			} // if - ���� ���
		} // if
	} // main
} // class
