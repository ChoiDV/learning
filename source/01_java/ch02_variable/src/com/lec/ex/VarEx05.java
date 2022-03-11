package com.lec.ex;

public class VarEx05 {

	public static void main(String[] args) {
		
		float f1, f2,f3;
		double f4, f5;
		
		f1 = 10.1f;
		f2 = 100.1f;
		System.out.println("f1 = "+f1+ "\nf2 = "+f2);
		f3 = 10.00000017f;
		System.out.println(f3);  // float의 범위초과
		
		f4 = 10.000000017;
		System.out.println("f4 = " + f4);
		
		f1 =  10.1f;
		f5 = 10.1;
		if (f1 == f5)
			System.out.println("f1과 f5는 같다");
		else
			System.out.println("f1과 f5는 같지 않다.");
		
		


	}

}
