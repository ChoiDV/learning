package com.lec.ex;

public class Quiz3 {

	public static void main(String[] args) {
		// 76,45,34,89,100,50,90,92
		// 8���� ���� 1���� �迭�� �ʱ�ȭ �ϰ� ���� �հ�� ��� �׸��� �ִ밪�� �ּҰ��� ���ϴ� ���α׷��� �ۼ� �Ͻÿ�.
		int[] arr = { 76, 45, 34, 89, 100, 50, 90, 92 };

		int sum = 0; // �հ�
		int maximum = arr[0]; // �ִ밪
		int minimum = arr[0]; // �ּҰ�

		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];    // �հ� ���ϱ�
		}
		double average = (sum / arr.length); // ��� ���ϱ�

		for (int j = 0; j < arr.length; j++) {
			if (arr[j] > maximum) {
				maximum = arr[j];           // �ִ밪 ���ϱ�
			}
			if (arr[j] < minimum) {
				minimum = arr[j];           // �ּҰ� ���ϱ�
			}
		}

		System.out.println("�հ�� : " + sum + "\t" + "�� �� = " + average);
		System.out.println("�ִ밪�� : " + maximum + "\t" + "�ּҰ��� : " + minimum);

	}

}
