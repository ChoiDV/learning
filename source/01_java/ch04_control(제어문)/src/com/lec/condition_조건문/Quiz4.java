package com.lec.condition_���ǹ�;

import java.util.Scanner;

public class Quiz4 {

	public static void main(String[] args) {
		//���������� �� �ϳ��� ���� �� ���� ����ϼ���
		// ���� 0 ���� 1 �� 2
		Scanner sc = new Scanner(System.in);
		System.out.print("����(0) ����(1) ��(2) �� �ϳ��� ������ : ");
		int user = sc.nextInt();
		
		if (user == 0) {
			System.out.println("����");
		} else if (user ==1) {
			System.out.println("����");
		} else if (user ==2){
			System.out.println("��");
		} else {
			System.out.println("��ȿ���� �ʽ��ϴ�.");
		}
		
		sc.close();
		
	}

}
