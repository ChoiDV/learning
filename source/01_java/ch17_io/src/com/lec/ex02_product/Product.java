package com.lec.ex02_product;

public class Product {
	private String name; // 상품명
	private int price; // 가격
	private int ps; // 수량

	public Product() {
	}

	public Product(String name, int price, int ps) {
		this.name = name;
		this.price = price;
		this.ps = ps;
	}

	@Override
	public String toString() {
		return name + "\t" + price + "원\t\t" + ps + " 개";
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setPs(int ps) {
		this.ps = ps;
	}

}
