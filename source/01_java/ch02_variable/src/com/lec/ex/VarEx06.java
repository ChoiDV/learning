package com.lec.ex;

public class VarEx06 {

	public static void main(String[] args) {
		
		int i1 = 10;  			// 4byte
		long l = 2200000000L;	// 8byte
		
		double d1 = 10;  // 8byte = 4byte   묵시적인 형변환  =  작은값을 큰값에 넣는것이고 데이터  손실이 전혀 일어나지않음
		System.out.println("d1 = "+ d1);   // 형변환이 됐음.
		
		
		
		double d2 = 10.19;   
		int i2 = (int)d2;    
			// 명시적인 형변환   	=	4byte = 8byte  작은값에 큰값을 넣으려고 하면 데이터 손실이 발생함 
		System.out.println("i2 = " + i2);
		
		
		
		
		
		
		
		

	}

}
