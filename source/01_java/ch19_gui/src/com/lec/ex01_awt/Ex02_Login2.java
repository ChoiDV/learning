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
	private Label lbl1; // ���� lbl �ؽ�Ʈ�� txt  ������� ���� �����
	private TextField txtId;
	private Label lbl2;
	private TextField txtPw;
	private Button btnLogin;
	
	public Ex02_Login2(String title) { // �� ������ �� �����ؾ��� Frame�� ������Ʈ �߰��ϰ� ȭ�� ���̰� �ϰ� ->�̺�Ʈ����
		super(title);
		//Frame�� ���̾ƿ� Ÿ�� : BorderLayout (��,��,��,��,center) �⺻�� ����   Frame�� �⺻ Layout
		//                 : FlowLayout (���ʺ��� ����������, ������ �Ʒ��� �������� add)
		//                 : GridLayout ( �� �� �� )
		panel = new Panel();  // �г��� �⺻ ���̾ƿ� : FlowLayout
//		setLayout(new GridLayout(2,2)); // Frame�� ���̾ƿ� ����
		lbl1 = new Label("    ���̵�");
		txtId = new TextField(20); // ���ڸ� �Է��ϴ°� ũ�⸦ �����ϴ� 20 �Է��� ����, �������̴� ���̸� 20���� ����
		lbl2 = new Label("��й�ȣ");
		txtPw = new TextField(20);
		txtPw.setEchoChar('*'); // ��й�ȣ �Է��Ҷ� ȭ�鿡 *�� ǥ�õǰ� ������� ����
		btnLogin = new Button("LOGIN");
		
		panel.add(lbl1);
		panel.add(txtId);
		panel.add(lbl2);
		panel.add(txtPw);
		panel.setPreferredSize(new Dimension(280,50));
		
		add(panel, BorderLayout.NORTH);
		add(btnLogin,BorderLayout.SOUTH);
		setSize(new Dimension(300,150)); //���� ,����
		setLocation(200,100); // ����, ����  �̰� ���ϸ� ���ʱ����� �����Ǽ� ó�� â�̶ߴ���ġ�� �������ִ°�
		setVisible(true);
//		setResizable(false); // ����ڰ� size ���� �Ұ�
		// x Ŭ���� ����
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				setVisible(false);  // �Ⱥ��̰�
				dispose();   // ������Ʈ �ڿ� ���� 
				System.exit(0); // �������� 
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
