package com.lec.ex01_store;

public class StoreNum2 extends HeadQuarterStore {
	public StoreNum2(String store) {
		super(store);
	}

	@Override
	public void kimchi() {
		System.out.println("��ġ� : 5,000��");

	}

	@Override
	public void bude() {
		System.out.println("�δ�� : 5,000��");
	}

	@Override
	public void bibim() {
		System.out.println("����� : 5,000��");
	}

	@Override
	public void sunde() {
		System.out.println("���뱹 : 5,000��");

	}

	@Override
	public void gonggibab() {
		System.out.println("����� : ����");
	}

}
