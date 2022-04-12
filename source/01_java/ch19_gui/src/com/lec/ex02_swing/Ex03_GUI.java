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
	// ������Ʈ ��ü ���� ����, ArrayList����, File io�� ���� stream, db ���Ӱ��� ����
	private Container contenPane; // �����̳� ���� ���� �����̳� = Frame �� ���� ���� ū Ʋ ����
	private JPanel jp; // �̸�,��ȭ,���� ���� 6���� ������Ʈ�� gridLayout���� add // ���� Ʋ ����
	private JTextField txtName, txtTel, txtAge;
	private ImageIcon icon;
	private JButton btnOut;
	private JTextArea jta;
	private JScrollPane scroolbar;
	private int cnt; // ��� �Է��ߴ��� ����
//	private ArrayList<Person> person;   ArrayList ���� �̷��� ����
//  private OutputStream os;    ����� ����
	// ������ : �����̳� ���ͼ� -> layoutSetting -> ������Ʈ ��ü ���� �ؼ� add -> �̺�Ʈ �߰�

	public Ex03_GUI() {

	}

	public Ex03_GUI(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contenPane = getContentPane();
//		contenPane.setLayout(new BorderLayout()); // �⺻ ���̾ƿ��� BorderLayout�̶� ���� ����
		jp = new JPanel(new GridLayout(3, 2)); // �ؿ� ������ �� ���ٷ� ������
//		jp = new JPanel();
//		jp.setLayout(new GridLayout(3,2));     // �г��� �⺻ ���̾ƿ��� FlowLayout() 
		txtName = new JTextField(); // ���� ���°� ������ ũ�� (20) ������ �������൵ gridlayout�� �˾Ƽ� ������
		txtTel = new JTextField();
		txtAge = new JTextField();
		icon = new ImageIcon("icon/icon/output.png");
		btnOut = new JButton("���", icon);
		jta = new JTextArea(5, 30); // 5�� 30���� ���̴� textArea ����
		scroolbar = new JScrollPane(jta);
		jp.add(new JLabel("�� ��", (int) CENTER_ALIGNMENT));
		jp.add(txtName);
		jp.add(new JLabel("�� ȭ", (int) CENTER_ALIGNMENT));
		jp.add(txtTel);
		jp.add(new JLabel("�� ��", (int) CENTER_ALIGNMENT));
		jp.add(txtAge);
		contenPane.add(jp, BorderLayout.NORTH);
		contenPane.add(btnOut, BorderLayout.CENTER);
		contenPane.add(scroolbar, BorderLayout.SOUTH);
		setVisible(true);
//		setSize(new Dimension(400,300));
//		setLocation(200,100);
		setBounds(200, 100, 400, 300); // setSize�� setLocation�� ���� �ϴ°� setBounds
		// setBounds(location ���� , location ���� , size ����, size ���� );
		btnOut.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) { // �̺�Ʈ ����
		if (e.getSource() == btnOut) {
			// txtName, txtTel, txtAge �� �Էµ� ���� jta �� ���
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
			System.out.println(++cnt + " �� �Էµ�");
			if (cnt == 1) {
				jta.setText("�̸�\t��ȭ\t\t����\n");
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
