package com.lec.ex;

public class Ex03_reference {

	public static void main(String[] args) {
		int i =10;
		int j =i;
		j= 99;
		System.out.printf("i=%d , j=%d\n",i,j);
		
		int[] score = {100,10,20,30,40};
		int[] s = score;       // 참조변수는 score값에 주소값이 들어가있기때문에 s 도 score랑 같은 주소값을 가져서
							   // s를 바꾸든 score를 바꾸든 주소값을 찾아가서 안에있는값을 바꾸기 때문에 
								// 결국은 둘은 계속 같은 값을 가지는것이다.
								// 그래서 둘이 다르게 하려면
								// int[] score = {1,2,3,4,5};
								// int[] s = new int[score.length]; 이런 방식으로 해야지 다른 주소를 갖는 같은 배열
		s[0]=99;
		for ( int idx =0; idx<score.length; idx++) {
			System.out.printf("score[%d] = %d\t s[%d] = %d\n", idx, score[idx],idx,s[idx]);
		}
		

	}

}
