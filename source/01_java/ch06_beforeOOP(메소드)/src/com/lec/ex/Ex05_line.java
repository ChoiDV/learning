package com.lec.ex;

/* -------------- 두꺼운라인
 * Hello, World!
 * --------------
 * Hello, Java!
 * ~~~~~~~~~~~~~~
 * Hello, Hone!
 * -------------- 두꺼운라인  
 */
		
		// void = return 타입이 없고 매개변수도 없는 메소드(함수)

	
public class Ex05_line {
	private static void printLine() {
		for (int i=0; i <30; i++) {
			System.out.print('-');
		}	
		System.out.println();  // 얇은 '-' 30 개 출력하고 개행
	}
	private static void printLine(char c) {  // 함수 오버로딩(같은이름의 함수를 매개변수로 구분한다.)
		for (int i=0; i <30; i++) {
			System.out.print(c);
		}	
		System.out.println();  // 매개변수로 받은 c문자를 30개 출력하고 개행
	}
	private static void printLine(int cnt) {
		for (int i=0; i < cnt; i++) {
			System.out.print('-');
		}	
		System.out.println();
	}
	private static void printLine(char c, int cnt) {
		for (int i=0; i < cnt; i++) {
			System.out.print(c);
		}	
		System.out.println();
	}
	
	
	public static void main(String[] args) {
		printLine('■',50);
		System.out.println("\tHello, World!");
		printLine(40);
		System.out.println("\tHello, Java!");
		printLine('~');
		System.out.println("\tHello, Hong!");
		printLine();
	}
	
}
