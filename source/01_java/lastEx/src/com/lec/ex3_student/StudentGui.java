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
		btnSNoSearch = new JButton("학번검색");
		btnSNameSearch = new JButton("이름검색");
		btnMNameSearch = new JButton("전공검색");
		btnclean = new JButton("지우기");
		btnSNoSearch.setPreferredSize(new Dimension(100, 50));
		btnSNameSearch.setPreferredSize(new Dimension(100, 50));
		btnMNameSearch.setPreferredSize(new Dimension(100, 50));
		btnclean.setPreferredSize(new Dimension(100, 50));
		// 두번쨰 패널
		btnInput = new JButton("학생입력");
		btnUpdate = new JButton("학생수정");
		btnStudentOut = new JButton("학생출력");
		btnExpelOut = new JButton("제적자출력");
		btnExpel = new JButton("제적처리");
		btnExit = new JButton("종료");
		btnInput.setPreferredSize(new Dimension(100, 50));
		btnUpdate.setPreferredSize(new Dimension(100, 50));
		btnStudentOut.setPreferredSize(new Dimension(100, 50));
		btnExpelOut.setPreferredSize(new Dimension(100, 50));
		btnExpel.setPreferredSize(new Dimension(100, 50));
		btnExit.setPreferredSize(new Dimension(100, 50));
		txtPool = new JTextArea(10, 50);
		scrollPane = new JScrollPane(txtPool);
		// 컴포넌트 화면 추가
		jpup.add(new JLabel("학번", (int) CENTER_ALIGNMENT));
		jpup.add(txtSno);
		jpup.add(btnSNoSearch);
		jpup.add(new JLabel("이름", (int) CENTER_ALIGNMENT));
		jpup.add(txtSname);
		jpup.add(btnSNameSearch);
		jpup.add(new JLabel("전공", (int) CENTER_ALIGNMENT));
		jpup.add(comMajor);
		jpup.add(btnMNameSearch);
		jpup.add(new JLabel("점수", (int) CENTER_ALIGNMENT));
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
					txtPool.setText("없는 학번입니다.");
					txtSno.setText("");
				}
			} else {
				txtPool.setText("학번을 입력하세요.");
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
					txtPool.setText("저희 학생이 아닙니다.");
					txtSname.setText("");
				} else if (student.size() > 1) {
					comMajor.setSelectedIndex(0);
					txtPool.setText("학번\t이름\t학과\t점수\n");
					for (int i = 0; i < student.size(); i++) {
						txtPool.append(student.get(i).toString() + "\n");
					}
					txtSname.setText("");
				}
			} else {
				txtPool.setText("이름을 입력하세요.");
			}

		} else if (e.getSource() == btnMNameSearch) {
			String mname = comMajor.getSelectedItem().toString();
			if (!mname.equals("")) {
				student = dao.selectMname(mname);
				if (student.size() == 0) {
					txtPool.setText(mname + " 학과에 재학중인 학생이 없습니다.");
				} else {
					txtPool.setText("등수\t이름(학번)\t\t학과\t점수\n");
					for (int i = 0; i < student.size(); i++) {
						txtPool.append(student.get(i).toString() + "\n");
					}
				}
			} else {
				txtPool.setText("전공을 선택하세요.");
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
				if (score1 >= 0 && score1 <= 100) { // 정상범위 점수
					StudentDto insertstd = new StudentDto(sname, mname, score1);
					int result = dao.insertStudent(insertstd);
					if (result == 1) {
						txtPool.setText("학생 등록이 완료되었습니다.");
						txtSno.setText("");
						txtSname.setText("");
						txtScore.setText("");
						comMajor.setSelectedIndex(0);

					} else {
						txtPool.setText("학생 등록에 실패하였습니다.");
					}
				} else { // 비정상범위 점수
					txtPool.setText("점수를 다시 입력해주세요 .");
					txtScore.setText("");
				}
			} else {
				txtPool.setText("이름, 학과, 점수 모두 입력해주세요.");
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
						txtPool.setText("수정이 완료되었습니다.");
						txtSno.setText("");
						txtSname.setText("");
						txtScore.setText("");
						comMajor.setSelectedIndex(0);
					} else {
						txtPool.setText("수정에 실패했습니다.");
					}
				} else {
					txtPool.setText("저희 학생이 아닙니다.");
				}
			} else {
				txtPool.setText("학번을 입력하세요");
			}
		} else if (e.getSource() == btnStudentOut) {
			student = dao.selectStudent();
			if (student.size() == 0) {
				txtPool.setText("재학중인 학생이 없습니다...");
			} else {
				txtPool.setText("등수\t이름(학번)\t\t학과\t점수\n");
				for (int i = 0; i < student.size(); i++) {
					txtPool.append(student.get(i).toString() + "\n");
				}
			}
		} else if (e.getSource() == btnExpelOut) {
			student = dao.selectSexple();
			if (student.size() == 0) {
				txtPool.setText("제적중인 학생이 없습니다!");
			} else {
				txtPool.setText("등수\t이름(학번)\t\t학과\t점수\n");
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
						txtPool.setText("제적처리 완료되었습니다.");
						txtSno.setText("");
					} else {
						txtPool.setText("제적처리에 실패하였습니다.");
					}
				} else {
					txtPool.setText("그런 학번을 가진 학생은 없습니다.");
					txtSno.setText("");
				}
			} else {
				txtPool.setText("학번을 입력하세요");
			}
		} else if (e.getSource() == btnExit) {
			setVisible(false);
			dispose();
			System.exit(0);
		}

	}

	public static void main(String[] args) {
		new StudentGui("학사관리");
	}

}
