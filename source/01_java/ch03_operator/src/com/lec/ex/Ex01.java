package com.lec.ex;

public class Ex01 {
// 산술연산자 : + , - , * , / , %
//  % 나머지연산자 
	public static void main(String[] args) {
		
		int n1 = 33;
		int n2 = 10;
		int result;  			// + - * % 의 결과
		double resultDouble; 	//  나누기 / 의 결과
		
		result = n1 + n2;
		System.out.printf("%d %c %d = %d\n", n1, '+',n2 ,result);
		result = n1 - n2;
		System.out.printf("%d %c %d = %d\n", n1, '-',n2 ,result);
		result = n1 * n2;
		System.out.printf("%d %c %d = %d\n", n1, '*',n2 ,result);
		result = n1 % n2;  
		System.out.printf("%d %c %d = %d\n", n1, '%',n2 ,result);
				
		resultDouble = (double)n1 / n2;
		System.out.printf("%d %c %d = %f\n", n1, '/',n2 ,resultDouble);
		
		System.out.println(n1 +" / " + n2 + " = " + resultDouble);
		
		if(n1%2 == 0)
			System.out.println("n1은 짝수입니다. ");
		else
			System.out.println("n1은 홀수입니다. ");
		
		if(n1%5 == 0)
			System.out.println("n1은 5의 배수입니다.");
		else
			System.out.println("n1은 5의 배수가 아닙니다.");
		
		
		
		
		
		
		

	}

}
