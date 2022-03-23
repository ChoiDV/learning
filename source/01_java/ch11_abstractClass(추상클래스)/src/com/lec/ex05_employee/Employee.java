package com.lec.ex05_employee;

public abstract class Employee {
	private String name;
	
	public Employee(String name) {
		this.name = name;
	}

	public abstract int computePay(); // ����

	public final int computeIncentive() { // �μ�Ƽ��
		int pay = computePay();   // int pay�� �޼ҵ带 �ִ������� �츮�� ���������� ��ǻ�ʹ� computePay()�޼ҵ忡 
		if (pay > 2000000) {  	// ���ٰ� ���°��̴�. �׷��� �޼ҵ�ȿ� �޼ҵ带 ������ �־���Ҷ��� �ƽθ� ������ �޼ҵ带 �־��ִ°��� ȿ����.
			return ((int) (pay * 0.5));
		}
			return 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
