package com.lec.ex02_parkingsystem;

import java.util.Scanner;

import cons.Constant;

public class ParkingSystem {
	/*
	 * ������ ���� ����� �������� Ŭ������ �����ϰ� ��ü�� �����ϵ��� ���α׷��� �����ϼ���. ������ ���� �� ��� : "11��1111"��
	 * ������� �����ð� : 12�� ������ ���� �� ��� : "11��1111"�� �ȳ��� ������
	 *
	 * �����ð� : 12�� �����ð� : 14�� ������� : 3000��
	 */
	// �ʳ� �����ͺ��̽� ������ ���� �׻� �������� ��� �����Ϳ� �־��ֱ�
	// ex)  inTime ������  this.inTime = inTime; �ؼ� �⺻�����Ϳ� �־��ֱ�.
	private String carNum; // �� ��ȣ
	private int inTime; // �����ð�
	private int outTime; // �����ð�   
	//private final int HOURLYPARKINGRATE = 3000; // �ð��� �������   // final����(�ٲܼ����� ���) ���� ����� �������� �빮��
	// ���� static�� ������� ������� ���� �������� ��Ƴ��� Ŭ������ �ű��. (static,final ����ϱ�)
	
	// final �Ⱦ��� ��������� �λ��ϰų� ���� �ϴ� �޼ҵ� ���� �ɵ�.
	private int parkingTime; // ������ �ð�

	public ParkingSystem() {
	}

	public ParkingSystem(String carNum, int inTime) {
		this.carNum = carNum;
		if ((inTime >= 0) && (inTime <= 24)) {
			this.inTime = inTime;
			System.out.println(carNum + " �� �������!");
			System.out.println("���� �ð� : " + inTime + " ��.\n");
		} else {
			System.out.println("����");
		}
	}

//	public int outCar(int outTime) {   // �����ð�
//		return parkingTime  = this.inTime-outTime;			
//	}
	public void outCar(int outTime) { // ����,��� ����
		this.outTime = outTime;
		this.parkingTime = outTime - inTime;
		System.out.println(carNum + " ���� �����ð��� : " + parkingTime + " �ð� �Դϴ�.");
		System.out.println("���� ����� : " + (parkingTime * Constant.HOURLYPARKINGRATE) + " �� �Դϴ�.");
		System.out.println("�ȳ��� ������.\n");
	}

	public void outCar() { // ����ڷκ��� outTime �ޱ�
		Scanner sc = new Scanner(System.in);
		System.out.print("���� �ð��� �˷��ּ��� : ");
		this.outTime = sc.nextInt();
		this.parkingTime = outTime - inTime;
		System.out.println(carNum + " ���� �����ð��� : " + parkingTime + " �ð� �Դϴ�.");
		System.out.println("���� ����� : " + (parkingTime * Constant.HOURLYPARKINGRATE) + " �� �Դϴ�.");
		System.out.println("�ȳ��� ������.\n");
		sc.close();
		
	}
	
	

}
