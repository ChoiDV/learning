package com.lec.loop_반복문;

public class Quiz2_for {

	public static void main(String[] args) {
		// 1~10까지 숫자 중 짝수 또는 홀수의 합을 구해보자
		int total = 0;
		int total2 = 0;
		for (int i = 0; i <= 10; i++) {
			if (i % 2 == 0) {   // 짝수들을 total 에 넣기
				total += i;
			} else { 	 		// 홀수들을 total2 에 넣기
				total2 += i;
			}

		}
		System.out.println("1~10의 짝수들의 합은 : " + total);
		System.out.println("1~10의 홀수들의 합은 : " + total2);

	}

}
