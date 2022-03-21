package com.lec.ex02_protectedmember;
// 클래스 만들때
// 데이터 - 생성자 - 메소드 - 오버라이드 메소드 - setter&getter  순서대로 만들어야함.
public class SuperIJ {
	private int i;
	private int j;
	// 상속받은 클래스에서 Super 클래스(부모단) 생성자 함수를 먼저 호출
	public SuperIJ() {
		System.out.println("매개변수 없는 SuperIJ 생성자 함수");
	}
	public SuperIJ(int i, int j) {
		this.i = i;
		this.j = j;
		System.out.println("매개변수 있는 SuperIJ 생성자 함수로 i, j값 초기화");		
	}
	// setter&getter
	protected void setI(int i) {
		this.i = i;
	}
	protected int getJ() {
		return j;
	}
	public void setJ(int j) {
		this.j = j;
	}
	protected int getI() {
		return i;
	}
	
	
}
