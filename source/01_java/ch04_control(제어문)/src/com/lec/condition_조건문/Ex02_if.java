package com.lec.condition_���ǹ�;

import java.util.Scanner;

public class Ex02_if {

	public static void main(String[] args) {
		
		// ����ڷκ��� �� ���� �Է¹޾� ù��° ���� �� ū�� �ι�° ���� �� ū�� ���
		int num1, num2;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("ù ��° ���� �Է��ϼ��� : ");
		num1 = sc.nextInt();
		
		System.out.print("�� ��° ���� �Է��ϼ��� : ");
		num2 = sc.nextInt();
		
		if (num1 > num2) {
			System.out.println("ù ��° �� �� " + (num1-num2)+ "��ŭ �� Ů�ϴ�.");
		}
		else if (num1 < num2) {
			System.out.printf("�� ��° �� �� %d ��ŭ �� Ů�ϴ�\n",num2-num1);
		}
		else {
			System.out.println("�� �� �� �����ϴ�.");
		}
		sc.close();
		
	}

}
