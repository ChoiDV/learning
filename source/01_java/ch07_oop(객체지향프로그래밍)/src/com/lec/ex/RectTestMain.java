package com.lec.ex;

public class RectTestMain {

	public static void main(String[] args) {

		Rect r1 = new Rect();
		r1.setWidth(10);
		r1.setHeight(5);

		System.out.print("가로 : " + r1.getWidth() + "\t" + " 세로 : " + r1.getHeight() + "\t");
		System.out.println("\t" + "넓이는 = " + r1.area());

		Rect r2 = new Rect();
		r2.setWidth(20);
		r2.setHeight(10);

		System.out.print("가로 : " + r2.getWidth() + "\t" + " 세로 : " + r2.getHeight() + "\t");
		System.out.println("\t" + "넓이는 = " + r2.area());
	}

}
