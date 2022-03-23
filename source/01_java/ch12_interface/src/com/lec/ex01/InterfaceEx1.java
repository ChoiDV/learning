package com.lec.ex01;
// 상수(final 변수), 추상메소드 밖에 못들어옴
// 상수는 무조건 static final 근데 안적어도 알아서 static final로 인식함
// 객체 생성이 불가하기 때문에 외부에서 액세스 불가 그래서 자료형은 public으로 private 금지
public interface InterfaceEx1 {
	public static final int CONSTANT_NUM = 10;
//  public int CONSTANT_NUM = 10; 과 같다.
	
	public /* abstract */ void method1();  // 추상 메소드만 사용할수 있음
	// 추상 메소드만 사용가능해서 abstract 사용 안해도됌
	
	
	
	
}
