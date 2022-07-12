package com.lec.ex06_override;
// ParentClass의 method1(), method2()를 상속받음

public class ChildClass extends ParentClass {

	public ChildClass() {
		System.out.println("매개 변수 없는 ChildClass 생성자");
	}

	public ChildClass(int i) { // 오버로딩
		System.out.println("매개 변수 있는 ChildClass 생성자");
	}

	public void method3() {
		System.out.println("ChildClass의 method3() 함수");
	}

	@Override
	public void method1() {  // ParentClass의 method1 오버라이드
			// 오버라이드는 매개변수 반환형 다 같아야함. 접근제한자도 작아질수는 없음
		// 즉 처음이 public이기때문에 public 써야함
		System.out.println("ChildClass의 method1() 함수");
	}
	@Override
	public boolean equals(Object obj) { // Object 클래스의 equals 오버라이드
		return true;
	}

}
