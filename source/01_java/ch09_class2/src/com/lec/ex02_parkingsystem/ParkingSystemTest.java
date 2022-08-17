package com.lec.ex02_parkingsystem;

public class ParkingSystemTest {

	public static void main(String[] args) {

		ParkingSystem tb = new ParkingSystem("173구2265", 12);
		tb.outCar(15);
		ParkingSystem ps = new ParkingSystem("222두2222", 10);
		tb.outCar(); // 사용자에게 시간을 받기
		ParkingSystem st = new ParkingSystem("336소1690", 9);
		st.outCar(23); // outTime은 23로 받기

		ParkingSystem rs = new ParkingSystem("11야", 25);

	}

}
