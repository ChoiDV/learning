package com.lec.quiz;

import java.util.Scanner;

public class Quiz2 {
	//�Է��� ���� ¦������ Ȧ������ ���
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("���ڸ� �Է��Ͻÿ� : ");
		int su = sc.nextInt();
		
		// ���׿�����
		System.out.println((su%2 ==0) ? "su �� ¦���Դϴ�." : "su �� Ȧ���Դϴ�." );
		
		
		// if�� ����ؼ� �ϱ�
		if (su%2==0)
			System.out.println("su �� ¦���Դϴ�.");
		else
			System.out.println("su �� Ȧ���Դϴ�.");
	}

}
