package com.lec.quiz;

import java.util.Scanner;

public class Quiz3 {
//�μ��� �Է¹޾� 	�� ���� ������ ����� O�� X�� ���. ù��° ���� �� ū�� ����� O�� X�� ����Ѵ�.

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("ù��° ���� �Է��Ͻÿ� : " );
		int i = sc.nextInt();
		
		System.out.print("�ι�° ���� �Է��Ͻÿ� : " );
		int x = sc.nextInt();
		
		// ���׿�����
		System.out.println((i==x) ? "�� ���� ��������?" +" O" : "�� ���� ��������?" +" X" );
		System.out.println((i>x) ? "ù��° ���ڰ� �� ū����? " + "O": "ù��° ���ڰ� �� ū����? "+"X");
		
		
		
		// if��
		if ( i==x)
			System.out.println("�� ���� ��������?" +" O");
		else
			System.out.println("�� ���� ��������?" +" X");
		
		
		if ( i  > x)
			System.out.println("ù��° ���ڰ� �� ū����? " + "O");
		else
			System.out.println("ù��° ���ڰ� �� ū����? "+"X");
		
		
		
	}

}
