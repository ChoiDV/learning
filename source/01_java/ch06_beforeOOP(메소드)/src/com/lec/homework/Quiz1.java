package com.lec.homework;

import java.util.Scanner;

public class Quiz1 {
	private static void ggd(int dansu) {

		for (int i = 1; i < 10; i++) {
			System.out.println(dansu + " * " + i + " = " + (dansu * i));
		}
	}

	public static void main(String[] args) {

		int dansu2;

		do {
			Scanner sc = new Scanner(System.in);
			System.out.print("원하는 단수를 입력하세요 : ");
			dansu2 = sc.nextInt();
		} while ((dansu2 < 2) || (dansu2 > 9));
		/// 2~9
		ggd(dansu2);

	}
}
