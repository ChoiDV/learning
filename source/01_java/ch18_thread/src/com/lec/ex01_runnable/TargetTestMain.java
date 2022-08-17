package com.lec.ex01_runnable;

public class TargetTestMain {
	public static void main(String[] args) {
//		TargetEx01 target1 = new TargetEx01();
//		TargetEx02 target2 = new TargetEx02();
		Runnable target1 = new TargetEx01();
		Runnable target2 = new TargetEx02(); // �ΰ��� �����Ҹ�
		
		// "A","B" �� ������ �̸�
		Thread threadA = new Thread(target1, "A");
		// "A"��� �̸��� ������ ���� - �ȳ��ϼ��� �� ������ target1.run() ����
		Thread threadB = new Thread(target2, "B"); 
		// "B"��� �̸��� ������ ���� - �ݰ����ϴ� �� ������ target2.run() ����
		
		
		threadA.start();
		threadB.start();
		// thread.start() �� �����带 ���డ�� ���·� �ٲ��ִ°�  �غ�����شٴ´���
		
		
		for(int i = 0; i < 10; i++) {
			System.out.println("�ڳ��� "+ Thread.currentThread().getName() +"-"+i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
		}
		// TargetEx01�� TargetEx02�� ���ν����� ������ ���ÿ� �����Ŵ
		
	}
}
