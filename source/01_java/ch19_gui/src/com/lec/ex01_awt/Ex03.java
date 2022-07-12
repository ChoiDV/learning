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
	// �̺�Ʈ �� �������� ������ �ۿ��� �������־�� �̺�Ʈ�� �ɼ� ����
	private Panel panel;
	private TextField txtField;
	private Button btnOk, btnExit;
	private List list;

	public Ex03() { // layout����, ������Ʈ ���� �� add, setVisible, setSize
		// setLayout(new BorderLayout()); // Frame�� �⺻ ���̾ƿ��� BorderLayout() �̶� �Ʒ��� ����
		panel = new Panel(); // �⺻ ���̾ƿ� : FlowLayout();
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
				setVisible(false); // �Ⱥ��̰�
				dispose(); // ������Ʈ �ڿ� ����
				System.exit(0); // ��������
			}
		});
		
		// �̺�Ʈ ������ �߰��ϴ� �κ�
		btnOk.addActionListener(this);
		btnExit.addActionListener(this); 
		
		// �̺�Ʈ �߰� 1. implements ActionListener -> override
		// 2. �̺�Ʈ ������ �߰�(V);
		// 3. override�� �޼ҵ� �ȿ� �����߰�

	}

	public Ex03(String title) {
		this();
		setTitle(title);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnOk) { // OK��ư Ŭ���� �� ���� : txtField�� �ؽ�Ʈ�� list �߰�
			list.add(txtField.getText().trim().toUpperCase());  // getText() �ϸ� �״�� �Է� 
			txtField.setText("");
		} else if (e.getSource() == btnExit) {  // ���� ����
			setVisible(false);
			dispose();
			System.exit(0);
		}

	}

	public static void main(String[] args) {
		new Ex03();

	}

}
