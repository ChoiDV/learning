package com.lec.ex08_superdot;

public class ChildClass extends ParentClass {
	private int i = 99;

	public ChildClass() {
		System.out.println("ChildClass ������");
	}
	@Override
	public void method() {
		System.out.println("ChildClass�� method");
		super.method();  // super. �� ���� �޼ҵ尡 �ƴ� �� �θ���� �޼ҵ带 ����ϴ°� �� ParentClass�� �޼ҵ带 ȣ��	
		System.out.println("ChildClass���� super�� i = "+ super.getI() + ", Child���� i = " + i);
	}
	@Override
	public int getI() {
		return super.getI();                
	}
	
	
}
