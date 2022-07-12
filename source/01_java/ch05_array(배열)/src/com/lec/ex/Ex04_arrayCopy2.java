package com.lec.ex;
// API 를 이용한 배열 복사   System.arraycopy(원본 배열, 원본시작 index, 복사본배열, 복사본시작 index, 배열방의개수)
public class Ex04_arrayCopy2 {

	public static void main(String[] args) {
		
			
		int[] score = {100,10,20,30,40};	
		int[] s = new int[score.length];
		
		
		System.arraycopy(score, 0, s, 0, score.length);   // 배열 복사. 
		
		s[0] = 999;
		for (int idx=0; idx<score.length ; idx++) {
			System.out.printf("score[%d]=%d\t s[%d]=%d\n", idx, score[idx],idx,s[idx]);
		}
	}

}
