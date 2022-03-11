package com.lec.ex;

public class Ex05 {
	// & (비트연산자 and )  | (비트연산자 or)
	public static void main(String[] args) {
		
		int i = 3;         //  0 0 1 1        // 이진수로 비교하는것 
		int j = 1;		   //  0 0 0 1 		  // 비트별로  and 연산하는것임 안씀 
						   //  --------
		                   //  0 0 0 1
		
		System.out.println(i & j );

	}

}
