package com.lec.ex03_person;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MyFrame extends JFrame implements ActionListener {
	private Container contenPane; // �����̳�
	private JPanel jp1; // �̸�,��ȭ,���� ���� �г�
	private JPanel jp2; // ��ư �ΰ� ���� �г�
	private JTextField txtName, txtTel, txtAge;
	private ImageIcon iconIn, iconOut;
	private JButton btnIn, btnOut;
	private OutputStream os = null;
	private Reader is = null;
	ArrayList<Person> person = new ArrayList<Person>();

	public MyFrame() {
	}

	public MyFrame(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contenPane = getContentPane();
		jp1 = new JPanel(new GridLayout(3, 2));
		jp2 = new JPanel(new FlowLayout());
		txtName = new JTextField();
		txtTel = new JTextField();
		txtAge = new JTextField();
		iconIn = new ImageIcon("icon/icon/join.png");
		iconOut = new ImageIcon("icon/icon/output.png");
		btnIn = new JButton("����", iconIn);
		btnOut = new JButton("���", iconOut);
		jp1.add(new JLabel("�� ��", (int) CENTER_ALIGNMENT));
		jp1.add(txtName);
		jp1.add(new JLabel("�� ȭ", (int) CENTER_ALIGNMENT));
		jp1.add(txtTel);
		jp1.add(new JLabel("�� ��", (int) CENTER_ALIGNMENT));
		jp1.add(txtAge);
		jp2.add(btnIn);
		jp2.add(btnOut);
		contenPane.add(jp1, BorderLayout.NORTH);
		contenPane.add(jp2, BorderLayout.SOUTH);
		setVisible(true);
		setBounds(200, 100, 300, 170);
		btnIn.addActionListener(this);
		btnOut.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnIn) {
			String name = txtName.getText().trim();
			String tel = txtTel.getText().trim();
			if (name.equals("") || tel.equals("")) {
				System.out.println("�̸��� ��ȭ��ȣ�� �ʼ� �Է� �����Դϴ�.");
				return;
			}
			if (tel.indexOf("-") == tel.lastIndexOf("-") || tel.indexOf("-") < 2 || tel.lastIndexOf("-") > 10) {
				System.out.println("��ȭ��ȣ ������ Ȯ���� �ּ���.");
				return;
			}
			int age = 0;
			try {
				age = Integer.parseInt(txtAge.getText());
				if (age < 0 || age > 150) {
					System.out.println("��ȿ���� ���� ���̸� �Է��� ��� 0���.");
				}
			} catch (Exception e1) {
				System.out.println("��ȿ���� ���� ���̸� �Է��� ��� 0���..");
			}
			person.add(new Person(name, tel, age));
			try {
				os = new FileOutputStream("person/person.txt", true);
				String line = "\n";
				if (!person.isEmpty()) {
					for (int i = 0; i < person.size(); i++) {
						os.write(person.get(i).toString().getBytes());
						os.write(line.getBytes());
					}
				}

			} catch (FileNotFoundException e2) {

				System.out.println(e2.getMessage());
			} catch (IOException e1) {
				System.out.println(e1.getMessage());
			} finally {
				try {
					if (os != null) {
						os.close();
					}
				} catch (Exception e2) {

				}
			}
			System.out.println("������ �Ϸ�Ǿ����ϴ�.");
		}
		if (e.getSource() == btnOut) {
			if (person.isEmpty()) {
				System.out.println("ȸ�������� ����� �����ϴ�.");
			} else {
				System.out.println("\nȸ�� ���");
				for (int i = 0; i < person.size(); i++) {
					System.out.println(person.get(i));
				}				
			}
//			try {
//				is = new FileReader("person/person.txt");
//				while (true) {
//					int data = is.read();
//					if (data == -1) {
//						break;
//					}
//					System.out.print((char) data);
//				}
//				System.out.println("...�̻� ȸ�� ��� ��");
//			} catch (Exception e2) {
//				System.out.println("������ �о�� �� �����ϴ�.");
//			} finally {
//				try {
//					if (is != null) {
//						is.close();
//					}
//				} catch (Exception e3) {
//
//				}
//			}
		}
	}

	public static void main(String[] args) {
		new MyFrame("GUI ����");
	}

}
