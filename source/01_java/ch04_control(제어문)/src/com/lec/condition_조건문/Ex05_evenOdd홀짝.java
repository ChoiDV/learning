package com.lec.condition_Á¶°Ç¹®;

public class Ex05_evenOddÈ¦Â¦ {

	public static void main(String[] args) {
		int num = -3;
		if(num%2 ==0) {
			System.out.println("Â¦¼ö");
		} else {
			System.out.println("È¦¼ö");
		}
		
		// switch
		switch(num%2) {
		case 0 : System.out.println("Â¦¼ö");
			break;
		default : System.out.println("È¦¼ö");
			break;
		}
		
		// »ïÇ× ¿¬»êÀÚ
		System.out.print(num%2==0 ? "Â¦¼ö " : "È¦¼ö");
	}

}
