package com.lec.quiz;

import java.util.Scanner;

public class Quiz5 {
//국어, 영어, 수학 점수를 변수에 할당하고 각 점수를 출력하고 총점, 평균(소수점2자리까지) 출력하는 프로그램을 구현 하시오
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("국어 점수를 입력하시오 : ");
		int korean = sc.nextInt();
		
		System.out.print("영어 점수를 입력하시오 : ");
		int english = sc.nextInt();
		
		System.out.print("수학 점수를 입력하시오 : ");
		int math = sc.nextInt();
		
		
		System.out.println("국어 점수 : " + korean + "점");
		System.out.println("영어 점수 : " + english + "점");
		System.out.println("수학 점수 : " + math + "점");
		
		int sum = (korean + english + math);
		System.out.println("국어,영어,수학의 총점은 : " + sum + " 점");
		
		double average = (sum/3);
		System.out.printf("국어,영어,수학의 평균은 : %4.2f",average);
		System.out.println(" 점");
	}

}
