package com.lec.ex;

// 1~10까지 정수의 합을 출력하고 그 합이 짝수인지 홀수인지 출력하기.
public class Ex02 {
	private static int sum(int from, int to) { // from ~ to 까지 누적한 결과 return
		int result = 0;						  // 얘는 수를 두개 받아야 실행하는 메소드 
		for (int i = from; i <= to; i++) {
			result += i; // result = result +i;
		}
		return result; // 메소드 정의 메소드 = 함수
	}
	// 같은이름의 함수를 두개이상 만드는것이 함수의 오버로딩이라고 함.
	// 이것이 자바의 장점중에 하나.
	
	private static int sum(int to) { // 수를 하나만 받아도 알아서 1부터 to까지 계산하는 메소드
		int result = 0;
		for (int i = 1; i <= to; i++) {
			result += i; // result = result +i;
		}
		return result;
	}

	private static String evenOdd(int value) {
		// 삼항연산자 사용하면 return value%2==0 ? "짝수입니다." : "홀수입니다.";
		String result;
		if (value % 2 == 0) {
			result = "짝수입니다. ";
		} else {
			result = "홀수입니다. ";
		}
		return result;

	}

	public static void main(String[] args) {
		// sum 함수와 evenOdd 함수 호출해서 사용하기.
		int tot = sum(1, 10); // sum(int,int) 메소드를 사용한것
		System.out.println("1~10까지 누적합은 : " + tot);
		System.out.println(evenOdd(tot));

		tot = sum(10, 100); // sum(int,int) 메소드를 사용한것
		System.out.println("10~100까지 누적합은 : " + tot);
		System.out.println(evenOdd(tot));
		
		tot = sum(50); // sum(int) 메소드를 사용한것
		System.out.println("1부터 50까지의 누적합은 : " +tot);

	}

	// 5번줄의 private 는 공개범위
	// int 는 sum 함수의 리턴값의 자료형을 써주면 됨.

}
