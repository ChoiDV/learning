package com.lec.ex04_car;

import com.lec.cons.CarSpec;

public class TestMain {

	public static void main(String[] args) {
		// �տ� Ÿ���� �ִ��� �θ�Ŭ������ �ϴ°� ���� ���������� ����.
		Car car1 = new LowGradeCar(CarSpec.BLACK_CAR, CarSpec.TIRE_NORMAL, CarSpec.DISPLACEMENT_1000,
											CarSpec.HANDDLE_POWER);
		car1.getSpec();
		Car car2 = new HighGradeCar(CarSpec.WHITE_CAR,CarSpec.TIRE_WIDE,
										CarSpec.DISPLACEMENT_2200,CarSpec.HANDDLE_POWER);
		car2.getSpec();
	}
}
