package com.lec.quiz;

import java.util.Scanner;

public class Quiz2 {
	//입력한 수가 짝수인지 홀수인지 출력
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자를 입력하시오 : ");
		int su = sc.nextInt();
		
		// 삼항연산자
		System.out.println((su%2 ==0) ? "su 는 짝수입니다." : "su 는 홀수입니다." );
		
		
		// if문 사용해서 하기
		if (su%2==0)
			System.out.println("su 는 짝수입니다.");
		else
			System.out.println("su 는 홀수입니다.");
	}

}
