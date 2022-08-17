package com.lec.ex;

public class Quiz4 {

	public static void main(String[] args) {
		// 거스름돈 2680을 500, 100, 50, 10짜리 동전으로 줄 때, 몇개씩 주어야 하나?	

		int[] coin = { 500, 100, 50, 10 };
		int money = 2680;

		for (int i = 0; i < coin.length; i++) {
			System.out.println(coin[i] + " 원 " + money / coin[i] + " 개 "); 
			money %= coin[i];  // 첫번째 i=0 이 돌때 출력을 하고 money는 2680/500 의 나머지 180이 된다.					
		}					  // 두번째 i=1 이 돌때 180/100 을 하고 출력한뒤 money 는 180/100 의 나머지인 80이 된다.
							 // 이렇게 해서 i가 3이 되서 돌때까지 반복
		
		// 확장 for문 사용하기
		//  for(int coin2 : coin ) {  // coin2 는 임시변수
		//  System.out.println(coin2 + "원짜리 동전 " + (money/coin2) + " 개 " );
		//  money %= coin2;
	}

}
