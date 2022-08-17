package com.lec.condition_조건문;

import java.util.Scanner;

// 0 <= Math.random() < 1 발생
// 0 <= Math.random()*3 <3
// 0 <= (int)(Math.random()*3) : 0,1,2 중의 하나
public class Quiz5_2 {
	// ------------------Quiz5 의 다른버전 두번째 버전. ---------------------------------------------
	public static void main(String[] args) {
		// 컴퓨터와 가위바위보 게임을 하는 프로그램을 구현하시오. 단,
		// 사용자는 가위를 내고자 할 때는 0을 입력하고 바위를 선택하고자 할 때는 1을 입력하고,
		// 보를 선택하고자 할 때는 2를 입력하여 게임을 진행합니다

		Scanner sc = new Scanner(System.in);
		System.out.print("가위(0) 바위(1) 보(2) 중 하나를 내세요 : ");
		int user, computer = (int) (Math.random() * 3);
		user = sc.nextInt();

		if (user == 0) {
			System.out.print("사용자는 가위 \t");
		} else if (user == 1) {
			System.out.print("사용자는 바위 \t");
		} else if (user == 2) {
			System.out.print(" 당신은 보자기 \t");
		} else {
			System.out.println("당신은 잘못 냈습니다. 프로그램을 종료합니다.");
			user = 3; // 끝내기 위한 조건.
		}

		if (user != 3) { // 사용자가 올바른 값을 입력했을때만 컴퓨터가 낸것을 계산해 승패 출력.
			String msg = (computer == 0) ? "컴퓨터는 가위" : (computer == 1) ? "컴퓨터는 바위" : "컴퓨터는 보";
			System.out.println(msg);

			// 경우의 수 3가지 : 졌다. 이겼다 , 비겼다.
			// if((user ==0 && computer==1) || (user==1) || (computer==2)){
			// 이런식으로 연산자 활용해서 해도되고

			// 패턴화 해서 해도됨. 밑에

			if ((user + 1) % 3 == computer) {
				System.out.println("사용자 패배.");
			} else if (user == computer) {
				System.out.println("무승부");
			} else {
				System.out.println("사용자 승리.");
			} // if - 승패 출력
		} // if
	} // main
} // class
