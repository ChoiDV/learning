package com.lec.ex;

public class CarTestMain {

	public static void main(String[] args) {
		// 붕어빵틀과 붕어빵 생각하면됌.

		Car myPorsche = new Car();

		// myPorsche.color = "빨강" 이제 이런식으로 설정 못함 왜?
		// color는 private이기 때문에 getColor 와 setColor를 이용해야함.
		myPorsche.setColor("빨강");
		myPorsche.setCc(3000);
		myPorsche.setSpeed(150);

		System.out.println(
		myPorsche.getColor() + " 색 자동차" + " " + "배기량 : " + myPorsche.getCc() + " 속도 : " + myPorsche.getSpeed());

		myPorsche.drive();
		myPorsche.park();
		myPorsche.race();

		myPorsche.setSpeed(100);
		System.out.println(myPorsche.getSpeed());

		Car yourPorsche = new Car();
		yourPorsche.setColor("검정");
		yourPorsche.drive();
		yourPorsche.park();
		yourPorsche.race();

	}

}
