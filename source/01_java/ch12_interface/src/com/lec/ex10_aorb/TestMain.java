package com.lec.ex10_aorb;

public class TestMain {

	public static void main(String[] args) {
		A a = new A();
		B b = new B();
		// 인터페이스   부품을 갈아끼울때  그 규격에 맞는 부품으로 갈아껴야함  규격이 안맞으면 갈아끼지 못하는데
		// 그래서  인터페이스가 그 규격을 정해준다고 생각하면 될듯.
		// User 가보면 매개변수로 인터페이스 타입을 받는다. 그래서 갈아끼우려면 I를 구현한 애들만 들어올수있는것이다.
		
		User user = new User();
		//user.use(a);
		user.use(b);
	}

}
