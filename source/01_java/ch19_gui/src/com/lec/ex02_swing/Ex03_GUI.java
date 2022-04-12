package com.lec.ex02_swing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Ex03_GUI extends JFrame implements ActionListener {
	// 컴포넌트 객체 변수 선언, ArrayList변수, File io를 위한 stream, db 접속관련 변수
	private Container contenPane; // 컨테이너 얻어올 변수 컨테이너 = Frame 과 같은 가장 큰 틀 느낌
	private JPanel jp; // 이름,전화,나이 받을 6개의 컴포넌트를 gridLayout으로 add // 작은 틀 느낌
	private JTextField txtName, txtTel, txtAge;
	private ImageIcon icon;
	private JButton btnOut;
	private JTextArea jta;
	private JScrollPane scroolbar;
	private int cnt; // 몇명 입력했는지 저장
//	private ArrayList<Person> person;   ArrayList 사용시 이렇게 선언
//  private OutputStream os;    입출력 사용시
	// 생성자 : 컨테이너 얻어와서 -> layoutSetting -> 컴포넌트 객체 생성 해서 add -> 이벤트 추가

	public Ex03_GUI() {

	}

	public Ex03_GUI(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contenPane = getContentPane();
//		contenPane.setLayout(new BorderLayout()); // 기본 레이아웃이 BorderLayout이라 생략 가능
		jp = new JPanel(new GridLayout(3, 2)); // 밑에 두줄이 이 한줄로 가능함
//		jp = new JPanel();
//		jp.setLayout(new GridLayout(3,2));     // 패널의 기본 레이아웃은 FlowLayout() 
		txtName = new JTextField(); // 글자 적는곳 공간의 크기 (20) 같은걸 안적어줘도 gridlayout은 알아서 정해줌
		txtTel = new JTextField();
		txtAge = new JTextField();
		icon = new ImageIcon("icon/icon/output.png");
		btnOut = new JButton("출력", icon);
		jta = new JTextArea(5, 30); // 5행 30열이 보이는 textArea 공간
		scroolbar = new JScrollPane(jta);
		jp.add(new JLabel("이 름", (int) CENTER_ALIGNMENT));
		jp.add(txtName);
		jp.add(new JLabel("전 화", (int) CENTER_ALIGNMENT));
		jp.add(txtTel);
		jp.add(new JLabel("나 이", (int) CENTER_ALIGNMENT));
		jp.add(txtAge);
		contenPane.add(jp, BorderLayout.NORTH);
		contenPane.add(btnOut, BorderLayout.CENTER);
		contenPane.add(scroolbar, BorderLayout.SOUTH);
		setVisible(true);
//		setSize(new Dimension(400,300));
//		setLocation(200,100);
		setBounds(200, 100, 400, 300); // setSize와 setLocation을 같이 하는것 setBounds
		// setBounds(location 가로 , location 세로 , size 가로, size 세로 );
		btnOut.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) { // 이벤트 로직
		if (e.getSource() == btnOut) {
			// txtName, txtTel, txtAge 에 입력된 값을 jta 에 출력
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
			System.out.println(++cnt + " 명 입력됨");
			if (cnt == 1) {
				jta.setText("이름\t전화\t\t나이\n");
			}
			jta.append(name + "\t" + tel + "\t\t" + age + "\n");
			txtName.setText("");
			txtTel.setText("");
			txtAge.setText("");

		}
	}

	public static void main(String[] args) {
		new Ex03_GUI("last Ex");
	}

}
