package com.lec.condition_조건문;

import java.util.Scanner;

public class Ex04_switch_학점 {

	public static void main(String[] args) {
		// Ex04_if_학점 switch 문 사용해서 하기
		
		Scanner sc = new Scanner(System.in);
		System.out.print("점수를 입력하세요 : ");
		int score = sc.nextInt();
		int temp = score ==100? score-1 : score;
		temp = ((-9<=temp) && (temp <0))? -10 : temp;
		
		switch (temp / 10) {
		case 9: System.out.println("A 학점 "); 	break;		
		case 8: System.out.println("B 학점 ");	break;
		case 7: System.out.println("C 학점 ");	break;
		case 6: System.out.println("D 학점 ");    break;
		case 5: case 4: case 3: case 2: case 1: case 0:
			System.out.println("F 학점 ");  	break;
		default :
			System.out.println("유효하지 않은 점수 입니다.");
		}
	

}

}
