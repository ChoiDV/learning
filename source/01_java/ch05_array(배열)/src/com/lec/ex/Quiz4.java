package com.lec.ex;

public class Quiz4 {

	public static void main(String[] args) {
		// �Ž����� 2680�� 500, 100, 50, 10¥�� �������� �� ��, ��� �־�� �ϳ�?	

		int[] coin = { 500, 100, 50, 10 };
		int money = 2680;

		for (int i = 0; i < coin.length; i++) {
			System.out.println(coin[i] + " �� " + money / coin[i] + " �� "); 
			money %= coin[i];  // ù��° i=0 �� ���� ����� �ϰ� money�� 2680/500 �� ������ 180�� �ȴ�.					
		}					  // �ι�° i=1 �� ���� 180/100 �� �ϰ� ����ѵ� money �� 180/100 �� �������� 80�� �ȴ�.
							 // �̷��� �ؼ� i�� 3�� �Ǽ� �������� �ݺ�
		
		// Ȯ�� for�� ����ϱ�
		//  for(int coin2 : coin ) {  // coin2 �� �ӽú���
		//  System.out.println(coin2 + "��¥�� ���� " + (money/coin2) + " �� " );
		//  money %= coin2;
	}

}
