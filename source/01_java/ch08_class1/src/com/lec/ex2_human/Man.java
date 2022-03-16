package com.lec.ex2_human;

public class Man {
	private int age; // 나이
	private int height; // 키
	private double weight; // 몸무게
	private String phoneNum; // 핸드폰 번호

	// 매개변수 있는 생성자 함수 용도 : 데이터 초기화
	// 아 여기에 정보들을 넣어서 하나하나 setter,getter 해줄필요없이 한번에 생성하면서 초기화까지 하려고
	// 이거 사용함.
	public Man() {} // 디폴트 생성자 함수 원래는 자동으로 만들어주지만 요번에는
					// 매개변수가 있는 생성자 함수를 만들었기때문에 만들어줘야함.
	
	// 메소드가 이름은 중복이 가능하지만 매개변수는 중복이 될수없음
	// ex) Man 함수에 매개변수가 int age, 또다른 Man 함수의 매개변수에 int height 는 안된다는소리.
	// 혹시라도 하려면 
//	public Man(int age) {
//		if(age < 100) {
//			this.age = age;
//		} else {
//			height = age;
//		}
//	}
	public Man(int age) {  
		this.age = age;
		System.out.println("파라미터가 1개짜리 생성자 함수 호출. ");
	}
	
	public Man(int age, int height, double weight) {
		this.age = age;
		this.height = height;
		this.weight = weight;
		System.out.println("파마미터가 3개짜리 생성자 함수 호출. ");
	}

	public Man(int age, int height, double weight, String phoneNum) {
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.phoneNum = phoneNum;
		System.out.println("파라미터가 4개짜리 생성자 함수 호출. ");

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
