package com.lec.quiz;

import java.util.Scanner;

public class Quiz1 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("숫자를 입력하시오 : ");
		int i = scanner.nextInt();
		
		// 삼항연산자 이용해서  조건식   ?   참일경우   : 거짓일경우 
		System.out.println(( i%3 == 0) ? "입력하신 "+i+"는 3의 배수입니다." : "입력하신"+i+"는 3의 배수가 아닙니다.");
		
		scanner.close();   // scanner를 사용자에게 받고 종료시켜주는것? 
		
		// if 문 
		if (i%3 == 0)
			System.out.println("3의 배수 o ");
		else 
			System.out.println("3의 배수 x ");
		
		
	}

}

