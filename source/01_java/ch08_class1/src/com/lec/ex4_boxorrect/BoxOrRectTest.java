package com.lec.ex4_boxorrect;

import javax.swing.Box;

public class BoxOrRectTest {

	public static void main(String[] args) {
		BoxOrRect box = new BoxOrRect(5,6,10);
		BoxOrRect rect = new BoxOrRect(10,5);
		
		box.vPrint();
		rect.vPrint();
		System.out.println("�ڽ� ���Ǵ� : " + box.getVolume());
		System.out.println("�簢���� ���̴� : " + rect.getVolume());

	}

}
