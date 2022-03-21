package com.lec.ex04_abc;

public class TestMain {

	public static void main(String[] args) {
		S s = new S();		
		S a = new A(); // 객체는 A지만 변수의 타입은 S가 가능함 상속해서
		
		S b = new B();   // 변수가 S타입인 B객체           
		S c = new C();
// 거꾸로는 안됌. 교안 동물 생물 논리 읽어보면 이해가능.
		
//        생물               		일반화
//	      ↗         ↖             ↑ 
//	   동물	           식물         
//  ↗   ↗    ↖    ↖          ↓   
//조류  포유류  어류  양서류           		 특수화

		S[] arr = {s,a,b,c}; // 타입을 통일시켜서 배열에 넣을수 있음  근데 배열에 넣는건 쓸모없지만 패턴때문에 사용함
		
		for(S obj : arr) {
			System.out.println(obj.s);
		}
		
		
		
		

	}

}
