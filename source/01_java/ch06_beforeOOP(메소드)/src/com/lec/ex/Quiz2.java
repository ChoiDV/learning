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
		System.out.print("���� �Է��ϼ��� : ");
		int value = sc.nextInt();
		
		System.out.println(value +" �� ���밪�� : " + abs(value));
	}

}
