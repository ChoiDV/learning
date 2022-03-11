package com.lec.ex;

public class Ex04 {

	public static void main(String[] args) {
		
		// 논리 연산자 : && (AND 연산) , || ( OR 연산자)
		
		// && 는 둘다 참일경우 참
		// || 는 하나만 참일경우 참
		
		int i = 1;
		int j = 10;
		int h = 10;
		
		boolean result = ( (i>j) && (++j>h));
		System.out.println("result= " + result + "\t j = " + j);
		System.out.println(result); // 앞에꺼는 false 뒤에꺼는 true  && 는 둘다 참일경우 참이니까 결과값은 false
									//  && 연산은 연산자 좌항이 false 일때는 우항을 실행 자체를 안한다.
		
		System.out.println();
		
		
		boolean result4 = ( (h==j) && (++j==h));   // 이것은 좌항이 참이라서 우항까지 실행을 시켰지만 결과값은 false이지만
		System.out.println(result4);			   //  j 값은 증가가해서 11이 나온다
		System.out.println("result= " + result4 + "\t j = " + j);
		
		System.out.println();		
		
		boolean result3 = ((i<j) || ( ++j>h));
		System.out.println("result= " + result3 + "\t j= " + j);
		System.out.println(result3);
		

	}

}
