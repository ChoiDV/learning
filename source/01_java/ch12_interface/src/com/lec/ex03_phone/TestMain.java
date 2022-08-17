package com.lec.ex03_phone;

public class TestMain {

	public static void main(String[] args) {
		
		AModel a = new AModel();
		BModel b = new BModel();
		CModel c = new CModel();
		
		IAcorporation[] phone = { a,b,c};
		
		for( IAcorporation temp : phone) {
			System.out.println(temp.getClass().getName()); // temp�� Ŭ������ �̸��� �����Ͷ�.
			temp.dmbReceive();
			temp.lte();
			temp.tvRemoteControl();
			System.out.println("~~~~~~~~~~~~~~~~~~~~");
		}
		

	}

}
