package com.lec.ex04_car;

import com.lec.cons.CarSpec;

public class TestMain {

	public static void main(String[] args) {
		// 앞에 타입은 최대한 부모클래스로 하는게 좋음 유지보수가 편함.
		Car car1 = new LowGradeCar(CarSpec.BLACK_CAR, CarSpec.TIRE_NORMAL, CarSpec.DISPLACEMENT_1000,
											CarSpec.HANDDLE_POWER);
		car1.getSpec();
		Car car2 = new HighGradeCar(CarSpec.WHITE_CAR,CarSpec.TIRE_WIDE,
										CarSpec.DISPLACEMENT_2200,CarSpec.HANDDLE_POWER);
		car2.getSpec();
	}
}
