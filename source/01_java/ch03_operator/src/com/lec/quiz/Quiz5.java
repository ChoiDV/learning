package com.lec.quiz;

import java.util.Scanner;

public class Quiz5 {
//����, ����, ���� ������ ������ �Ҵ��ϰ� �� ������ ����ϰ� ����, ���(�Ҽ���2�ڸ�����) ����ϴ� ���α׷��� ���� �Ͻÿ�
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("���� ������ �Է��Ͻÿ� : ");
		int korean = sc.nextInt();
		
		System.out.print("���� ������ �Է��Ͻÿ� : ");
		int english = sc.nextInt();
		
		System.out.print("���� ������ �Է��Ͻÿ� : ");
		int math = sc.nextInt();
		
		System.out.println("���� ���� : " + korean + "��");
		System.out.println("���� ���� : " + english + "��");
		System.out.println("���� ���� : " + math + "��");
		
		int sum = (korean + english + math);
		System.out.println("����,����,������ ������ : " + sum + " ��");
		
		double average = (sum/3);
		System.out.printf("����,����,������ ����� : %4.2f",average);
		System.out.println(" ��");
	}

}
