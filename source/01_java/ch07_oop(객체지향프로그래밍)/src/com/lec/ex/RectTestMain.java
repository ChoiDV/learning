package com.lec.ex;

public class RectTestMain {

	public static void main(String[] args) {

		Rect r1 = new Rect();
		r1.setWidth(10);
		r1.setHeight(5);

		System.out.print("���� : " + r1.getWidth() + "\t" + " ���� : " + r1.getHeight() + "\t");
		System.out.println("\t" + "���̴� = " + r1.area());

		Rect r2 = new Rect();
		r2.setWidth(20);
		r2.setHeight(10);

		System.out.print("���� : " + r2.getWidth() + "\t" + " ���� : " + r2.getHeight() + "\t");
		System.out.println("\t" + "���̴� = " + r2.area());
	}

}
