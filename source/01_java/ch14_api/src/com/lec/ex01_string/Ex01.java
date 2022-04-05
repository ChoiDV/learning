package com.lec.ex01_string;

import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		int i = 10;
		String str1 = "Java";
		String str2 = "Java";
		// String은 new로 생성하지 않고 " " 를 사용한 문자열 상수를 이용. 자동으로 힙 메모리영역에 String 객체가 이미 존재하는지 확인하고
		// 만약에 이미 존재하는 문자열이면 객체를 공유.  이전에 있던것과 같은것을 가리키고 같은 주소값을 가짐
		// new를 사용해서 만들면 둘이 다름
		// 존재하지않으면 String 객체 생성
		
		String str3 = new String("Java");
		Scanner sc = new Scanner(System.in);
		
		if(str1==str2) {
			System.out.println("str1과 str2는 같은 주소값이 있음");
		} else {
			System.out.println("str1과 str2는 다른 주소값이 있음");
		}
			
		if(str1.equals(str2)) {
			System.out.println("같은 문자열");
		} 
		System.out.println(str1 == str3 ? "str1과3은 같은 주소" : " str1과3은 다른주소값");
		System.out.println(str1.equals(str3)? "같은 문자열" : "다른 문자열");
		
		
	}
}
