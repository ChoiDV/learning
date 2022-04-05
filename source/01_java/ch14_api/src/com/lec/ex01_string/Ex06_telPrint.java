package com.lec.ex01_string;

import java.util.Scanner;

// 전화번호 받아, 입력받은 전화번호, 짝수번째 문자, 거꾸로, 전화번호 앞자리, 전화번호 뒷자리
public class Ex06_telPrint {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		do {
		System.out.print("전화번호를 입력하세요(010-4434-9878 형식) : ");
		String tel = sc.next();
		if(tel.equalsIgnoreCase("x")) break;
		System.out.println("입력한 전화번호 :"+ tel);
		System.out.print("짝수번째 문자열 : ");
		
		for(int i=0; i < tel.length(); i++ ) {
			if(i%2 ==0) {
				System.out.print(tel.charAt(i));  // 짝수번째 문자 출력
			} else {
				System.out.print(" ");  // 홀수번째 문자열 대신 ' '출력 
			}
		}
		System.out.println();  // 가독성 위해 개행
		
		System.out.print("전화번호를 거꾸로 : ");
		// 거꾸로 출력하기
		for(int i =tel.length()-1; i>=0; i--) {
			System.out.print(tel.charAt(i));
		}	
		
		System.out.println();
		//010-4434-9878
		int first = tel.indexOf('-');   // 첫번째 -가 나오는 위치   3 
		int last = tel.lastIndexOf('-'); // 마지막 -가 나오는 위치   8
		
		String pre = tel.substring(0, tel.indexOf('-'));
		String post = tel.substring(tel.lastIndexOf('-')+1);
		String mid = tel.substring(first+1,last);
		// 첫번째 -가 나오는 위치부터 마지막 -가 나오는위치 전까지
		
		System.out.println("전화번호 앞자리 : "+ pre);
		System.out.println("전화번호 중간 자리 : "+ mid);
		System.out.println("전화번호 뒷자리 : "+ post);
		}while(true);
		
		

	}
}
