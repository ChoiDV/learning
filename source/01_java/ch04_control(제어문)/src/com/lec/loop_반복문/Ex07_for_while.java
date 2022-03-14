package com.lec.loop_반복문;

public class Ex07_for_while {

	public static void main(String[] args) {
		// 예제 9번
		// 1~100중에 3의 배수의 합 구하기.
		int sum = 0;
		int i = 1;

		while (i < 101) {
			if (i % 3 == 0) {
				sum += i;
			}
			i++;
		}

		// for문
//		for (int i = 1; i <= 100; i++) {
//			if (i % 3 == 0) {
//				sum += i; // sum = sum+i;
//			} // if - 3의 배수
//		} // for -i
		System.out.println("1~100중에 `	3의 배수의 합은 : " + sum);
	}

}
