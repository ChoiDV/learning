package com.lec.ex3_student;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class StudentGui extends JFrame implements ActionListener {
	private Container contenPane;
	private JPanel jpup, jpbtn;
	private JTextField txtSno, txtSname, txtScore;
	private Vector<String> mnames;
	private JComboBox<String> comMajor;
	private JButton btnSNoSearch, btnSNameSearch, btnMNameSearch, btnclean, btnInput, btnUpdate, btnStudentOut,
			btnExpelOut, btnExpel, btnExit;
	private JTextArea txtPool;
	private JScrollPane scrollPane;

	private StudentDao dao = StudentDao.getInstance();
	private ArrayList<StudentDto> student;

	public StudentGui() {
	}

	public StudentGui(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contenPane = getContentPane();
		contenPane.setLayout(new FlowLayout());
		jpup = new JPanel(new GridLayout(4, 3));
		jpbtn = new JPanel();
		txtSno = new JTextField(10);
		txtSname = new JTextField(10);
		mnames = dao.mnameList();
		comMajor = new JComboBox<String>(mnames);
		txtScore = new JTextField(10);
		btnSNoSearch = new JButton("�й��˻�");
		btnSNameSearch = new JButton("�̸��˻�");
		btnMNameSearch = new JButton("�����˻�");
		btnclean = new JButton("�����");
		btnSNoSearch.setPreferredSize(new Dimension(100, 50));
		btnSNameSearch.setPreferredSize(new Dimension(100, 50));
		btnMNameSearch.setPreferredSize(new Dimension(100, 50));
		btnclean.setPreferredSize(new Dimension(100, 50));
		// �ι��� �г�
		btnInput = new JButton("�л��Է�");
		btnUpdate = new JButton("�л�����");
		btnStudentOut = new JButton("�л����");
		btnExpelOut = new JButton("���������");
		btnExpel = new JButton("����ó��");
		btnExit = new JButton("����");
		btnInput.setPreferredSize(new Dimension(100, 50));
		btnUpdate.setPreferredSize(new Dimension(100, 50));
		btnStudentOut.setPreferredSize(new Dimension(100, 50));
		btnExpelOut.setPreferredSize(new Dimension(100, 50));
		btnExpel.setPreferredSize(new Dimension(100, 50));
		btnExit.setPreferredSize(new Dimension(100, 50));
		txtPool = new JTextArea(10, 50);
		scrollPane = new JScrollPane(txtPool);
		// ������Ʈ ȭ�� �߰�
		jpup.add(new JLabel("�й�", (int) CENTER_ALIGNMENT));
		jpup.add(txtSno);
		jpup.add(btnSNoSearch);
		jpup.add(new JLabel("�̸�", (int) CENTER_ALIGNMENT));
		jpup.add(txtSname);
		jpup.add(btnSNameSearch);
		jpup.add(new JLabel("����", (int) CENTER_ALIGNMENT));
		jpup.add(comMajor);
		jpup.add(btnMNameSearch);
		jpup.add(new JLabel("����", (int) CENTER_ALIGNMENT));
		jpup.add(txtScore);
		jpup.add(btnclean);

		jpbtn.add(btnInput);
		jpbtn.add(btnUpdate);
		jpbtn.add(btnStudentOut);
		jpbtn.add(btnExpelOut);
		jpbtn.add(btnExpel);
		jpbtn.add(btnExit);
		contenPane.add(jpup);
		contenPane.add(jpbtn);
		contenPane.add(scrollPane);
		setSize(new Dimension(700, 550));
		setLocation(200, 150);
		setVisible(true);
//		btnSNoSearch, btnSNameSearch, btnMNameSearch, 
//		btnInput, btnUpdate , btnStudentOut, btnExpelOut,btnExpel, btnExit;
		btnSNoSearch.addActionListener(this);
		btnSNameSearch.addActionListener(this);
		btnMNameSearch.addActionListener(this);
		btnclean.addActionListener(this);
		btnInput.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnStudentOut.addActionListener(this);
		btnExpelOut.addActionListener(this);
		btnExpel.addActionListener(this);
		btnExit.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSNoSearch) {
			String sno = txtSno.getText().trim();
			if (!sno.equals("")) {
				int sNO = Integer.parseInt(sno);
				StudentDto student = dao.selectSno(sNO);
				if (student != null) {
					txtSname.setText(student.getSname());
					comMajor.setSelectedItem(student.getMname());
					txtScore.setText(Integer.toString(student.getScore()));
				} else {
					txtPool.setText("���� �й��Դϴ�.");
					txtSno.setText("");
				}
			} else {
				txtPool.setText("�й��� �Է��ϼ���.");
			}
		} else if (e.getSource() == btnSNameSearch) {
			String name = txtSname.getText().trim();
			if (!name.equals("")) {
				student = dao.selectSname(name);
				if (student.size() == 1) {
					txtPool.setText("");
					comMajor.setSelectedIndex(0);
					txtSno.setText(Integer.toString(student.get(0).getSno()));
					txtScore.setText(Integer.toString(student.get(0).getScore()));
					comMajor.setSelectedItem(student.get(0).getMname());
				} else if (student.size() == 0) {
					txtPool.setText("���� �л��� �ƴմϴ�.");
					txtSname.setText("");
				} else if (student.size() > 1) {
					comMajor.setSelectedIndex(0);
					txtPool.setText("�й�\t�̸�\t�а�\t����\n");
					for (int i = 0; i < student.size(); i++) {
						txtPool.append(student.get(i).toString() + "\n");
					}
					txtSname.setText("");
				}
			} else {
				txtPool.setText("�̸��� �Է��ϼ���.");
			}

		} else if (e.getSource() == btnMNameSearch) {
			String mname = comMajor.getSelectedItem().toString();
			if (!mname.equals("")) {
				student = dao.selectMname(mname);
				if (student.size() == 0) {
					txtPool.setText(mname + " �а��� �������� �л��� �����ϴ�.");
				} else {
					txtPool.setText("���\t�̸�(�й�)\t\t�а�\t����\n");
					for (int i = 0; i < student.size(); i++) {
						txtPool.append(student.get(i).toString() + "\n");
					}
				}
			} else {
				txtPool.setText("������ �����ϼ���.");
			}

		} else if (e.getSource() == btnclean) {
			txtPool.setText("");
			txtSno.setText("");
			txtSname.setText("");
			txtScore.setText("");
			comMajor.setSelectedIndex(0);
		} else if (e.getSource() == btnInput) {
			String sname = txtSname.getText().trim();
			String mname = comMajor.getSelectedItem().toString();
			String score = txtScore.getText().trim();
			if (!sname.equals("") && !mname.equals("") && !score.equals("")) {
				int score1 = Integer.parseInt(txtScore.getText().trim());
				if (score1 >= 0 && score1 <= 100) { // ������� ����
					StudentDto insertstd = new StudentDto(sname, mname, score1);
					int result = dao.insertStudent(insertstd);
					if (result == 1) {
						txtPool.setText("�л� ����� �Ϸ�Ǿ����ϴ�.");
						txtSno.setText("");
						txtSname.setText("");
						txtScore.setText("");
						comMajor.setSelectedIndex(0);

					} else {
						txtPool.setText("�л� ��Ͽ� �����Ͽ����ϴ�.");
					}
				} else { // ��������� ����
					txtPool.setText("������ �ٽ� �Է����ּ��� .");
					txtScore.setText("");
				}
			} else {
				txtPool.setText("�̸�, �а�, ���� ��� �Է����ּ���.");
			}

		} else if (e.getSource() == btnUpdate) {
			String s = txtSno.getText().trim();
			if (!s.equals("")) {
				int sno = Integer.parseInt(txtSno.getText().trim());
				StudentDto result1 = dao.selectSno(sno);
				if (result1 != null) {
					String sname = txtSname.getText().trim();
					String mname = (String) comMajor.getSelectedItem();
					int score = Integer.parseInt(txtScore.getText().trim());
					int result2 = dao.updateStudent(new StudentDto(sno, sname, mname, score));
					if (result2 == 1) {
						txtPool.setText("������ �Ϸ�Ǿ����ϴ�.");
						txtSno.setText("");
						txtSname.setText("");
						txtScore.setText("");
						comMajor.setSelectedIndex(0);
					} else {
						txtPool.setText("������ �����߽��ϴ�.");
					}
				} else {
					txtPool.setText("���� �л��� �ƴմϴ�.");
				}
			} else {
				txtPool.setText("�й��� �Է��ϼ���");
			}
		} else if (e.getSource() == btnStudentOut) {
			student = dao.selectStudent();
			if (student.size() == 0) {
				txtPool.setText("�������� �л��� �����ϴ�...");
			} else {
				txtPool.setText("���\t�̸�(�й�)\t\t�а�\t����\n");
				for (int i = 0; i < student.size(); i++) {
					txtPool.append(student.get(i).toString() + "\n");
				}
			}
		} else if (e.getSource() == btnExpelOut) {
			student = dao.selectSexple();
			if (student.size() == 0) {
				txtPool.setText("�������� �л��� �����ϴ�!");
			} else {
				txtPool.setText("���\t�̸�(�й�)\t\t�а�\t����\n");
				for (int i = 0; i < student.size(); i++) {
					txtPool.append(student.get(i).toString() + "\n");
				}
			}
		} else if (e.getSource() == btnExpel) {
			String s = txtSno.getText().trim();
			if (!s.equals("")) {
				int sno = Integer.parseInt(txtSno.getText().trim());
				StudentDto result1 = dao.selectSno(sno);
				if (result1 != null) {
					int result2 = dao.updateSexple(sno);
					if (result2 == 1) {
						txtPool.setText("����ó�� �Ϸ�Ǿ����ϴ�.");
						txtSno.setText("");
					} else {
						txtPool.setText("����ó���� �����Ͽ����ϴ�.");
					}
				} else {
					txtPool.setText("�׷� �й��� ���� �л��� �����ϴ�.");
					txtSno.setText("");
				}
			} else {
				txtPool.setText("�й��� �Է��ϼ���");
			}
		} else if (e.getSource() == btnExit) {
			setVisible(false);
			dispose();
			System.exit(0);
		}

	}

	public static void main(String[] args) {
		new StudentGui("�л����");
	}

}
