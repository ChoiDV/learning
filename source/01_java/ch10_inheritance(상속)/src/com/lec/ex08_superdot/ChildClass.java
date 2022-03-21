package com.lec.ex08_superdot;

public class ChildClass extends ParentClass {
	private int i = 99;

	public ChildClass() {
		System.out.println("ChildClass 생성자");
	}
	@Override
	public void method() {
		System.out.println("ChildClass의 method");
		super.method();  // super. 은 나의 메소드가 아닌 내 부모단의 메소드를 얘기하는것 즉 ParentClass의 메소드를 호출	
		System.out.println("ChildClass에서 super의 i = "+ super.getI() + ", Child단의 i = " + i);
	}
	@Override
	public int getI() {
		return super.getI();                
	}
	
	
}
