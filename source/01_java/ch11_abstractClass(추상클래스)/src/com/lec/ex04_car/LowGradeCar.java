package com.lec.ex04_car;
// Car c = new LowGradeCar
public class LowGradeCar extends Car {
	private int tax; // = 5000;  기본데이터에서 바로 초기화
	
	public LowGradeCar(String color, String tire, int displacement, String handle) {
		super(color, tire, displacement, handle);
		tax = 50000;  // 생성자에서 데이터 초기화		
	}
	
	@Override
	public void getSpec() {   // spec들( 색상, 타이어, 배기량, 핸들, 세금) 을 출력 
		if(getDisplacement() > 1000) {
			tax += (getDisplacement()-1000)*100;
		}
		System.out.println("    색 상 : "+getColor());
		System.out.println("    타이어 : "+getTire());
		System.out.println("    배기량 : "+getDisplacement()+ " cc");
		System.out.println("    핸들 : "+getHandle());
		System.out.println("    세금 : "+tax + " 원");
		System.out.println("-----------------------");
				
	}
	
	
	
	
	

}
