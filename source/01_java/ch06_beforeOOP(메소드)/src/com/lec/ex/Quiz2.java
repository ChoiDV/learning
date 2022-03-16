package com.lec.ex;

import java.util.Scanner;

public class Quiz2 {
	
	private static int abs(int value) {
		 //return value >=0 ? value : -value;
		int result;
		if(value >=0) {
			result = value;
		}else {
			result = -value;
		}
		return result;
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("수를 입력하세요 : ");
		int value = sc.nextInt();
		
		System.out.println(value +" 의 절대값은 : " + abs(value));
	}

}
