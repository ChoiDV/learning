package com.lec.quiz;

import java.util.Scanner;

public class Quiz4 {
// 나이를 입력받아 입력받은 나이가 65세 이상일 때, “경로우대” 출력, 아니면 “일반”출력
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("나이를 입력하시오 : ");
		int i = sc.nextInt();
		
		// 삼항연산자
		System.out.println((i >=65) ? "경로우대" : "일반");
		
		
		// if문 
		if (i >= 65)
			System.out.println("경로우대");
		else
			System.out.println("일반");

	}

}
