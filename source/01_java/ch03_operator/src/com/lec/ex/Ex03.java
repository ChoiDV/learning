package com.lec.ex;

public class Ex03 {

	public static void main(String[] args) {
		
		// 관계 연산자 (비교 연산자)  > >=  <  <=  ==   !=(다르다)
		
		int n1 = 10;
		int n2 = 20;
		boolean result;
		result = n1 > n2;
		System.out.printf("%d %c %d = %b\n",n1,'>',n2,result);
		result = n1 == n2;
		System.out.printf("%d %s %d = %b\n",n1,"==",n2,result);
		result = n1 < n2;
		System.out.printf("%d %c %d = %b\n",n1,'<',n2,result);
		result = n1 != n2;
		System.out.printf("%d %s %d = %b\n",n1,"!=",n2,result);
	}

}
