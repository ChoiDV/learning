package com.lec.loop_�ݺ���;

public class Ex07_for_while {

	public static void main(String[] args) {
		// ���� 9��
		// 1~100�߿� 3�� ����� �� ���ϱ�.
		int sum = 0;
		int i = 1;

		while (i < 101) {
			if (i % 3 == 0) {
				sum += i;
			}
			i++;
		}

		// for��
//		for (int i = 1; i <= 100; i++) {
//			if (i % 3 == 0) {
//				sum += i; // sum = sum+i;
//			} // if - 3�� ���
//		} // for -i
		System.out.println("1~100�߿� `	3�� ����� ���� : " + sum);
	}

}
