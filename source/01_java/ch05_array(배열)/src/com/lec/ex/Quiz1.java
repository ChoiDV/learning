package com.lec.ex;

public class Quiz1 {

	public static void main(String[] args) {
		int[] arr = { 10, 20, 30, 40, 50 };
		int sum = 0;

		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		// for(int temp : arr) {
		//      sum += temp;
		//  }   // 확장 for문 사용해서 합 구하기.

		System.out.println(sum);
	}

}
