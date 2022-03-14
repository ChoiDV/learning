package com.lec.condition_조건문;

import java.util.Scanner;

public class Quiz3 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("국어 점수를 입력하세요 : ");
		int korean = sc.nextInt();

		System.out.print("영어 점수를 입력하세요 : ");
		int english = sc.nextInt();

		System.out.print("수학 점수를 입력하세요 : ");
		int math = sc.nextInt();

		int sum = korean + english + math;
		double average = (sum / 3.0);

		if (korean >= average) {
			System.out.println("국어 점수는 평균 이상입니다.");
		} else {
			System.out.println("국어 점수는 평균 이하입니다.");
		}

		if (english >= average) {
			System.out.println("영어 점수는 평균 이상입니다.");
		} else {
			System.out.println("영어 점수는 평균 이하입니다.");
		}

		if (math >= average) {
			System.out.println("수학 점수는 평균 이상입니다.");
		} else {
			System.out.println("수학 점수는 평균 이하입니다.");
		}

		sc.close();
	}

}
