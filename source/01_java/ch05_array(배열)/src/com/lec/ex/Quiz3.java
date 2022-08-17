package com.lec.ex;

public class Quiz3 {

	public static void main(String[] args) {
		// 76,45,34,89,100,50,90,92
		// 8개의 값을 1차원 배열로 초기화 하고 값에 합계와 평균 그리고 최대값과 최소값을 구하는 프로그램을 작성 하시요.
		int[] arr = { 76, 45, 34, 89, 100, 50, 90, 92 };

		int sum = 0; // 합계
		int maximum = arr[0]; // 최대값
		int minimum = arr[0]; // 최소값

		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];    // 합계 구하기
		}
		double average = (sum / arr.length); // 평균 구하기

		for (int j = 0; j < arr.length; j++) {
			if (arr[j] > maximum) {
				maximum = arr[j];           // 최대값 구하기
			}
			if (arr[j] < minimum) {
				minimum = arr[j];           // 최소값 구하기
			}
		}

		System.out.println("합계는 : " + sum + "\t" + "평 균 = " + average);
		System.out.println("최대값은 : " + maximum + "\t" + "최소값은 : " + minimum);

	}

}
