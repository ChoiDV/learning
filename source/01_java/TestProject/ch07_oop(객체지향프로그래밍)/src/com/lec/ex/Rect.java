package com.lec.ex;
// 무조건 클래스에는 1. 데이터(private 즉 외부에서 건들지못하게 private로 만들고) -width/height
//  , 		   2.메소드(외부에서 실행할수있게 public) -area()
// 				3.setter&getter(private인 기본 데이터에 새로운 값들을 넣기위해서) 가 들어가야한다.
public class Rect {
	// 기본 데이터형
	private int width; // 가로
	private int height; // 세로 
	
	public int area() {
		return (width * height);
	}
	// setter
	public void setWidth(int width) {
		this.width = width;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	// getter
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
}
