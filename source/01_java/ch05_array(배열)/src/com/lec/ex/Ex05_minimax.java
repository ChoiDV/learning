package com.lec.ex;

import java.util.Scanner;

// 사용자로부터 영희, 철수, 길동, 영수, 말자의 키를 입력받아, 평균 키를 출력 
// 최장신 친구이름과 키, 최단신 친구 이름과 키 출력
public class Ex05_minimax {

	public static void main(String[] args) {

		String[] arrName = { "영희", "철수", "길동", "영수", "말자" };
		int[] arrHeight = new int[arrName.length];

		Scanner sc = new Scanner(System.in);
		int totalHeight = 0; // 입력 받은 키 누적 변수

		for (int idx = 0; idx < arrName.length; idx++) {
			System.out.print(arrName[idx] + " 의 키를 입력하세요 : ");
			arrHeight[idx] = sc.nextInt();
			totalHeight += arrHeight[idx];
		}

		System.out.println("평균키는 " + (double) (totalHeight / arrName.length));
		// 명시적 형변환 double 형으로

		int maximum = arrHeight[0], maxindex=0;   // 가장 크고 작은값의 인덱스를 기억할 변수 maxindex,minindex .
		int minimum = arrHeight[0],  minindex=0;
		
		for (int i = 0; i < arrHeight.length; i++) {
			if (arrHeight[i] > maximum) {
				maximum = arrHeight[i];
				maxindex = i;
			}// if-maximum
		} // for-maximum
		
		System.out.println("가장 키가 큰 사람은 "+ arrName[maxindex]+  " 이고 키는 " + maximum);

		for (int i = 0; i < arrHeight.length; i++) {
			if (arrHeight[i] < minimum) {
				minimum = arrHeight[i];
				minindex = i;
			}// if -minimum
		}  // for- minimum
		
		System.out.println("가장 키가 작은 사람은 "+arrName[minindex] + " 이고 키는 " + minimum);
	} // main 
} // class
