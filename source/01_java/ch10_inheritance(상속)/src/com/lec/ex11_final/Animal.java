package com.lec.ex11_final;

public class Animal {
	private int speed;
	
	public void running() {
		speed += 5;
		System.out.println("뛰고 있어요. 현재 속도 : "+ speed);
	}
	public final void stop() {  // Override 금지 메소드  final 붙혀서
		speed = 0;
		System.out.println("멈춤. 현재 속도 : "+ speed);
	}
	
	// setter & getter
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
}
