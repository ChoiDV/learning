package com.lec.ex01_store;
// �߻�޼ҵ�� ��ü ������ �Ұ�
// public HeadQuarterStore store = new HeadQuarterStore(store); �� �Ұ� ��ü ���� �Ұ�!!!!!!!!
public abstract class HeadQuarterStore { // abstract �� �߻�Ŭ������ ������ִ� ��.
	private String store; // ����

	public HeadQuarterStore(String store) {
		this.store = store;
	}

	public void print() {
		System.out.println(store);
	}

	// Ŭ���� �� �߻� �޼ҵ尡 �ϳ� �̻��϶� : �� Ŭ������ �߻� Ŭ���� ��� ��.
	public abstract void kimchi(); // �޼ҵ� ������ ���� ���� �Ǿ� �ִ� �޼ҵ� : �߻� �޼ҵ�(��� ���� Ŭ�������� �������̵� �� �������)

	public abstract void bude();

	public abstract void bibim();

	public abstract void sunde();

	public abstract void gonggibab();

	public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}

}
