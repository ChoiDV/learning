package com.lec.loop_�ݺ���;

import java.util.Scanner;

public class Ex08_do_while {

	public static void main(String[] args) {

		// do-while ��
		// ¦���� �Է¹޴� ���α׷� ����
		int num;
		Scanner sc = new Scanner(System.in);	
		
		do {
			System.out.print("¦���� �Է��ϼ��� : ");
			num = sc.nextInt();
		} while ( num%2 !=0); {
			System.out.println("�Է��Ͻ� " + num + " �� ¦�� �Դϴ�.");
		}
		sc.close();
	}

}
