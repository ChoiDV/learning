package com.lec.ex;

public class VarEx02 {

	public static void main(String[] args) {
		
		int i = 10;  // 4byte짜리 i라는 메모리공간에 10을 할당한다.
		byte j = 10; // 2byte짜리 j라는 메모리공간에 10을 할당한다.
		double h = 10.15;  //8byte짜리 h라는 메모리공간에 10.15를 할당한다.
		
		i = 5;
		System.out.println("i = " + i + "\t j=" + j + "\t h=" +h);
		
		char c1 = 'A';
		char c2 = 'B';
		
		System.out.print("c1= " + c1+ "\t c2= " + c2 + "\n");
		
		System.out.printf("c1=%c \t c2=%c \n", c1,c2);		
		// %c 는 문자    %d 는 정수  %f 는 실수  %s 는 문자열 
		
		System.out.printf("i=%d, j=%d , h=%4.2f \n", i,j,h);
		//  %n.mf  n은 총 자리수  m은 원하는 자리수 
		// 즉 총 4자리중에서 둘째 자리까지만 표시 이때는 셋째자리에서 자동으로 반올림
		
		
		
		System.out.println("끝");
		
		// printf(); 콘솔창에 특정 포맷으로 출력 (개행 미포함 ( 줄바꿈 없음))
		
		
		
		
		
		
		
		
		
	}
}
