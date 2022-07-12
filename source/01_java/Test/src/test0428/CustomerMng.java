package test0428;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CustomerMng extends JFrame implements ActionListener {
	private Container contenPane;
	private JPanel jpup, jpdown;
	private JTextField txtPhone, txtName, txtPoint;
	private JButton btnJoin, btnSearch, btnOutput, btnExit;
	private JTextArea txtPool;
	private JScrollPane scrollPane;

	private CustomerDao dao = CustomerDao.getInstance();
	private ArrayList<CustomerDto> customer;
	private CustomerDto dto;

	public CustomerMng() {
	}

	public CustomerMng(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contenPane = getContentPane();
		contenPane.setLayout(new FlowLayout());
		jpup = new JPanel(new GridLayout(3, 2));
		jpdown = new JPanel();
		txtPhone = new JTextField(15);
		txtName = new JTextField(15);
		txtPoint = new JTextField(15);
		jpup.add(new JLabel("폰번호", (int) CENTER_ALIGNMENT));
		jpup.add(txtPhone);
		jpup.add(new JLabel(("이 름"), (int) CENTER_ALIGNMENT));
		jpup.add(txtName);
		jpup.add(new JLabel(("포인트"), (int) CENTER_ALIGNMENT));
		jpup.add(txtPoint);
		contenPane.add(jpup);
		btnJoin = new JButton("가입");
		btnSearch = new JButton("폰조회");
		btnOutput = new JButton("출력");
		btnExit = new JButton("종료");
		jpdown.add(btnJoin);
		jpdown.add(btnSearch);
		jpdown.add(btnOutput);
		jpdown.add(btnExit);
		txtPool = new JTextArea(15, 30);
		scrollPane = new JScrollPane(txtPool);
		contenPane.add(jpup);
		contenPane.add(jpdown);
		contenPane.add(scrollPane);
		setSize(new Dimension(400, 450));
		setLocation(200, 200);
		setVisible(true);
		btnJoin.addActionListener(this);
		btnSearch.addActionListener(this);
		btnOutput.addActionListener(this);
		btnExit.addActionListener(this);
	}

	private void insertClean() {
		txtPhone.setText("");
		txtName.setText("");
		txtPoint.setText("");
	}

	private void insertCleanAll() {
		txtPhone.setText("");
		txtName.setText("");
		txtPoint.setText("");
		txtPool.setText("");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnJoin) { // 회원가입
			String phone = txtPhone.getText().trim();
			String name = txtName.getText().trim();
			if (name.length() < 5 && name.length() > 0 && phone.length() > 10) {
				int result = dao.insertCustomer(phone, name);
				if (result == dao.SUCCESS) {
					txtPool.setText("회원가입이 완료되었습니다.");
					insertClean();
				} else {
					txtPool.setText("회원가입에 실패하였습니다.");
					insertClean();
				}
			} else {
				txtPool.setText("회원가입에 실패하였습니다. 이름과 전화번호를 확인해주세요");
				insertClean();
				return;

			}
		} else if (e.getSource() == btnSearch) { // 폰번호 조회
			String phone = txtPhone.getText().trim();
			if (!phone.equals("")) {
				if (phone.length() >= 4) {
					customer = dao.selectTel(phone);
					if (customer.size() == 0) {
						txtPool.setText(phone + " 으로 가입한 회원은 없습니다. 다시입력해주세요");
						txtPhone.setText("");
					} else if (customer.size() == 1) {
						txtPhone.setText(customer.get(0).getPhone());
						txtName.setText(customer.get(0).getName());
						txtPoint.setText(String.valueOf(customer.get(0).getPoint()));
						txtPool.setText("");
					} else if (customer.size() > 1) {
						insertClean();
						txtPool.setText("전화번호\t\t이름\t포인트\n");
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

		} else if (e.getSource() == btnOutput) { // 전체조회
			customer = dao.selectAll();
			if (customer.size() == 0) {
				txtPool.setText("가입한 회원이 없습니다");
			} else {
				insertClean();
				txtPool.setText("전화번호\t\t이름\t포인트\n");
				for (int i = 0; i < customer.size(); i++) {
					txtPool.append(customer.get(i).toString() + "\n");
				}

			}
		} else if (e.getSource() == btnExit) { // 종료
			setVisible(false);
			dispose();
			System.exit(0);
		}

	}

	public static void main(String[] args) {
		new CustomerMng("회원관리");
	}

}
