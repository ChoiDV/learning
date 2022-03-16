package com.lec.ex2_human;

public class Man {
	private int age; // ����
	private int height; // Ű
	private double weight; // ������
	private String phoneNum; // �ڵ��� ��ȣ

	// �Ű����� �ִ� ������ �Լ� �뵵 : ������ �ʱ�ȭ
	// �� ���⿡ �������� �־ �ϳ��ϳ� setter,getter �����ʿ���� �ѹ��� �����ϸ鼭 �ʱ�ȭ���� �Ϸ���
	// �̰� �����.
	public Man() {} // ����Ʈ ������ �Լ� ������ �ڵ����� ����������� �������
					// �Ű������� �ִ� ������ �Լ��� ������⶧���� ����������.
	
	// �޼ҵ尡 �̸��� �ߺ��� ���������� �Ű������� �ߺ��� �ɼ�����
	// ex) Man �Լ��� �Ű������� int age, �Ǵٸ� Man �Լ��� �Ű������� int height �� �ȵȴٴ¼Ҹ�.
	// Ȥ�ö� �Ϸ��� 
//	public Man(int age) {
//		if(age < 100) {
//			this.age = age;
//		} else {
//			height = age;
//		}
//	}
	public Man(int age) {  
		this.age = age;
		System.out.println("�Ķ���Ͱ� 1��¥�� ������ �Լ� ȣ��. ");
	}
	
	public Man(int age, int height, double weight) {
		this.age = age;
		this.height = height;
		this.weight = weight;
		System.out.println("�ĸ����Ͱ� 3��¥�� ������ �Լ� ȣ��. ");
	}

	public Man(int age, int height, double weight, String phoneNum) {
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.phoneNum = phoneNum;
		System.out.println("�Ķ���Ͱ� 4��¥�� ������ �Լ� ȣ��. ");

	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	
	
}
