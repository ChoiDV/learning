package com.lec.loop_�ݺ���;

import java.util.Scanner;

public class Quiz5_do_while {

	public static void main(String[] args) {
		// ����ڰ� �� ������ ���������� ������ �ϴ� ���α׷� ����
		Scanner sc = new Scanner(System.in);
		int you, computer;
		do {
			computer = (int)(Math.random()*3);
			System.out.print("����(0), ����(1), ��(2) �� �ϳ� ������ : ");
			you = sc.nextInt();
			if (you == 0) {
				System.out.print("����� ����\t");
			} else if (you == 1) {
				System.out.print("����� ����\t");
			} else if (you == 2) {
				System.out.print("����� ���ڱ�\t");
			} else {
				System.out.print("����� �߸� �¾��. ����");
				you = 3; // ������ ���� ����
			} // if - you���
			if (you != 3) { // ��ǻ�Ͱ� �� �Ͱ� ���� ���
				String msg = (computer == 0) ? "���� ����" : (computer == 1) ? "���� ����" : "���� ���ڱ�";
				System.out.println(msg);
				// ����� ���� 3���� : ����, �̰��, ����
				if( (you+1)%3 == computer) {
					System.out.println("����� ����� ");
					break; // ����� ���� �ݺ��� ��������
				}else if(you == computer ) {
					System.out.println("����");
				}else {
					System.out.println("����� �̰��� ");
				}// if - ���� ���
			} // if
		}while(true);
		System.out.println("�ȳ��� ������");
	}
}
	