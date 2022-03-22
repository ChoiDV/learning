package com.lec.ex04_car;
// Car c = new LowGradeCar
public class LowGradeCar extends Car {
	private int tax; // = 5000;  �⺻�����Ϳ��� �ٷ� �ʱ�ȭ
	
	public LowGradeCar(String color, String tire, int displacement, String handle) {
		super(color, tire, displacement, handle);
		tax = 50000;  // �����ڿ��� ������ �ʱ�ȭ		
	}
	
	@Override
	public void getSpec() {   // spec��( ����, Ÿ�̾�, ��ⷮ, �ڵ�, ����) �� ��� 
		if(getDisplacement() > 1000) {
			tax += (getDisplacement()-1000)*100;
		}
		System.out.println("    �� �� : "+getColor());
		System.out.println("    Ÿ�̾� : "+getTire());
		System.out.println("    ��ⷮ : "+getDisplacement()+ " cc");
		System.out.println("    �ڵ� : "+getHandle());
		System.out.println("    ���� : "+tax + " ��");
		System.out.println("-----------------------");
				
	}
	
	
	
	
	

}
