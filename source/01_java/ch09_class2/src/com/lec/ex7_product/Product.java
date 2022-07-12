package com.lec.ex7_product;

public class Product {
	private int serialNo; // 객체 고유의 번호 101,102...
	public static int count = 100; // static이 붙어서 공유하는 변수 // 100번부터 시작하고싶어서 = 100; 으로 초기화

	public Product() {
		serialNo = ++count;  // count++ 하면 실행되고 +1 되기때문에 count++ 하면 100부터 출력
	}

	public void infoPrint() {
		System.out.println("serialNo = " + serialNo + "\t공유변수 count = " + count);
	}

}
