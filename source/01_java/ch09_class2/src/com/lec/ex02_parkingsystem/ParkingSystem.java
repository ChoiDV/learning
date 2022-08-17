package com.lec.ex02_parkingsystem;

import java.util.Scanner;

import cons.Constant;

public class ParkingSystem {
	/*
	 * 다음과 같은 결과가 나오도록 클래스를 정의하고 객체를 생성하도록 프로그램을 구현하세요. 주차장 들어올 때 결과 : "11라1111"님
	 * 어서오세요 입차시간 : 12시 주차장 나갈 때 결과 : "11라1111"님 안녕히 가세요
	 *
	 * 입차시간 : 12시 출차시간 : 14시 주차요금 : 3000원
	 */
	// 훗날 데이터베이스 연동을 위해 항상 받은값들 계속 데이터에 넣어주기
	// ex)  inTime 받으면  this.inTime = inTime; 해서 기본데이터에 넣어주기.
	private String carNum; // 차 번호
	private int inTime; // 입차시간
	private int outTime; // 출차시간   
	//private final int HOURLYPARKINGRATE = 3000; // 시간당 주차요금   // final변수(바꿀수없는 상수) 같은 상수는 변수명을 대문자
	// 이제 static을 배웠으니 상수만을 위한 폴더들을 모아놓는 클래스로 옮기기. (static,final 사용하기)
	
	// final 안쓰고 주차요금을 인상하거나 인하 하는 메소드 만들어도 될듯.
	private int parkingTime; // 주차한 시간

	public ParkingSystem() {
	}

	public ParkingSystem(String carNum, int inTime) {
		this.carNum = carNum;
		if ((inTime >= 0) && (inTime <= 24)) {
			this.inTime = inTime;
			System.out.println(carNum + " 님 어서오세요!");
			System.out.println("입차 시간 : " + inTime + " 시.\n");
		} else {
			System.out.println("오류");
		}
	}

//	public int outCar(int outTime) {   // 주차시간
//		return parkingTime  = this.inTime-outTime;			
//	}
	public void outCar(int outTime) { // 출차,요금 정산
		this.outTime = outTime;
		this.parkingTime = outTime - inTime;
		System.out.println(carNum + " 님의 주차시간은 : " + parkingTime + " 시간 입니다.");
		System.out.println("주차 요금은 : " + (parkingTime * Constant.HOURLYPARKINGRATE) + " 원 입니다.");
		System.out.println("안녕히 가세요.\n");
	}

	public void outCar() { // 사용자로부터 outTime 받기
		Scanner sc = new Scanner(System.in);
		System.out.print("출차 시간을 알려주세요 : ");
		this.outTime = sc.nextInt();
		this.parkingTime = outTime - inTime;
		System.out.println(carNum + " 님의 주차시간은 : " + parkingTime + " 시간 입니다.");
		System.out.println("주차 요금은 : " + (parkingTime * Constant.HOURLYPARKINGRATE) + " 원 입니다.");
		System.out.println("안녕히 가세요.\n");
		sc.close();
		
	}
	
	

}
