package com.lec.ex;

public class Ex01 {
// ��������� : + , - , * , / , %
//  % ������������ 
	public static void main(String[] args) {
		
		int n1 = 33;
		int n2 = 10;
		int result;  			// + - * % �� ���
		double resultDouble; 	//  ������ / �� ���
		
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
			System.out.println("n1�� ¦���Դϴ�. ");
		else
			System.out.println("n1�� Ȧ���Դϴ�. ");
		
		if(n1%5 == 0)
			System.out.println("n1�� 5�� ����Դϴ�.");
		else
			System.out.println("n1�� 5�� ����� �ƴմϴ�.");
		
		
		
		
		
		
		

	}

}