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
	private Container contenPane; // 컨테이너
	private JPanel jp1; // 이름,전화,나이 넣을 패널
	private JPanel jp2; // 버튼 두개 넣을 패널
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
		btnIn = new JButton("가입", iconIn);
		btnOut = new JButton("출력", iconOut);
		jp1.add(new JLabel("이 름", (int) CENTER_ALIGNMENT));
		jp1.add(txtName);
		jp1.add(new JLabel("전 화", (int) CENTER_ALIGNMENT));
		jp1.add(txtTel);
		jp1.add(new JLabel("나 이", (int) CENTER_ALIGNMENT));
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
				System.out.println("이름과 전화번호는 필수 입력 사항입니다.");
				return;
			}
			if (tel.indexOf("-") == tel.lastIndexOf("-") || tel.indexOf("-") < 2 || tel.lastIndexOf("-") > 10) {
				System.out.println("전화번호 형식을 확인해 주세요.");
				return;
			}
			int age = 0;
			try {
				age = Integer.parseInt(txtAge.getText());
				if (age < 0 || age > 150) {
					System.out.println("유효하지 않은 나이를 입력할 경우 0살로.");
				}
			} catch (Exception e1) {
				System.out.println("유효하지 않은 나이를 입력할 경우 0살로..");
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
			System.out.println("가입이 완료되었습니다.");
		}
		if (e.getSource() == btnOut) {
			if (person.isEmpty()) {
				System.out.println("회원가입한 사람이 없습니다.");
			} else {
				System.out.println("\n회원 목록");
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
//				System.out.println("...이상 회원 목록 끝");
//			} catch (Exception e2) {
//				System.out.println("파일을 읽어올 수 없습니다.");
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
		new MyFrame("GUI 예제");
	}

}
