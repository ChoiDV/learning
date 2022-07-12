package com.lec.ex01_awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Ex03 extends Frame implements ActionListener {
	// 이벤트 걸 변수들은 생성자 밖에서 선언해주어야 이벤트를 걸수 있음
	private Panel panel;
	private TextField txtField;
	private Button btnOk, btnExit;
	private List list;

	public Ex03() { // layout셋팅, 컴포넌트 생성 후 add, setVisible, setSize
		// setLayout(new BorderLayout()); // Frame의 기본 레이아웃이 BorderLayout() 이라서 아래줄 생략
		panel = new Panel(); // 기본 레이아웃 : FlowLayout();
		txtField = new TextField(20);
		btnOk = new Button("OK");
		btnExit = new Button("EXIT");
		list = new List();

		panel.add(new Label("write"));
		panel.add(txtField);
		panel.add(btnOk);
		panel.add(btnExit);
		add(panel, BorderLayout.NORTH);
		add(list, BorderLayout.CENTER);
		setVisible(true);
		setSize(new Dimension(400, 150));
		setLocation(200, 200);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				setVisible(false); // 안보이게
				dispose(); // 컴포넌트 자원 해제
				System.exit(0); // 강제종료
			}
		});
		
		// 이벤트 리스터 추가하는 부분
		btnOk.addActionListener(this);
		btnExit.addActionListener(this); 
		
		// 이벤트 추가 1. implements ActionListener -> override
		// 2. 이벤트 리스너 추가(V);
		// 3. override된 메소드 안에 로직추가

	}

	public Ex03(String title) {
		this();
		setTitle(title);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnOk) { // OK버튼 클릭시 할 로직 : txtField의 텍스트를 list 추가
			list.add(txtField.getText().trim().toUpperCase());  // getText() 하면 그대로 입력 
			txtField.setText("");
		} else if (e.getSource() == btnExit) {  // 종료 로직
			setVisible(false);
			dispose();
			System.exit(0);
		}

	}

	public static void main(String[] args) {
		new Ex03();

	}

}
