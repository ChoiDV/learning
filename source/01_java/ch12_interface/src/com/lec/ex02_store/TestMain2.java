package com.lec.ex02_store;

public class TestMain2 {

	public static void main(String[] args) {
		
		// 메소가 다 똑같이 5개 이기 때문에 같은 타입으로 만들어서 배열에 넣기
		HeadQuarterStore[] store = {new StoreNum1("-----1호점-----"),
									new StoreNum2("-----2호점-----"),
									new StoreNum3("-----3호점-----")};
		// for문
		for (int i =0; i < store.length; i++) {
			
			store[i].kimchi();
			store[i].bude();
			store[i].bibim();
			store[i].sunde();
			store[i].gonggibab();	
		}
		// 확장 for문
		for (HeadQuarterStore st : store) {
			
			st.kimchi();
			st.bude();
			st.bibim();
			st.sunde();
			st.gonggibab();
		}
		
		

	}

}
