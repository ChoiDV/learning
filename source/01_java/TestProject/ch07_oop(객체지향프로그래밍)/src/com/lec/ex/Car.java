package com.lec.ex;

public class Car {
	// class : ������(�Ӽ�, �ν��Ͻ� ����)�� �޼ҵ�(��� , setter , getter)
	private String color;  // ����
	private int cc;		   // ��ⷮ
	private int speed;	   //  �ӵ�
	// �⺻ �����ʹ� �����̺������ؼ� ������ ���� ������� �ϰ� ��� �ؿ� setSpeed �� getSpeed�� ����
	// �װ����� ������ �ϰ� �ҷ��ü��ֵ��� ����°��̴�.
	
	public void drive() {
		speed = 60;
		
		System.out.println(color + " �� ���� �����Ѵ�. ���� �ӵ��� : " + speed);
	}
	public void park() {
		speed = 0;
		System.out.println(color + " �� ���� �����Ѵ�. ���� �ӵ��� : " + speed);
	}
	
	public void race() {
		speed = 120;
		System.out.println(color + " �� ���� �����Ѵ�. ���� �ӵ��� : " + speed);
	}
	// ���⼭ private �޼ҵ带 ����ٸ� ���� �ٸ��޼ҵ忡���� ����Ҽ��ִ�.
	// ex) private void park() {..} �� ����� park�� race�� drive�� �ȿ����� �����ִ�.
	
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