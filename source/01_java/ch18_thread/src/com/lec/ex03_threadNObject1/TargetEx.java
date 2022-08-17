package com.lec.ex03_threadNObject1;

public class TargetEx implements Runnable {
	private int num = 0;

	// synchronized 를 붙인 함수는 이 메소드를 실행할때는 다른것들이 끼어들지마라 라는 함수
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			out();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	private synchronized void out() {
		if (Thread.currentThread().getName().equals("A")) { // "A" 쓰레드일 경우
			System.out.println("~ ~ ~A 쓰레드 수행중 ~ ~ ~");
			num++;
		}
		System.out.println(Thread.currentThread().getName() + " 의 num = " + num);
	}

}
