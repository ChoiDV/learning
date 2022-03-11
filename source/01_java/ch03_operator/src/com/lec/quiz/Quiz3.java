package com.lec.quiz;

import java.util.Scanner;

public class Quiz3 {
//두수를 입력받아 	두 수가 같은지 결과를 O나 X로 출력. 첫번째 수가 더 큰지 결과를 O나 X로 출력한다.

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("첫번째 수를 입력하시오 : " );
		int i = sc.nextInt();
		
		System.out.print("두번째 수를 입력하시오 : " );
		int x = sc.nextInt();
		
		// 삼항연산자
		System.out.println((i==x) ? "두 수가 같은가요?" +" O" : "두 수가 같은가요?" +" X" );
		System.out.println((i>x) ? "첫번째 숫자가 더 큰가요? " + "O": "첫번째 숫자가 더 큰가요? "+"X");
		
		
		
		// if문
		if ( i==x)
			System.out.println("두 수가 같은가요?" +" O");
		else
			System.out.println("두 수가 같은가요?" +" X");
		
		
		if ( i  > x)
			System.out.println("첫번째 숫자가 더 큰가요? " + "O");
		else
			System.out.println("첫번째 숫자가 더 큰가요? "+"X");
		
		
		
	}

}
