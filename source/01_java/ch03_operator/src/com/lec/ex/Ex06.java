package com.lec.ex;

public class Ex06 {

	public static void main(String[] args) {
	
		// 삼항(3항)연산 :  ?:     조건식 ?  참일경우 : 거짓일경우
		// 삼항연산자  :    (조건) ? (참일경우 취할 값 or 식) : (거짓일경우 취할 값 or 식)
		int h = 100;
		String result;
		
//		if ( h%2==0) {           // if 문을 사용한 홀수 짝수 구별
//			result = "짝수";
//		}
//		else 		 {
//			result = "홀수";
//		}
		
		result = (h%2==0) ? "짝수" : "홀수";   // 삼항연산을 사용해서 홀수 짝수 구별
		
		System.out.println(result);

	}

}
