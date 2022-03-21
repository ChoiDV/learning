package com.lec.ex03_point;

public class Point {
	private int x;
	private int y;
	
	// 오버로딩 (함수 중복정의)
	public Point() {	// 상속하고 받을때 매개변수 없는 생성자 함수 무조건 있어야함 안그러면 에러남.	
	}

	public Point(int x, int y) {		
		this.x = x;
		this.y = y;
	}
	// Point p = new Point(1,2);
	// p.pointPrint();                               1번
	// System.out.println(p.infoString());			 2번
	//  System.out.println(p); 						 3번	 // 이거 하기위해서 오버라이드 
	//  메소드 
	public void pointPrint() {
		System.out.println("2차원 좌표  : x =" +x+ ", y =" +y);
	}
	public String infoString() {
		return "2차원 좌표  : x =" +x+ ", y =" +y;
	}   // 2번을 하려고 이걸 만듬.
	
	@Override
	public String toString() {  // 오버라이드  (toString 함수 재정의) = 상속받은 함수의 매개변수, 리턴타입 동일하게
		return "2차원 좌표  : x =" +x+ ", y =" +y;		
	} 
	

	// setter&getter 
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	
	
}
