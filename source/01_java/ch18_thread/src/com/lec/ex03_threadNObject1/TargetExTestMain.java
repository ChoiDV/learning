package com.lec.ex03_threadNObject1;

public class TargetExTestMain {
	public static void main(String[] args) {
		TargetEx target = new TargetEx();
		Thread threadA = new Thread(target,"A");
		Thread threadB = new Thread(target,"B");
		
		threadA.start();
		threadB.start();
		System.out.println("main 함수 끝");
		// A가 증가시켜놓은걸 B가 공유해서 B도 증가한것처럼 보이는것
		// 실제론 A만 증가시켜놓음 
	}
}
