package com.lec.ex;

public class Ex06_multiDimensional {

	public static void main(String[] args) {
		// 2차원 배열
		// 근데 주로 사용하지않음.
		int[] arr = { 1, 2, 3 };
		int[][] test = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		System.out.println(arr[2]); // 1차원 배열
		System.out.println(test[2][2]); // 2차원 배열 2행2열

		for (int i = 0; i < test.length; i++) {
			for (int j = 0; j < test[0].length; j++) {
				System.out.printf("test[%d][%d] = %d\n", i, j, test[i][j]);
			}
		}

	}
}
