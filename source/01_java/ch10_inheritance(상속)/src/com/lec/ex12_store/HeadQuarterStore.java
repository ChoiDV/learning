package com.lec.ex12_store;

public class HeadQuarterStore {
	private String store; // ����

	public HeadQuarterStore(String store) {
		this.store = store;
	}

	public void print() {
		System.out.println(store);
	}	
	
	public void kimchi() {
		System.out.println("��ġ� : 5,000��");
	}
	
	public void bude() {
		System.out.println("�δ�� : 6,000��");
	}
	
	public void bibim() {
		System.out.println("����� : 6,000��");
	}
	
	public void sunde() {
		System.out.println("���뱹 : 5,000��");
	}
	
	public void gonggibab() {
		System.out.println("����� : 1,000��");
	}
	
	public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}

}
