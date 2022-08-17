package com.lec.loop_반복문;

public class Ex05_breakContinue {
// break : 블럭을 완전히 빠져 나감
// coninue : 블럭의 실행을 멈추고 증감부분으로 감
	
	public static void main(String[] args) {
		for(int i=0; i <=5 ; i++ ) {
			if (i==3) {
			//	break;  // 무한반복문에서 break를 사용해서 끝내기.
				continue;
			}
			System.out.println(i + " . 안녕");
		}

	}

}
