package com.lec.ex;

public class Car {
	// class : 데이터(속성, 인스턴스 변수)와 메소드(기능 , setter , getter)
	private String color;  // 색상
	private int cc;		   // 배기량
	private int speed;	   //  속도
	// 기본 데이터는 프라이빗으로해서 보안을 위해 비공개로 하고 대신 밑에 setSpeed 와 getSpeed를 만들어서
	// 그것으로 세팅을 하고 불러올수있도록 만드는것이다.
	
	public void drive() {
		speed = 60;
		
		System.out.println(color + " 색 차를 운전한다. 지금 속도는 : " + speed);
	}
	public void park() {
		speed = 0;
		System.out.println(color + " 색 차를 주차한다. 지금 속도는 : " + speed);
	}
	
	public void race() {
		speed = 120;
		System.out.println(color + " 색 차를 운전한다. 지금 속도는 : " + speed);
	}
	// 여기서 private 메소드를 만든다면 위의 다른메소드에서만 사용할수있다.
	// ex) private void park() {..} 을 만들면 park는 race나 drive의 안에서는 쓸수있다.
	
	// setter & getter (color, cc, speed)    
	public void setColor(String color) {
		this.color = color;
	}
	public void setCc(int cc) {
		this.cc = cc;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public String getColor() {
		return color;
	}
	public int getCc() {
		return cc;
	}
	public int getSpeed() {
		return speed;
	}
	
	
	

}