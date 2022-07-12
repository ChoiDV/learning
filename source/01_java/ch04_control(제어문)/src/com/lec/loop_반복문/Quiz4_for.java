package com.lec.loop_반복문;

public class Quiz4_for {

	public static void main(String[] args) {
		// 다음과 같은 출력 형식의 구구단을 출력하는 프로그램을 구현해 보자.
		for (int j = 1; j < 10; j++) { // 1~9   곱할 숫자
			for (int i = 2; i < 10; i++) { // 2~9  단
				System.out.print(i + "*" + j + "=" + i * j + "\t");
			} // for -i
			System.out.println();
		} // for - j		
	} // main
} // class
