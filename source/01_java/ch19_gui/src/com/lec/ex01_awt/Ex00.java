package com.lec.ex01_awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;

public class Ex00 {
	public static void main(String[] args) {
		Frame frame = new Frame("�ڹ� ù GUI"); // frame�� ���ƿ� Ÿ�� : BorderLayout Ÿ��
		Button button = new Button("��ư");
		frame.add(button, BorderLayout.NORTH); // ��ư�� NORTH �ʿ� �߰�
		Button btn1 = new Button("�׳� ��ư");
		frame.add(btn1, BorderLayout.CENTER); // �׳� ��ư�� CENTER�� �߰�
		
		frame.setSize(new Dimension(300,200)); // frame�� ������ ���� ���� 300 ���� 200 �ȼ�
		frame.setVisible(true);
		frame.setLocation(100,50);   // â�� ����Ǵ� ��ġ ����
		
		// 3���� �ڵ� â�ݰ� ��������
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
		frame.setVisible(false);  // ȭ�鿡 �Ⱥ��̰�
		frame.dispose();  // �ڿ�����
		System.exit(0);  // �������� 
		
		
		
	}
}
