package com.lec.ex;

import java.util.Scanner;

// ����ڷκ��� ����, ö��, �浿, ����, ������ Ű�� �Է¹޾�, ��� Ű�� ��� 
// ����� ģ���̸��� Ű, �ִܽ� ģ�� �̸��� Ű ���
public class Ex05_ {

	public static void main(String[] args) {

		String[] arrName = { "����", "ö��", "�浿", "����", "����" };
		int[] arrHeight = new int[arrName.length];

		Scanner sc = new Scanner(System.in);
		int totalHeight = 0; // �Է� ���� Ű ���� ����

		for (int idx = 0; idx < arrName.length; idx++) {
			System.out.print(arrName[idx] + " �� Ű�� �Է��ϼ��� : ");
			arrHeight[idx] = sc.nextInt();
			totalHeight += arrHeight[idx];
		}
		
		System.out.println("���Ű�� " + (double)(totalHeight/arrName.length));//����� ����ȯ double ������
		
		
		
		}
}
