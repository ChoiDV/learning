package com.lec.ex01_store;

public class StoreNum1 extends HeadQuarterStore {

	public StoreNum1(String store) {
		super(store);
	}

	@Override
	public void kimchi() {
		System.out.println("��ġ� : 4,500��");
	}

	@Override
	public void bude() {
		System.out.println("�δ�� : 5,000��");
	}

	@Override
	public void bibim() {
		System.out.println("����� : 6,000��");
	}

	@Override
	public void sunde() {
		System.out.println("���뱹 : ���Ⱦ� ");
	}

	@Override
	public void gonggibab() {
		System.out.println("����� : 1,000��");
	}

}
