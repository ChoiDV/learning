package com.lec.condition_���ǹ�;

public class Ex05_evenOddȦ¦ {

	public static void main(String[] args) {
		int num = -3;
		if(num%2 ==0) {
			System.out.println("¦��");
		} else {
			System.out.println("Ȧ��");
		}
		
		// switch
		switch(num%2) {
		case 0 : System.out.println("¦��");
			break;
		default : System.out.println("Ȧ��");
			break;
		}
		
		// ���� ������
		System.out.print(num%2==0 ? "¦�� " : "Ȧ��");
	}

}
