package com.lec.ex;

import java.util.Scanner;

public class Ex06_factorial {
// ����ڷκ��� ���� �Է¹޾� �Է¹��� ��(3)  != 3*2*1 ( ���丮�� ����ϴ� �޼ҵ� �̿�)
	private static long factorial(int su) {
	// su�� 1�ʰ��� ��� : su * factorial(su-1)
	// su�� 1�̸� return 1
	if( su==1) { 
		return 1;  
	}else {           
		return su * factorial(su-1); 	// ����� �Լ� ȣ�� 
	}	// ex) su =3 �̸�  3* �ٽ� ���丮��(3-1=2) �� �ҷ��� 2�� 1�� �ƴϸ� *2 �������ؼ� 1�̵Ǹ� ��.
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
			System.out.print("����� �Է��ϼ��� : ");
			su = sc.nextInt();
		} while(su<= 0);
		
		long result = factorial(su);
		System.out.println("�Է��Ͻ� " + su + " != (���丮��) "+result);
		// System.out.printf("�Է��Ͻ� %d != %d", su,result);
		

	}

}
