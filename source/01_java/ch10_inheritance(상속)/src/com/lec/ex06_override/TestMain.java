package com.lec.ex06_override;

public class TestMain {

	public static void main(String[] args) {
		ParentClass pObj1 = new ParentClass();
		ParentClass pObj2 = new ParentClass(1);
		if (pObj1.equals(pObj2)) {
			System.out.println("두 객체는 같다.");
		} else {
			System.out.println("두 객체는 다르다.");
		}

		ChildClass cObj = new ChildClass(2);

		if (cObj.equals(pObj2)) { // .equals 를 무조건 맞다고 정의해줌 ChildClass 에서
			System.out.println("무조건 true지");
		}

		pObj1.method1();
		pObj1.method2();
// 		pObj1.method3();  없으니 불가능
		System.out.println("--------------------------------------");
		cObj.method1(); // ChildClass의 method1 // 왜? ChildClass 에서 오버라이드 해줘서
		cObj.method2(); // ParentClass의 method2
		cObj.method3(); // ChildClass의 method3
		System.out.println("--------------------------------------");
		
		ParentClass cObj1 = new ChildClass(2);
		cObj1.method1(); // ChildClass의 method1 실행
		cObj1.method2(); // ParentClass의 method2 실행

		// 밑에줄 뜻이 cObj1 이 어디있는지 가봐서 ChildClass에 있으면 true 없으면 false 
		
		if (cObj1 instanceof ChildClass) { // ParentClass형 cObj1 변수를 ChildClass 형으로 변환 가능하니? 형변환 하기전에 이렇게 물어보는 if문 쓰기
			((ChildClass) cObj1).method3(); // 에러나는 이유 부모가 자식꺼를 쓸수 없어서 명시적인 형 변환을 해줘야함 .
		} else {
			System.out.println("형변환 안 됨.");
		}
	}

}
