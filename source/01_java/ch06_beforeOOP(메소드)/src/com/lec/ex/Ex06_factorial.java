package com.lec.ex;

import java.util.Scanner;

public class Ex06_factorial {
// 사용자로부터 수를 입력받아 입력받은 수(3)  != 3*2*1 ( 팩토리얼 계산하는 메소드 이용)
	private static long factorial(int su) {
	// su가 1초과일 경우 : su * factorial(su-1)
	// su가 1이면 return 1
	if( su==1) { 
		return 1;  
	}else {           
		return su * factorial(su-1); 	// 재귀적 함수 호출 
	}	// ex) su =3 이면  3* 다시 팩토리얼(3-1=2) 를 불러서 2가 1이 아니면 *2 쭉쭉쭉해서 1이되면 끝.
}
	
//		int result = 1;
//		for (int i=su; i>=1; i--) {
//			result *= i;
//		}
//		return result;
//	}
	
	public static void main(String[] args) {
		
		int su; 
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.print("양수를 입력하세요 : ");
			su = sc.nextInt();
		} while(su<= 0);
		
		long result = factorial(su);
		System.out.println("입력하신 " + su + " != (팩토리얼) "+result);
		// System.out.printf("입력하신 %d != %d", su,result);
		

	}

}
