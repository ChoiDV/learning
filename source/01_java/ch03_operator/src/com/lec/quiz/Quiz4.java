package com.lec.quiz;

import java.util.Scanner;

public class Quiz4 {
// ���̸� �Է¹޾� �Է¹��� ���̰� 65�� �̻��� ��, ����ο�롱 ���, �ƴϸ� ���Ϲݡ����
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("���̸� �Է��Ͻÿ� : ");
		int i = sc.nextInt();
		
		// ���׿�����
		System.out.println((i >=65) ? "��ο��" : "�Ϲ�");
		
		
		// if�� 
		if (i >= 65)
			System.out.println("��ο��");
		else
			System.out.println("�Ϲ�");

	}

}
