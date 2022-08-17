package com.lec.ex05_employee;

public class HourlyEmployee extends Employee {
	private int hoursWored;
	private int moneyPerHour;
	
	public HourlyEmployee(String name, int hoursWored, int moneyPerHour) {
		super(name);
		this.hoursWored = hoursWored;
		this.moneyPerHour = moneyPerHour;
	}
	
	@Override
	public int computePay() {  //  ПљБо
		return hoursWored*moneyPerHour;
	}
	
	
	
	
	

}
