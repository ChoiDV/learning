package com.lec.ex01_runnable;

public class TargetTestMain {
	public static void main(String[] args) {
//		TargetEx01 target1 = new TargetEx01();
//		TargetEx02 target2 = new TargetEx02();
		Runnable target1 = new TargetEx01();
		Runnable target2 = new TargetEx02(); // 두개가 같은소리
		
		// "A","B" 는 스레드 이름
		Thread threadA = new Thread(target1, "A");
		// "A"라는 이름의 쓰레드 생성 - 안녕하세요 할 쓰레드 target1.run() 수행
		Thread threadB = new Thread(target2, "B"); 
		// "B"라는 이름의 쓰레드 생성 - 반갑습니다 할 쓰레드 target2.run() 수행
		
		
		threadA.start();
		threadB.start();
		// thread.start() 는 스레드를 실행가능 상태로 바꿔주는것  준비시켜준다는느낌
		
		
		for(int i = 0; i < 10; i++) {
			System.out.println("★나는 "+ Thread.currentThread().getName() +"-"+i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
		}
		// TargetEx01과 TargetEx02과 메인스레드 세개를 동시에 실행시킴
		
	}
}
