package com.lec.loop_�ݺ���;

public class Quiz4_for {

	public static void main(String[] args) {
		// ������ ���� ��� ������ �������� ����ϴ� ���α׷��� ������ ����.
		for (int j = 1; j < 10; j++) { // 1~9   ���� ����
			for (int i = 2; i < 10; i++) { // 2~9  ��
				System.out.print(i + "*" + j + "=" + i * j + "\t");
			} // for -i
			System.out.println();
		} // for - j		
	} // main
} // class
