package com.lec.loop_반복문;

// 1~40 까지 한줄에 4개씩 출력하기.
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
