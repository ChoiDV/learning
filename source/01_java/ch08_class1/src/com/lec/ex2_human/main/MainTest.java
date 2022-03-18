package com.lec.ex2_human.main;

import com.lec.ex2_human.Man;
import com.lec.ex2_human.Woman;

//  import 에서 * 는 com.lec.ex2_human 밑에있는 모든것을 임포트한다는 뜻.

public class MainTest {

// com.lec.ex2_human 과  com.lec.ex2_human.main 패키지가 같은 패키지 인가 테스트하는중.
// import 필요없이 생성되면 같은패키지 
// import가 필요하면 다른 패키지라고 생각
	
// 즉 다른패키지 이다.

	public static void main(String[] args) {
		
		// 기초 데이터 타입
		int i = 10;
		int j = 10;
		// 기초데이터 타입에서의 같은지 다른지 비교하는방법.
		//System.out.println((i==j)? "같다" : "다르다");
		if(i==j) {
			System.out.println("i와 j는 같다.");
		}
		
		// 객체데이터 타입
		String name = "홍길동";      
		String name2 = "홍길동";
		//System.out.println((name==name2) ? "같다" : "다르다");
		//같은 이유는 메모리절약 때문에?  객체변수인데 String만 같다고 인식함 
		if(name.equals(name2)) {
			System.out.println("name과 name2는 같다");
		}
		
		Woman choi = new Woman();
		Woman choi2 = new Woman();
		// choi.method();
		if(choi.equals(choi2)) {  // 객체변수가 같은지 비교할때는 꼭  .equals 를 사용해야함 기본적으로 자바에서 제공하는 비교함수
			System.out.println("choi와 choi2는 같다.");
		} else {
			System.out.println("choi와 choi2는 다르다.");
		}
		
		
		Man park = new Man(22,165,60.2);
		Man park2 = new Man(22,185,80.2);
		Man park3;
		Man park4 = new Man(22,185,80.2);
		
		park3 = park2;
		if (park3.equals(park2)) {
			System.out.println("park3와 park2는 같다.(같은 주소를 가리킨다.)");			
		} else {
			System.out.println("park3와 park2는 다르다.");
		} // if 조건문 안에 !를 넣으면 값이 반대가 된다.
		// 원래는 false 지만 !를 넣으면 true 가 된다.
		if(park2.equals(park4)) {
			System.out.println("park2와 park4는 같다.");
		} else {
			System.out.println("park2와 park4는 다르다.");
		}
		
		park.setHeight(179);
		park.setWeight(78.5);  // 그냥 78넣어도 에러안남 이유는 : 묵시적인 형변환을 해줌 double형으로.	
		if(park.calculateBMI() > 30) {
			System.out.println("건강하세요");
		} else {
			System.out.println("건강하겠네요");
		}
		
		
		

	}

}
