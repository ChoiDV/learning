package com.lec.ex01_store;

public class StoreNum1 extends HeadQuarterStore {

	public StoreNum1(String store) {
		super(store);
	}

	@Override
	public void kimchi() {
		System.out.println("±èÄ¡Âî°³ : 4,500¿ø");
	}

	@Override
	public void bude() {
		System.out.println("ºÎ´ëÂî°³ : 5,000¿ø");
	}

	@Override
	public void bibim() {
		System.out.println("ºñºö¹ä : 6,000¿ø");
	}

	@Override
	public void sunde() {
		System.out.println("¼ø´ë±¹ : ¾ÈÆÈ¾Æ ");
	}

	@Override
	public void gonggibab() {
		System.out.println("°ø±â¹ä : 1,000¿ø");
	}

}
