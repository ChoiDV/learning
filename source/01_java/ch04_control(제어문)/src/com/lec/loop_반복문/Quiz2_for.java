package com.lec.loop_�ݺ���;

public class Quiz2_for {

	public static void main(String[] args) {
		// 1~10���� ���� �� ¦�� �Ǵ� Ȧ���� ���� ���غ���
		int total = 0;
		int total2 = 0;
		for (int i = 0; i <= 10; i++) {
			if (i % 2 == 0) {   // ¦������ total �� �ֱ�
				total += i;
			} else { 	 		// Ȧ������ total2 �� �ֱ�
				total2 += i;
			}

		}
		System.out.println("1~10�� ¦������ ���� : " + total);
		System.out.println("1~10�� Ȧ������ ���� : " + total2);

	}

}
