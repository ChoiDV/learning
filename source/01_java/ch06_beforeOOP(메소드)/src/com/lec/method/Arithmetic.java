package com.lec.method;

public class Arithmetic {
	public int abs(int value) {
		int result = (value>=0) ? value : -value;
		return result;
	}             // 절대값 구하는 메소드(함수) abs 만들기 
//  if문 사용하기
//		int result;
//		if (value >= 0) {
//			result = value;
//		} else {
//			result = -value;
//		}
//		return result;

	public static int sum(int from, int to) {
		int result = 0;
		for (int i = from; i <= to; i++) {
			result += i;
		}
		return result;
	}

	public static int sum(int to) {
		int result = 0;
		for (int i = 1; i <= to; i++) {
			result += i;
		}
		return result;
	}

	public static String evenOdd(int value) {

		String result;
		if (value % 2 == 0) {
			result = "짝수입니다. ";
		} else {
			result = "홀수입니다. ";
		}
		return result;

	}

}
