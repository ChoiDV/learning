package com.lec.ex02_parkingsystem;

public class ParkingSystemTest {

	public static void main(String[] args) {

		ParkingSystem tb = new ParkingSystem("173��2265", 12);
		tb.outCar(15);
		ParkingSystem ps = new ParkingSystem("222��2222", 10);
		tb.outCar(); // ����ڿ��� �ð��� �ޱ�
		ParkingSystem st = new ParkingSystem("336��1690", 9);
		st.outCar(23); // outTime�� 23�� �ޱ�

		ParkingSystem rs = new ParkingSystem("11��", 25);

	}

}
