package com.lec.ex4_boxorrect;

import javax.swing.Box;

public class BoxOrRectTest {

	public static void main(String[] args) {
		BoxOrRect box = new BoxOrRect(5,6,10);
		BoxOrRect rect = new BoxOrRect(10,5);
		
		box.vPrint();
		rect.vPrint();
		System.out.println("박스 부피는 : " + box.getVolume());
		System.out.println("사각형의 넓이는 : " + rect.getVolume());

	}

}
