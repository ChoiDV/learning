package com.lec.quiz;

import java.util.Scanner;

public class Quiz1 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("���ڸ� �Է��Ͻÿ� : ");
		int i = scanner.nextInt();
		
		// ���׿����� �̿��ؼ�  ���ǽ�   ?   ���ϰ��   : �����ϰ�� 
		System.out.println(( i%3 == 0) ? "�Է��Ͻ� "+i+"�� 3�� ����Դϴ�." : "�Է��Ͻ�"+i+"�� 3�� ����� �ƴմϴ�.");
		
		scanner.close();   // scanner�� ����ڿ��� �ް� ��������ִ°�? 
		
		// if �� 
		if (i%3 == 0)
			System.out.println("3�� ��� o ");
		else 
			System.out.println("3�� ��� x ");
		
		
	}

}

