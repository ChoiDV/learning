package com.lec.loop_반복문;

import java.util.Scanner;

public class Ex08_do_while {

	public static void main(String[] args) {

		// do-while 문
		// 짝수를 입력받는 프로그램 구현
		int num;
		Scanner sc = new Scanner(System.in);	
		
		do {
			System.out.print("짝수를 입력하세요 : ");
			num = sc.nextInt();
		} while ( num%2 !=0); {
			System.out.println("입력하신 " + num + " 은 짝수 입니다.");
		}
		sc.close();
	}

}
