package com.lec.ex02_store;

public class TestMain2 {

	public static void main(String[] args) {
		
		// �޼Ұ� �� �Ȱ��� 5�� �̱� ������ ���� Ÿ������ ���� �迭�� �ֱ�
		HeadQuarterStore[] store = {new StoreNum1("-----1ȣ��-----"),
									new StoreNum2("-----2ȣ��-----"),
									new StoreNum3("-----3ȣ��-----")};
		// for��
		for (int i =0; i < store.length; i++) {
			
			store[i].kimchi();
			store[i].bude();
			store[i].bibim();
			store[i].sunde();
			store[i].gonggibab();	
		}
		// Ȯ�� for��
		for (HeadQuarterStore st : store) {
			
			st.kimchi();
			st.bude();
			st.bibim();
			st.sunde();
			st.gonggibab();
		}
		
		

	}

}
