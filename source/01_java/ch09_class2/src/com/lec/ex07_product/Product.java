package com.lec.ex07_product;

public class Product {
	private int serialNo; // ��ü ������ ��ȣ 101,102...
	public static int count = 100; // static�� �پ �����ϴ� ���� // 100������ �����ϰ�; = 100; ���� �ʱ�ȭ

	public Product() {
		serialNo = ++count;  // count++ �ϸ� ����ǰ� +1 �Ǳ⶧���� count++ �ϸ� 100���� ���
	}

	public void infoPrint() {
		System.out.println("serialNo = " + serialNo + "\t�������� count = " + count);
	}

}
