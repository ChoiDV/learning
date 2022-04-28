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
		jpup.add(new JLabel("����ȣ", (int) CENTER_ALIGNMENT));
		jpup.add(txtPhone);
		jpup.add(new JLabel(("�� ��"), (int) CENTER_ALIGNMENT));
		jpup.add(txtName);
		jpup.add(new JLabel(("����Ʈ"), (int) CENTER_ALIGNMENT));
		jpup.add(txtPoint);
		contenPane.add(jpup);
		btnJoin = new JButton("����");
		btnSearch = new JButton("����ȸ");
		btnOutput = new JButton("���");
		btnExit = new JButton("����");
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
		if (e.getSource() == btnJoin) { // ȸ������
			String phone = txtPhone.getText().trim();
			String name = txtName.getText().trim();
			if (name.length() < 5 && name.length() > 0 && phone.length() > 10) {
				int result = dao.insertCustomer(phone, name);
				if (result == dao.SUCCESS) {
					txtPool.setText("ȸ�������� �Ϸ�Ǿ����ϴ�.");
					insertClean();
				} else {
					txtPool.setText("ȸ�����Կ� �����Ͽ����ϴ�.");
					insertClean();
				}
			} else {
				txtPool.setText("ȸ�����Կ� �����Ͽ����ϴ�. �̸��� ��ȭ��ȣ�� Ȯ�����ּ���");
				insertClean();
				return;

			}
		} else if (e.getSource() == btnSearch) { // ����ȣ ��ȸ
			String phone = txtPhone.getText().trim();
			if (!phone.equals("")) {
				if (phone.length() >= 4) {
					customer = dao.selectTel(phone);
					if (customer.size() == 0) {
						txtPool.setText(phone + " ���� ������ ȸ���� �����ϴ�. �ٽ��Է����ּ���");
						txtPhone.setText("");
					} else if (customer.size() == 1) {
						txtPhone.setText(customer.get(0).getPhone());
						txtName.setText(customer.get(0).getName());
						txtPoint.setText(String.valueOf(customer.get(0).getPoint()));
						txtPool.setText("");
					} else if (customer.size() > 1) {
						insertClean();
						txtPool.setText("��ȭ��ȣ\t\t�̸�\t����Ʈ\n");
						for (int i = 0; i < customer.size(); i++) {
							txtPool.append(customer.get(i).toString() + "\n");
						}
					}
				} else {
					txtPool.setText("��ȭ��ȣ(FULL or �� 4�ڸ�)�� �� �Է��ϼ���! ");
				}
			} else {
				txtPool.setText("��ȭ��ȣ(FULL or �� 4�ڸ�)�� �Է��ϼ���! ");
			}

		} else if (e.getSource() == btnOutput) { // ��ü��ȸ
			customer = dao.selectAll();
			if (customer.size() == 0) {
				txtPool.setText("������ ȸ���� �����ϴ�");
			} else {
				insertClean();
				txtPool.setText("��ȭ��ȣ\t\t�̸�\t����Ʈ\n");
				for (int i = 0; i < customer.size(); i++) {
					txtPool.append(customer.get(i).toString() + "\n");
				}

			}
		} else if (e.getSource() == btnExit) { // ����
			setVisible(false);
			dispose();
			System.exit(0);
		}

	}

	public static void main(String[] args) {
		new CustomerMng("ȸ������");
	}

}
