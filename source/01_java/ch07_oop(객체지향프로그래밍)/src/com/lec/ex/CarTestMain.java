package com.lec.ex;

public class CarTestMain {

	public static void main(String[] args) {
		// �ؾƲ�� �ؾ �����ϸ��.

		Car myPorsche = new Car();

		// myPorsche.color = "����" ���� �̷������� ���� ���� ��?
		// color�� private�̱� ������ getColor �� setColor�� �̿��ؾ���.
		myPorsche.setColor("����");
		myPorsche.setCc(3000);
		myPorsche.setSpeed(150);

		System.out.println(
		myPorsche.getColor() + " �� �ڵ���" + " " + "��ⷮ : " + myPorsche.getCc() + " �ӵ� : " + myPorsche.getSpeed());

		myPorsche.drive();
		myPorsche.park();
		myPorsche.race();

		myPorsche.setSpeed(100);
		System.out.println(myPorsche.getSpeed());

		Car yourPorsche = new Car();
		yourPorsche.setColor("����");
		yourPorsche.drive();
		yourPorsche.park();
		yourPorsche.race();

	}

}
