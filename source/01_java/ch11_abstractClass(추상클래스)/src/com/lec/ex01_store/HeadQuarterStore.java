package com.lec.ex01_store;
// 추상메소드는 객체 생성이 불가
// public HeadQuarterStore store = new HeadQuarterStore(store); 이 불가 객체 생성 불가!!!!!!!!
public abstract class HeadQuarterStore { // abstract 가 추상클래스로 만들어주는 것.
	private String store; // 매장

	public HeadQuarterStore(String store) {
		this.store = store;
	}

	public void print() {
		System.out.println(store);
	}

	// 클래스 내 추상 메소드가 하나 이상일때 : 그 클래스를 추상 클래스 라고 함.
	public abstract void kimchi(); // 메소드 구현은 없고 선언만 되어 있는 메소드 : 추상 메소드(상속 받은 클래스에서 오버라이드 꼭 해줘야함)

	public abstract void bude();

	public abstract void bibim();

	public abstract void sunde();

	public abstract void gonggibab();

	public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}

}
