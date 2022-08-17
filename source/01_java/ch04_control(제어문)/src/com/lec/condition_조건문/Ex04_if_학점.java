package com.lec.condition_조건문;

import java.util.Scanner;

public class Ex04_if_학점 {

	public static void main(String[] args) {
		// 사용자로부터 점수를 입력받아 학점 출력.
		Scanner sc = new Scanner(System.in);
		System.out.print("점수 : ");
		int score = sc.nextInt();
		
		if ((90 <= score) && (score <=100)) {
			System.out.println("학점 A");
		} else if ((80<=score) && (score <90)) {
			System.out.println("학점 B");
		} else if ((70<=score) && (score <80)) {
			System.out.println("학점 C");
		}else if ((60<=score) && (score <70)) {
			System.out.println("학점 D");
		}else if ((0<=score) && (score <60)) {
			System.out.println("학점 F");
		}else {
			System.out.println("유효한 점수가 아닙니다.");
		}
	}
}