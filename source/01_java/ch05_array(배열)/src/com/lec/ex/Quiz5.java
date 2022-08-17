package com.lec.ex;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Quiz5 {

	public static void main(String[] args) {

		int[] arr = { 76, 45, 34, 89, 100, 50, 90, 92 };
		int[] sortArr = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {
			sortArr[i] = arr[i]; // arr이랑 sortArr이랑 같은 배열 만들기 하지만 서로 주소값은 다름.
		}
		// 오름차순 정렬 함수 : Arrays.sort(sortArr);
		// 직접 for문 이용해서 정렬하기 .
		for (int i = 0; i < sortArr.length; i++) { // i=0 ~7 까지
			for (int j = i + 1; j < sortArr.length; j++) { // j= i+1~7까지
				// i번째와 j번째 비교 해서 i번째가 크면 교환
				if (sortArr[i] > sortArr[j]) {
					int temp = sortArr[i];
					sortArr[i] = sortArr[j];
					sortArr[j] = temp;
				} // if - 교환

			} // for -j

		} // for -i
		System.out.print(" 원 데이터 : ");
		for (int temp : arr) {
			System.out.print(temp + " ");
		} // for- 원데이터 출력
		System.out.print("\n 오름차순 정렬 데이터 : ");
		for (int temp : sortArr) {
			System.out.print(temp + " ");
		} // for - 오름차순 정렬 데이터 출력
	} // main

} // class
