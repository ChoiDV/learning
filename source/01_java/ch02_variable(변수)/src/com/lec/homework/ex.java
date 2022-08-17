package com.lec.homework;

public class ex {

	// 국어, 영어, 수학 점수를 변수에 할당하고 각 점수를 출력하고 총점, 평균 출력하는 프로그램을 구현 하시오
	// (com.lec.ex패키지내에 작성한 Example.java를 yisy0703@naver.com으로 메일 발송 하시오).
	public static void main(String[] args) {
		
		int korean = 100;
		int english = 100;
		int math = 100;
		
		
		System.out.println("국어 점수 = " + korean  + "점");
		System.out.println("영어 점수 = " + english + "점");
		System.out.println("수학 점수 = " + math + "점");
		
		int sum = korean + english + math;    // 총점  
		
		double average = (sum/3.0); 		 	  // 평균 
		
		System.out.println("국어,영어,수학의 총점 = "+sum + "점");
		System.out.println("국어,영어,수학의 평균 = " +average + "점");
		
		

	}

}
