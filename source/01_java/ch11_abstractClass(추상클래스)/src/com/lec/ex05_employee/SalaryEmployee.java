package com.lec.ex05_employee;

public class SalaryEmployee extends Employee {
	private int annalSalary;  // ¿¬ºÀ 
	
	public SalaryEmployee(String name, int annalSalary) {
		super(name);
		this.annalSalary = annalSalary;
	}
	@Override
	public int computePay() {  // ¿ù±Þ
		return annalSalary/14;
	}
	
	

}
