package com.lec.ex12_store;

public class StoreNum1 extends HeadQuarterStore {
	
	public StoreNum1(String store) {
		super(store);
	}
	@Override
	public void bude() {		
		System.out.println("부대찌개 : 5,000원");
	}
	@Override
	public void sunde() {
		System.out.println("순대국 : 안팔아");
	}
	
	
}
