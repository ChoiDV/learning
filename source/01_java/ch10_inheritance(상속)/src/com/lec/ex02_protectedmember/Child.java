package com.lec.ex02_protectedmember;

public class Child extends SuperIJ{
	private int total;

	public Child() {	
		System.out.println("�Ű����� ���� Child ������ �Լ�");
	}
	// Child c = new Child(10,20);
	public Child(int i, int j) {		
		setI(i);
		setJ(j);
		System.out.println("�Ű����� �ִ� Child ������");
	}
	public void sum() {
		total = getI() + getJ();
		System.out.printf("�� ��ü�� i=%d, j=%d.\n",getI(),getJ());
		System.out.printf("�� ��ü�� total=%d\n",total);
	}
}
