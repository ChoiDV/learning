package com.lec.ex;

import java.util.Scanner;

// ����ڷκ��� ����, ö��, �浿, ����, ������ Ű�� �Է¹޾�, ��� Ű�� ��� 
// ����� ģ���̸��� Ű, �ִܽ� ģ�� �̸��� Ű ���
public class Ex05_minimax {

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

		System.out.println("���Ű�� " + (double) (totalHeight / arrName.length));
		// ����� ����ȯ double ������

		int maximum = arrHeight[0], maxindex=0;   // ���� ũ�� �������� �ε����� ����� ���� maxindex,minindex .
		int minimum = arrHeight[0],  minindex=0;
		
		for (int i = 0; i < arrHeight.length; i++) {
			if (arrHeight[i] > maximum) {
				maximum = arrHeight[i];
				maxindex = i;
			}// if-maximum
		} // for-maximum
		
		System.out.println("���� Ű�� ū ����� "+ arrName[maxindex]+  " �̰� Ű�� " + maximum);

		for (int i = 0; i < arrHeight.length; i++) {
			if (arrHeight[i] < minimum) {
				minimum = arrHeight[i];
				minindex = i;
			}// if -minimum
		}  // for- minimum
		
		System.out.println("���� Ű�� ���� ����� "+arrName[minindex] + " �̰� Ű�� " + minimum);
	} // main 
} // class
