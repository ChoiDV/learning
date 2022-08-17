package com.lec.ex;

public class Ex02 {
// 증감연산자    ++ , -- 
	public static void main(String[] args) {
		int n1 = 10;
		System.out.println("증감연산을 하기전 원래 n1값 : " + n1);
		//int n2 = --n1;
		int n3 = n1--;
		System.out.println("증감연산을 뒤에 두고 하면 새로 초기화 되는 n1 값  = " + n1);
		//System.out.println("n2 = " + n2);
		System.out.println("n3 = " + n3);
		
		
		// 	++ , -- 증감연산자를 앞에다 붙히면 즉시 실행
		//  뒤에다 붙히면 그 식은 끝나고 다음식이 실행되기 직전에 실행됨 
		
		//  n2는 --가 실행되고 그값이 n1,n2가 된다 
		//	 근데 뒤에다가 --를 붙히면   n1 10, n3 10이 되고(그냥 n1값인 10이 n3,n1이 되고)
		//  끝난뒤 10-1 인 9가 n1 값이 된다. 그러면서 n1 값은 새로운값으로 초기화된다고 생각하면 될듯 
		
		

	}

}
