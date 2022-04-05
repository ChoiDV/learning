package com.lec.ex01_string;

public class Ex09_StringMemoeryWaste {
	public static void main(String[] args) {
		String str1 = "Hello";
		String str2 = "Hello";
		System.out.println(str1 == str2 ? "같은 주소" : "다른 주소");
		System.out.println("str1의 해쉬코드 : " +str1.hashCode()); // str1의 주소를 해쉬함수에 넣었다가 나오는 값을 불러오는 함수  .hashCode()
		System.out.println("str2의 해쉬코드 : " +str2.hashCode());
		str1 = "Hello~";
		System.out.println("변경된 str1의 해쉬코드 : "+ str1.hashCode());
		System.out.println(str1 == str2 ? "같은 주소" : "다른 주소");
		str1 = "Hello~~";
		System.out.println("변경(2)된 str1의 해쉬코드 : "+ str1.hashCode());
		str1 = "Hello~~~";
		System.out.println("변경(3)된 str1의 해쉬코드 : "+ str1.hashCode());
		
	}
}
