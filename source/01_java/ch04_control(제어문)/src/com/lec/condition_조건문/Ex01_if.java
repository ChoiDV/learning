package com.lec.condition_조건문;

public class Ex01_if {

	public static void main(String[] args) {
		// if문
		
		//  Ctrl+Shift+f 누르면 알아서 가독성 좋게 정리해줌 .

		int seoulLunchPrice = 5000;

		if (seoulLunchPrice >= 8000) {
			System.out.println("서울 점심값 비싸네요.");
		} else if (seoulLunchPrice >= 6000) {
			System.out.println("서울 밥 값 인정. 그래");
		} else if (seoulLunchPrice >= 5000) {
			System.out.println("좋네");
		} else {
			System.out.println("식당 주인 망할까봐 걱정되네");
		}

	
	}

}
