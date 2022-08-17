package com.lec.ex01_awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;

public class Ex00 {
	public static void main(String[] args) {
		Frame frame = new Frame("자바 첫 GUI"); // frame의 레아웃 타입 : BorderLayout 타입
		Button button = new Button("버튼");
		frame.add(button, BorderLayout.NORTH); // 버튼을 NORTH 쪽에 추가
		Button btn1 = new Button("그냥 버튼");
		frame.add(btn1, BorderLayout.CENTER); // 그냥 버튼을 CENTER에 추가
		
		frame.setSize(new Dimension(300,200)); // frame의 사이즈 설정 가로 300 세로 200 픽셀
		frame.setVisible(true);
		frame.setLocation(100,50);   // 창이 실행되는 위치 지정
		
		// 3초후 자동 창닫고 실행종료
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
		frame.setVisible(false);  // 화면에 안보이게
		frame.dispose();  // 자원해제
		System.exit(0);  // 강제종료 
		
		
		
	}
}
