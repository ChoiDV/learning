package com.lec.condition_조건문;

import java.util.Scanner;

public class Ex02_if {

	public static void main(String[] args) {
		
		// 사용자로부터 두 수를 입력받아 첫번째 수가 더 큰지 두번째 수가 더 큰지 출력
		int num1, num2;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("첫 번째 수를 입력하세요 : ");
		num1 = sc.nextInt();
		
		System.out.print("두 번째 수를 입력하세요 : ");
		num2 = sc.nextInt();
		
		if (num1 > num2) {
			System.out.println("첫 번째 수 가 " + (num1-num2)+ "만큼 더 큽니다.");
		}
		else if (num1 < num2) {
			System.out.printf("두 번째 수 가 %d 만큼 더 큽니다\n",num2-num1);
		}
		else {
			System.out.println("두 수 는 같습니다.");
		}
		sc.close();
		
	}

}
