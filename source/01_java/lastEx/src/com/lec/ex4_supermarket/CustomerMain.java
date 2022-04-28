package com.lec.ex4_supermarket;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;

import com.lec.ex3_student.StudentDao;
import com.lec.ex3_student.StudentDto;

public class CustomerMain extends JFrame implements ActionListener {
	private Container container;
	private JPanel jpup, jpbtn;
	private JTextField txtCId, txtCTel, txtCName, txtCPoint, txtCAmount;
	private Vector<String> levelNames;
	private JComboBox<String> comLevelName;
	private JButton btnCIdSearch, btnCTelSearch, btnCNameSearch, btnBuyWithPoint, btnBuy, btnLevelNameOutput,
			btnAllOutput, btnInsert, btnCTelUpdate, btnDelete, btnExit;
	private JTextArea txtPool;
	private JScrollPane scrollPane;

	private CustomerDao dao = CustomerDao.getInstance();
	private ArrayList<CustomerDto> customer;

	public CustomerMain() {
	}

	public CustomerMain(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		container = getContentPane();
		container.setLayout(new FlowLayout());
		jpup = new JPanel(new GridLayout(6, 3));
		jpbtn = new JPanel();
		txtCId = new JTextField(20);
		txtCTel = new JTextField(20);
		txtCName = new JTextField(20);
		txtCPoint = new JTextField(20);
		txtCAmount = new JTextField(20);
		levelNames = dao.selectLevelNames();
		comLevelName = new JComboBox<String>(levelNames);
		btnCIdSearch = new JButton("아이디 검색");
		btnCTelSearch = new JButton("폰4자리(FULL) 검색");
		btnCNameSearch = new JButton("고객 이름 검색");
		btnBuyWithPoint = new JButton("포인트로만 구매");
		jpup.add(new JLabel(" 아 이 디 ", (int) CENTER_ALIGNMENT));
		jpup.add(txtCId);
		jpup.add(btnCIdSearch);
		jpup.add(new JLabel("고 객 전 화", (int) CENTER_ALIGNMENT));
		jpup.add(txtCTel);
		jpup.add(btnCTelSearch);
		jpup.add(new JLabel("고 객 이 름", (int) CENTER_ALIGNMENT));
		jpup.add(txtCName);
		jpup.add(btnCNameSearch);
		jpup.add(new JLabel("포 인 트", (int) CENTER_ALIGNMENT));
		jpup.add(txtCPoint);
		jpup.add(btnBuyWithPoint);
		jpup.add(new JLabel("구 매 금 액", (int) CENTER_ALIGNMENT));
		jpup.add(txtCAmount);
		jpup.add(new JLabel(""));// 빈 라벨 추가하는 부분
		jpup.add(new JLabel("고 객 등 급", (int) CENTER_ALIGNMENT));
		jpup.add(comLevelName);
		btnBuy = new JButton("물품 구매");
		btnLevelNameOutput = new JButton("등급별출력");
		btnAllOutput = new JButton("전체출력");
		btnInsert = new JButton("회원가입");
		btnCTelUpdate = new JButton("번호수정");
		btnDelete = new JButton("회원탈퇴");
		btnExit = new JButton("나가기");
		jpbtn.add(btnBuy);
		jpbtn.add(btnLevelNameOutput);
		jpbtn.add(btnAllOutput);
		jpbtn.add(btnInsert);
		jpbtn.add(btnCTelUpdate);
		jpbtn.add(btnDelete);
		jpbtn.add(btnExit);
		txtPool = new JTextArea(6, 70);
		scrollPane = new JScrollPane(txtPool);
		container.add(jpup);
		container.add(jpbtn);
		container.add(scrollPane);
		setSize(new Dimension(800, 400));
		setLocation(200, 200);
		setVisible(true);
		txtPool.setText("\t★ ★ ★ 고객검색 후 구매하세요 ★ ★ ★");

		btnCIdSearch.addActionListener(this);
		btnCTelSearch.addActionListener(this);
		btnCNameSearch.addActionListener(this);
		btnBuyWithPoint.addActionListener(this);
		btnBuy.addActionListener(this);
		btnLevelNameOutput.addActionListener(this);
		btnAllOutput.addActionListener(this);
		btnInsert.addActionListener(this);
		btnCTelUpdate.addActionListener(this);
		btnDelete.addActionListener(this);
		btnExit.addActionListener(this);
	}

	private void insertClean() {
		txtCAmount.setText("");
		txtCId.setText("");
		txtCName.setText("");
		txtCPoint.setText("");
		txtCTel.setText("");
		comLevelName.setSelectedIndex(0);
	}

	private void insertCleanAll() {
		txtCAmount.setText("");
		txtCId.setText("");
		txtCName.setText("");
		txtCPoint.setText("");
		txtCTel.setText("");
		comLevelName.setSelectedIndex(0);
		txtPool.setText("");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCIdSearch) { // 아이디 검색
			int cid;
			try {
				cid = Integer.parseInt(txtCId.getText().trim());
			} catch (Exception e2) {
				txtPool.setText("유효한 고객 ID를 입력하신후 검색하세요.");
				txtCId.setText("");
				return;
			}
			CustomerDto dto = dao.selectID(cid);
			if (dto != null) {
				txtCName.setText(dto.getCname());
				txtCTel.setText(dto.getCtel());
				txtCPoint.setText(String.valueOf(dto.getCpoint()));
				comLevelName.setSelectedItem(dto.getLevelName());
				txtPool.setText(String.valueOf("다음 등급까지 남은 금액 : " + dto.getForLevelUp()) + " 원\n");
				txtPool.append(String.valueOf("누적금액 : " + dto.getCamount()) + " 원");
			} else {
				txtPool.setText("존재하지 않는 아이디입니다.");
				txtCId.setText("");
			}

		} else if (e.getSource() == btnCTelSearch) { // 전화번호 검색
			String ctel = txtCTel.getText().trim();
			if (!ctel.equals("")) {
				if (ctel.length() >= 4) {
					customer = dao.selectTel(ctel);
					if (customer.size() == 0) {
						txtPool.setText(ctel + "로 가입한 회원은 없습니다.");
					} else if (customer.size() == 1) {
						txtCId.setText(String.valueOf(customer.get(0).getCid()));
						txtCName.setText(customer.get(0).getCname());
						txtCTel.setText(customer.get(0).getCtel());
						txtCPoint.setText(String.valueOf(customer.get(0).getCpoint()));
						comLevelName.setSelectedItem(customer.get(0).getLevelName());
						txtPool.setText(String.valueOf("다음 등급까지 남은금액 : " + customer.get(0).getForLevelUp()) + " 원\n");
						txtPool.append(String.valueOf("누적금액 : " + customer.get(0).getCamount()) + " 원");
					} else if (customer.size() > 1) {
						txtCTel.setText("");
						txtPool.setText("아이디\t전화번호\t\t이름\t포인트\t누적금액\t등급\t다음등급까지 남은금액\n");
						for (int i = 0; i < customer.size(); i++) {
							txtPool.append(customer.get(i).toString() + "\n");
						}
					}
				} else {
					txtPool.setText("전화번호(FULL or 뒤 4자리)를 꼭 입력하세요! ");
				}
			} else {
				txtPool.setText("전화번호(FULL or 뒤 4자리)를 입력하세요! ");
			}
		} else if (e.getSource() == btnCNameSearch) { // 이름 검색
			String name = txtCName.getText().trim();
			if (!name.equals("")) {
				customer = dao.selectName(name);
				if (customer.size() == 0) {
					txtPool.setText(name + " 이름으로 가입한 회원은 없습니다.");
				} else if (customer.size() == 1) {
					txtCId.setText(String.valueOf(customer.get(0).getCid()));
					txtCTel.setText(customer.get(0).getCtel());
					txtCPoint.setText(String.valueOf(customer.get(0).getCpoint()));
					comLevelName.setSelectedItem(customer.get(0).getLevelName());
					txtPool.setText(String.valueOf("다음 등급까지 남은금액 : " + customer.get(0).getForLevelUp()) + " 원\n");
					txtPool.append(String.valueOf("누적금액 : " + customer.get(0).getCamount()) + " 원");
				} else if (customer.size() > 1) {
					txtCTel.setText("");
					txtPool.setText("아이디\t전화번호\t\t이름\t포인트\t누적금액\t등급\t다음등급까지 남은금액\n");
					for (int i = 0; i < customer.size(); i++) {
						txtPool.append(customer.get(i).toString() + "\n");
					}
				}
			} else {
				txtPool.setText("이름을 입력하세요!!!");
			}
		} else if (e.getSource() == btnBuyWithPoint) {  // 포인트로만 구매 
			int amount;
			int cid;
			String id = txtCId.getText().trim();
			String mount = txtCAmount.getText().trim();
			if (!id.equals("") && !mount.equals("")) {
				try {
					cid = Integer.parseInt(txtCId.getText().trim());
					amount = Integer.parseInt(txtCAmount.getText().trim());
					CustomerDto dto = dao.selectID(cid);
					int point = dto.getCpoint();
					if (point > amount) {
						int result = dao.buyWithPoint(cid, amount);
						txtPool.setText("결제가 완료되었습니다.\n");
						txtCId.setText("");
						txtCAmount.setText("");
						CustomerDto dto2 = dao.selectID(cid);
						txtPool.append(dto.getCname() + " 님의 남은 포인트 : " + dto.getCpoint() + " 점 입니다.");

					} else {
						txtPool.setText("포인트가 부족합니다");
					}
				} catch (Exception e2) {
					txtPool.setText("유효한 ID를 입력하세요.");

				}
			} else {
				txtPool.setText("아이디와 금액을 입력하세요");
			}

		} else if (e.getSource() == btnBuy) {  // 구매 
			int cid;
			int amount;
			String id = txtCId.getText().trim();
			String mount = txtCAmount.getText().trim();
			if (!id.equals("") && !id.equals("")) {
				try {
					cid = Integer.parseInt(id);
					amount = Integer.parseInt(mount);
					int result = dao.buy(cid, amount);
					txtPool.setText("구매가 완료되었습니다.\n");
					insertClean();
					CustomerDto dto = dao.selectID(cid);
					txtPool.append("아이디\t전화번호\t\t이름\t포인트\t누적금액\t등급\t다음등급까지 남은금액\n");
					txtPool.append(dto.toString());
				} catch (Exception e2) {
					txtPool.setText("유효한 ID와 금액을 확인하세요");
				}
			} else {
				txtPool.setText("ID 와 금액을 입력하고 구매하세요.");
			}
		} else if (e.getSource() == btnLevelNameOutput) {  // 등급이름으로 조회
			insertClean();
			String levelName = (String) comLevelName.getSelectedItem();
			if (!levelName.equals("")) {
				customer = dao.selectLevelName(levelName);
				txtPool.setText("아이디\t전화번호\t\t이름\t포인트\t누적금액\t등급\t다음등급까지 남은금액\n");
				for (int i = 0; i < customer.size(); i++) {
					txtPool.append(customer.get(i).toString() + "\n");
				}
			} else {
				txtPool.setText("등급을 선택하세요");
			}
		} else if (e.getSource() == btnAllOutput) {  // 전체회원 조회 
			insertClean();
			customer = dao.selectAll();
			if (customer.size() == 0) {
				txtPool.setText("가입한 회원이 없습니다.");
			} else {
				txtPool.setText("아이디\t전화번호\t\t이름\t포인트\t누적금액\t등급\t다음등급까지 남은금액\n");
				for (int i = 0; i < customer.size(); i++) {
					txtPool.append(customer.get(i).toString() + "\n");
				}
				txtPool.append("이상 "+customer.size()+" 명");
			}
		} else if (e.getSource() == btnInsert) { // 회원가입
			String ctel = txtCTel.getText().trim();
			String cname = txtCName.getText().trim();
			if (!ctel.equals("") && !cname.equals("") && ctel.length() >= 12) {
				int result = dao.insertCustomer(ctel, cname);
				txtPool.setText("회원가입이 완료되었습니다.\n");
				insertClean();
			} else {
				txtPool.setText("이름과 전화번호는 필수로 입력해야합니다.");
				txtPool.append(" (이름 , 전화번호 ( 010-1111-1111 ) 형식) ");
			}

		} else if (e.getSource() == btnCTelUpdate) {  // 전화번호 수정
			String cid = txtCId.getText().trim();
			String ctel = txtCTel.getText().trim();
			if (!cid.equals("") && !ctel.equals("")) {
				try {
					int cid2 = Integer.parseInt(cid);
					int result = dao.updateCustomer(cid2, ctel);
					if (result == CustomerDao.SUCCESS) {
						txtPool.setText("수정 완료되었습니다.");
						insertClean();
					} else {
						txtPool.setText("아이디가 잘못되었습니다.");
					}

				} catch (Exception e2) {
					txtPool.setText("올바른 아이디와 전화번호를 입력하세요!!!");
				}
			} else {
				txtPool.setText("아이디와 전화번호를 입력해야 수정할 수 있습니다.");
			}
		} else if (e.getSource() == btnDelete) {   // 전화번호 수정
			String ctel = txtCTel.getText().trim();
			if (!ctel.equals("")) {
				int result = dao.deleteCustomer(ctel);
				if (result == CustomerDao.SUCCESS) {
					txtPool.setText("회원탈퇴가 완료되었습니다.");
				} else {
					txtPool.setText(ctel +"번호로 가입된 회원이 없습니다.");
				}
			} else {
				txtPool.setText("번호를 입력하세요");
			}
		} else if( e.getSource() == btnExit) {  // 종료
			setVisible(false);
			dispose();
			System.exit(0);
		}

	}

	public static void main(String[] args) {
		new CustomerMain("슈퍼마켓 관리");
	}

}
