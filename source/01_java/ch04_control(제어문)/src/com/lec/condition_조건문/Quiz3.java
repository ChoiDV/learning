package com.lec.condition_���ǹ�;

import java.util.Scanner;

public class Quiz3 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("���� ������ �Է��ϼ��� : ");
		int korean = sc.nextInt();

		System.out.print("���� ������ �Է��ϼ��� : ");
		int english = sc.nextInt();

		System.out.print("���� ������ �Է��ϼ��� : ");
		int math = sc.nextInt();

		int sum = korean + english + math;
		double average = (sum / 3.0);

		if (korean >= average) {
			System.out.println("���� ������ ��� �̻��Դϴ�.");
		} else {
			System.out.println("���� ������ ��� �����Դϴ�.");
		}

		if (english >= average) {
			System.out.println("���� ������ ��� �̻��Դϴ�.");
		} else {
			System.out.println("���� ������ ��� �����Դϴ�.");
		}

		if (math >= average) {
			System.out.println("���� ������ ��� �̻��Դϴ�.");
		} else {
			System.out.println("���� ������ ��� �����Դϴ�.");
		}

		sc.close();
	}

}
