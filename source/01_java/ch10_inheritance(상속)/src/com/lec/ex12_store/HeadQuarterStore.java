package com.lec.ex12_store;

public class HeadQuarterStore {
	private String store; // ¸ÅÀå

	public HeadQuarterStore(String store) {
		this.store = store;
	}

	public void print() {
		System.out.println(store);
	}	
	
	public void kimchi() {
		System.out.println("±èÄ¡Âî°³ : 5,000¿ø");
	}
	
	public void bude() {
		System.out.println("ºÎ´ëÂî°³ : 6,000¿ø");
	}
	
	public void bibim() {
		System.out.println("ºñºö¹ä : 6,000¿ø");
	}
	
	public void sunde() {
		System.out.println("¼ø´ë±¹ : 5,000¿ø");
	}
	
	public void gonggibab() {
		System.out.println("°ø±â¹ä : 1,000¿ø");
	}
	
	public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}

}
