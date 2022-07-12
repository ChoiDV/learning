package com.lec.ex2_person_dto_dao;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PersonMngGUI extends JFrame implements ActionListener {
	// 화면에 들어갈 컴포넌트
	private Container contenPane;
	private JPanel jpup, jpbtn;
	private JTextField txtName, txtKor, txtEng, txtMat;
	private Vector<String> jnames;
	private JComboBox<String> comJob;
	private JButton btnInput, btnSearch, btnOutput, btnExit;
	private JTextArea txtPool;
	private JScrollPane scrollPane;
	// DB 관련
	private PersonDao dao = PersonDao.getInstance();
	private ArrayList<PersonDto> person;

	public PersonMngGUI(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE); // X클릭시 종료
		contenPane = getContentPane();
		contenPane.setLayout(new FlowLayout()); // contenPane의 기본 레이아웃은 BroderLayout
		jpup = new JPanel(new GridLayout(5, 2));
		jpbtn = new JPanel();
		txtName = new JTextField(20);
		jnames = dao.jnameList();
		comJob = new JComboBox<String>(jnames); // 직업명 목록이 콤보박스에
		txtKor = new JTextField(20);
		txtEng = new JTextField(20);
		txtMat = new JTextField(20);
		ImageIcon icon1 = new ImageIcon("icon/icon/join.png");
		btnInput = new JButton("입력", icon1);
		ImageIcon icon2 = new ImageIcon("icon/icon/search.png");
		btnSearch = new JButton("직업조회", icon2);
		ImageIcon icon3 = new ImageIcon("icon/icon/output.png");
		btnOutput = new JButton("전체출력", icon3);
		ImageIcon icon4 = new ImageIcon("icon/icon/exit.png");
		btnExit = new JButton("종료", icon4);
		btnInput.setPreferredSize(new Dimension(150, 50));
		btnSearch.setPreferredSize(new Dimension(150, 50));
		btnOutput.setPreferredSize(new Dimension(150, 50));
		btnExit.setPreferredSize(new Dimension(150, 50));
		txtPool = new JTextArea(10, 60);
		scrollPane = new JScrollPane(txtPool);
		// 생성된 콤포넌트 화면 추가
		jpup.add(new JLabel("이름", (int) CENTER_ALIGNMENT));
		jpup.add(txtName);
		jpup.add(new JLabel("직업", (int) CENTER_ALIGNMENT));
		jpup.add(comJob);
		jpup.add(new JLabel("국어", (int) CENTER_ALIGNMENT));
		jpup.add(txtKor);
		jpup.add(new JLabel("영어", (int) CENTER_ALIGNMENT));
		jpup.add(txtEng);
		jpup.add(new JLabel("수학", (int) CENTER_ALIGNMENT));
		jpup.add(txtMat);
		jpbtn.add(btnInput); // jpbtn : FlowLayout
		jpbtn.add(btnSearch);
		jpbtn.add(btnOutput);
		jpbtn.add(btnExit);
		contenPane.add(jpup); // contenPane : FlowLayout
		contenPane.add(jpbtn);
		contenPane.add(scrollPane);
		setSize(new Dimension(700, 450));
		setLocation(200, 150);
		setVisible(true);
		btnInput.addActionListener(this);
		btnSearch.addActionListener(this);
		btnOutput.addActionListener(this);
		btnExit.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnInput) {  // txtName, comJob, txtKor, txtEng, txtMat
			String pname = txtName.getText().trim();
			String jname = comJob.getSelectedItem().toString();
			// int jno = comJob.getSelectedIndex()*10;
			String korStr = txtKor.getText().trim();
			String engStr = txtEng.getText().trim();
			String matStr = txtMat.getText().trim();
			if(pname.equals("") ||jname.equals("") || korStr.equals("") || engStr.equals("") ||
					matStr.equals("")) {
				txtPool.setText("이름,직업,국어,영어,수학 모두 입력하셔야 입력 가능합니다.");
				return;
			} 
			int kor = Integer.parseInt(korStr);
			int eng = Integer.parseInt(engStr);
			int mat = Integer.parseInt(matStr);
			PersonDto newPerson = new PersonDto(pname,jname,kor,eng,mat);
			int result = dao.insertPerson(newPerson);
			if(result == PersonDao.SUCCESS) {
				txtPool.setText(pname+" 님 입력성공");
				txtName.setText("");
				comJob.setSelectedIndex(0); // 콤보박스를 0번째 선택
//				comJob.setSelectedItem("");  // 콤보박스를 ""이 있는것으로 선택 
				txtKor.setText("");
				txtEng.setText("");
				txtMat.setText("");
				
			} 		
		} else if (e.getSource() == btnSearch) { // comJob에 선택된 직업조회 결과를 txtPool
			String jname = comJob.getSelectedItem().toString();
			if(jname.equals("")) {
				txtPool.setText("직업 선택 후 직업조회하세요.");
				return;
			}
			person = dao.selectJname(jname);
			if (person.size() != 0) {
				txtPool.setText("등수\t이름\t직업\t국어\t영어\t수학\t총점\n");
				for( PersonDto dto : person) {
					txtPool.append(dto.toString() + "\n");
				}
			} else {
				txtPool.setText("해당 직업군의 인원이 없습니다.");
			}
				
		} else if (e.getSource() == btnOutput) { // 전체 조회 결과를 txtPool로
			person = dao.selectAll();
			if(person.size() != 0) {
				txtPool.setText("등수\t이름\t직업\t국어\t영어\t수학\t총점\n");
				for( PersonDto dto : person) {
					txtPool.append(dto.toString()+"\n");
				}
			}
		} else if (e.getSource() == btnExit) {
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		new PersonMngGUI("연에인 성적관리");
	}

}
