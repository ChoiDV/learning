package com.lec.loop_�ݺ���;

// 1~40 ���� ���ٿ� 4���� ����ϱ�.
public class Ex04_for {

	public static void main(String[] args) {
		for (int i = 1; i <= 40; i++) {
			System.out.print(i + "\t");
			if (i % 4 == 0) {
				System.out.println();
			}
		}
	}
}
