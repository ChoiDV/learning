package com.lec.ex01_awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Ex02_Login2 extends Frame{
	private Panel panel;
	private Label lbl1; // 라벨은 lbl 텍스트면 txt  등등으로 변수 사용함
	private TextField txtId;
	private Label lbl2;
	private TextField txtPw;
	private Button btnLogin;
	
	public Ex02_Login2(String title) { // 이 생성자 꼭 실행해야지 Frame의 컴포넌트 추가하고 화면 보이게 하고 ->이벤트까지
		super(title);
		//Frame의 레이아웃 타입 : BorderLayout (동,서,남,북,center) 기본값 고정   Frame의 기본 Layout
		//                 : FlowLayout (왼쪽부터 오른쪽으로, 위부터 아래로 차곡차곡 add)
		//                 : GridLayout ( 행 과 열 )
		panel = new Panel();  // 패널의 기본 레이아웃 : FlowLayout
//		setLayout(new GridLayout(2,2)); // Frame의 레이아웃 셋팅
		lbl1 = new Label("    아이디");
		txtId = new TextField(20); // 글자를 입력하는곳 크기를 설정하는 20 입력은 자유, 눈에보이는 길이를 20으로 설정
		lbl2 = new Label("비밀번호");
		txtPw = new TextField(20);
		txtPw.setEchoChar('*'); // 비밀번호 입력할때 화면에 *로 표시되게 비공개를 위해
		btnLogin = new Button("LOGIN");
		
		panel.add(lbl1);
		panel.add(txtId);
		panel.add(lbl2);
		panel.add(txtPw);
		panel.setPreferredSize(new Dimension(280,50));
		
		add(panel, BorderLayout.NORTH);
		add(btnLogin,BorderLayout.SOUTH);
		setSize(new Dimension(300,150)); //가로 ,세로
		setLocation(200,100); // 가로, 세로  이거 안하면 왼쪽구석에 생성되서 처음 창이뜨는위치를 지정해주는것
		setVisible(true);
//		setResizable(false); // 사용자가 size 조정 불가
		// x 클릭시 종료
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				setVisible(false);  // 안보이게
				dispose();   // 컴포넌트 자원 해제 
				System.exit(0); // 강제종료 
			}
		});
	}

	public Ex02_Login2() {
		this("");
	}
	public static void main(String[] args) {
		new Ex02_Login2("Login");
	}
}
