package com.lec.ex;

public class Ex06_multiDimensional {

	public static void main(String[] args) {
		// 2���� �迭
		// �ٵ� �ַ� �����������.
		int[] arr = { 1, 2, 3 };
		int[][] test = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		System.out.println(arr[2]); // 1���� �迭
		System.out.println(test[2][2]); // 2���� �迭 2��2��

		for (int i = 0; i < test.length; i++) {
			for (int j = 0; j < test[0].length; j++) {
				System.out.printf("test[%d][%d] = %d\n", i, j, test[i][j]);
			}
		}

	}
}
