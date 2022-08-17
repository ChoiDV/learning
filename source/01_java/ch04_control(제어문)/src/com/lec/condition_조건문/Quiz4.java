package com.lec.condition_조건문;

import java.util.Scanner;

public class Quiz4 {

	public static void main(String[] args) {
		//가위바위보 중 하나를 내고 낸 것을 출력하세요
		// 가위 0 바위 1 보 2
		Scanner sc = new Scanner(System.in);
		System.out.print("가위(0) 바위(1) 보(2) 중 하나를 내세요 : ");
		int user = sc.nextInt();
		
		if (user == 0) {
			System.out.println("가위");
		} else if (user ==1) {
			System.out.println("바위");
		} else if (user ==2){
			System.out.println("보");
		} else {
			System.out.println("유효하지 않습니다.");
		}
		
		sc.close();
		
	}

}
