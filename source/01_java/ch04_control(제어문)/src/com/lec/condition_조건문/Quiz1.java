package com.lec.condition_조건문;

import java.util.Scanner;

public class Quiz1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("수 를 입력하세요 : ");
		int su = sc.nextInt();
		
		if (su >=0 ) {
			System.out.printf("입력하신 수의 절대값은 : %d\n",su);
		} else {
			System.out.printf("입력하신 수의 절대값은 : %d\n ", -su);
		}
		

		sc.close();
	}

}
