package com.lec.ex01_store;

public class TestMain {

	public static void main(String[] args) {

//		HeadQuarterStore store = new HeadQuarterStore("------����------");
//		store.kimchi();
//		store.bude();
//		store.bibim();
//		store.sunde();
//		store.gonggibab();

		// ���� Ÿ���� 1ȣ�� ����
		StoreNum1 store1 = new StoreNum1("-----1ȣ��-----");
		store1.print();
		store1.kimchi();
		store1.bude();
		store1.bibim();
		store1.sunde();
		store1.gonggibab();

		StoreNum2 store2 = new StoreNum2("-----2ȣ��-----");
		store2.print();
		store2.kimchi();
		store2.bude();
		store2.bibim();
		store2.sunde();
		store2.gonggibab();

		StoreNum3 store3 = new StoreNum3("-----3ȣ��-----");
		store3.print();
		store3.kimchi();
		store3.bude();
		store3.bibim();
		store3.sunde();
		store3.gonggibab();

	}

}
