package com.lec.ex12_store;

public class StoreNum3 extends HeadQuarterStore{
	public StoreNum3(String store) {
		super(store);
	}
	@Override
	public void kimchi() {
		System.out.println("��ġ� : 6,000��");
	}
	@Override
	public void bude() {
		System.out.println("�δ�� : 7,000��");
	}
	@Override
	public void bibim() {
		System.out.println("����� : 7,000��");
	}
	@Override
	public void sunde() {
		System.out.println("���뱹 : 6,000��");
	}
}
