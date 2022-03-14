package com.lec.condition_조건문;

public class Quiz2 {

	public static void main(String[] args) {
		
		int num1 = 27;
		int num2 = 32;
		int max;
		
		if(num1 > num2 ) {   // if 문 안의 {} 안에서 선언된 변수는 그 블럭 안에서만 효용가치가 있다.
			max = num1;		 // 그래서 if문 밖에서 max를 선언해주고 안에서는 이미 선언된 max를 이용해서 값을 넣고 출력한다.
		} else {
			max = num2;
		}
		System.out.println(max);

	}

}
