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
		btnCIdSearch = new JButton("���̵� �˻�");
		btnCTelSearch = new JButton("��4�ڸ�(FULL) �˻�");
		btnCNameSearch = new JButton("�� �̸� �˻�");
		btnBuyWithPoint = new JButton("����Ʈ�θ� ����");
		jpup.add(new JLabel(" �� �� �� ", (int) CENTER_ALIGNMENT));
		jpup.add(txtCId);
		jpup.add(btnCIdSearch);
		jpup.add(new JLabel("�� �� �� ȭ", (int) CENTER_ALIGNMENT));
		jpup.add(txtCTel);
		jpup.add(btnCTelSearch);
		jpup.add(new JLabel("�� �� �� ��", (int) CENTER_ALIGNMENT));
		jpup.add(txtCName);
		jpup.add(btnCNameSearch);
		jpup.add(new JLabel("�� �� Ʈ", (int) CENTER_ALIGNMENT));
		jpup.add(txtCPoint);
		jpup.add(btnBuyWithPoint);
		jpup.add(new JLabel("�� �� �� ��", (int) CENTER_ALIGNMENT));
		jpup.add(txtCAmount);
		jpup.add(new JLabel(""));// �� �� �߰��ϴ� �κ�
		jpup.add(new JLabel("�� �� �� ��", (int) CENTER_ALIGNMENT));
		jpup.add(comLevelName);
		btnBuy = new JButton("��ǰ ����");
		btnLevelNameOutput = new JButton("��޺����");
		btnAllOutput = new JButton("��ü���");
		btnInsert = new JButton("ȸ������");
		btnCTelUpdate = new JButton("��ȣ����");
		btnDelete = new JButton("ȸ��Ż��");
		btnExit = new JButton("������");
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
		txtPool.setText("\t�� �� �� ���˻� �� �����ϼ��� �� �� ��");

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
		if (e.getSource() == btnCIdSearch) { // ���̵� �˻�
			int cid;
			try {
				cid = Integer.parseInt(txtCId.getText().trim());
			} catch (Exception e2) {
				txtPool.setText("��ȿ�� �� ID�� �Է��Ͻ��� �˻��ϼ���.");
				txtCId.setText("");
				return;
			}
			CustomerDto dto = dao.selectID(cid);
			if (dto != null) {
				txtCName.setText(dto.getCname());
				txtCTel.setText(dto.getCtel());
				txtCPoint.setText(String.valueOf(dto.getCpoint()));
				comLevelName.setSelectedItem(dto.getLevelName());
				txtPool.setText(String.valueOf("���� ��ޱ��� ���� �ݾ� : " + dto.getForLevelUp()) + " ��\n");
				txtPool.append(String.valueOf("�����ݾ� : " + dto.getCamount()) + " ��");
			} else {
				txtPool.setText("�������� �ʴ� ���̵��Դϴ�.");
				txtCId.setText("");
			}

		} else if (e.getSource() == btnCTelSearch) { // ��ȭ��ȣ �˻�
			String ctel = txtCTel.getText().trim();
			if (!ctel.equals("")) {
				if (ctel.length() >= 4) {
					customer = dao.selectTel(ctel);
					if (customer.size() == 0) {
						txtPool.setText(ctel + "�� ������ ȸ���� �����ϴ�.");
					} else if (customer.size() == 1) {
						txtCId.setText(String.valueOf(customer.get(0).getCid()));
						txtCName.setText(customer.get(0).getCname());
						txtCTel.setText(customer.get(0).getCtel());
						txtCPoint.setText(String.valueOf(customer.get(0).getCpoint()));
						comLevelName.setSelectedItem(customer.get(0).getLevelName());
						txtPool.setText(String.valueOf("���� ��ޱ��� �����ݾ� : " + customer.get(0).getForLevelUp()) + " ��\n");
						txtPool.append(String.valueOf("�����ݾ� : " + customer.get(0).getCamount()) + " ��");
					} else if (customer.size() > 1) {
						txtCTel.setText("");
						txtPool.setText("���̵�\t��ȭ��ȣ\t\t�̸�\t����Ʈ\t�����ݾ�\t���\t������ޱ��� �����ݾ�\n");
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
		} else if (e.getSource() == btnCNameSearch) { // �̸� �˻�
			String name = txtCName.getText().trim();
			if (!name.equals("")) {
				customer = dao.selectName(name);
				if (customer.size() == 0) {
					txtPool.setText(name + " �̸����� ������ ȸ���� �����ϴ�.");
				} else if (customer.size() == 1) {
					txtCId.setText(String.valueOf(customer.get(0).getCid()));
					txtCTel.setText(customer.get(0).getCtel());
					txtCPoint.setText(String.valueOf(customer.get(0).getCpoint()));
					comLevelName.setSelectedItem(customer.get(0).getLevelName());
					txtPool.setText(String.valueOf("���� ��ޱ��� �����ݾ� : " + customer.get(0).getForLevelUp()) + " ��\n");
					txtPool.append(String.valueOf("�����ݾ� : " + customer.get(0).getCamount()) + " ��");
				} else if (customer.size() > 1) {
					txtCTel.setText("");
					txtPool.setText("���̵�\t��ȭ��ȣ\t\t�̸�\t����Ʈ\t�����ݾ�\t���\t������ޱ��� �����ݾ�\n");
					for (int i = 0; i < customer.size(); i++) {
						txtPool.append(customer.get(i).toString() + "\n");
					}
				}
			} else {
				txtPool.setText("�̸��� �Է��ϼ���!!!");
			}
		} else if (e.getSource() == btnBuyWithPoint) {  // ����Ʈ�θ� ���� 
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
						txtPool.setText("������ �Ϸ�Ǿ����ϴ�.\n");
						txtCId.setText("");
						txtCAmount.setText("");
						CustomerDto dto2 = dao.selectID(cid);
						txtPool.append(dto.getCname() + " ���� ���� ����Ʈ : " + dto.getCpoint() + " �� �Դϴ�.");

					} else {
						txtPool.setText("����Ʈ�� �����մϴ�");
					}
				} catch (Exception e2) {
					txtPool.setText("��ȿ�� ID�� �Է��ϼ���.");

				}
			} else {
				txtPool.setText("���̵�� �ݾ��� �Է��ϼ���");
			}

		} else if (e.getSource() == btnBuy) {  // ���� 
			int cid;
			int amount;
			String id = txtCId.getText().trim();
			String mount = txtCAmount.getText().trim();
			if (!id.equals("") && !id.equals("")) {
				try {
					cid = Integer.parseInt(id);
					amount = Integer.parseInt(mount);
					int result = dao.buy(cid, amount);
					txtPool.setText("���Ű� �Ϸ�Ǿ����ϴ�.\n");
					insertClean();
					CustomerDto dto = dao.selectID(cid);
					txtPool.append("���̵�\t��ȭ��ȣ\t\t�̸�\t����Ʈ\t�����ݾ�\t���\t������ޱ��� �����ݾ�\n");
					txtPool.append(dto.toString());
				} catch (Exception e2) {
					txtPool.setText("��ȿ�� ID�� �ݾ��� Ȯ���ϼ���");
				}
			} else {
				txtPool.setText("ID �� �ݾ��� �Է��ϰ� �����ϼ���.");
			}
		} else if (e.getSource() == btnLevelNameOutput) {  // ����̸����� ��ȸ
			insertClean();
			String levelName = (String) comLevelName.getSelectedItem();
			if (!levelName.equals("")) {
				customer = dao.selectLevelName(levelName);
				txtPool.setText("���̵�\t��ȭ��ȣ\t\t�̸�\t����Ʈ\t�����ݾ�\t���\t������ޱ��� �����ݾ�\n");
				for (int i = 0; i < customer.size(); i++) {
					txtPool.append(customer.get(i).toString() + "\n");
				}
			} else {
				txtPool.setText("����� �����ϼ���");
			}
		} else if (e.getSource() == btnAllOutput) {  // ��üȸ�� ��ȸ 
			insertClean();
			customer = dao.selectAll();
			if (customer.size() == 0) {
				txtPool.setText("������ ȸ���� �����ϴ�.");
			} else {
				txtPool.setText("���̵�\t��ȭ��ȣ\t\t�̸�\t����Ʈ\t�����ݾ�\t���\t������ޱ��� �����ݾ�\n");
				for (int i = 0; i < customer.size(); i++) {
					txtPool.append(customer.get(i).toString() + "\n");
				}
				txtPool.append("�̻� "+customer.size()+" ��");
			}
		} else if (e.getSource() == btnInsert) { // ȸ������
			String ctel = txtCTel.getText().trim();
			String cname = txtCName.getText().trim();
			if (!ctel.equals("") && !cname.equals("") && ctel.length() >= 12) {
				int result = dao.insertCustomer(ctel, cname);
				txtPool.setText("ȸ�������� �Ϸ�Ǿ����ϴ�.\n");
				insertClean();
			} else {
				txtPool.setText("�̸��� ��ȭ��ȣ�� �ʼ��� �Է��ؾ��մϴ�.");
				txtPool.append(" (�̸� , ��ȭ��ȣ ( 010-1111-1111 ) ����) ");
			}

		} else if (e.getSource() == btnCTelUpdate) {  // ��ȭ��ȣ ����
			String cid = txtCId.getText().trim();
			String ctel = txtCTel.getText().trim();
			if (!cid.equals("") && !ctel.equals("")) {
				try {
					int cid2 = Integer.parseInt(cid);
					int result = dao.updateCustomer(cid2, ctel);
					if (result == CustomerDao.SUCCESS) {
						txtPool.setText("���� �Ϸ�Ǿ����ϴ�.");
						insertClean();
					} else {
						txtPool.setText("���̵� �߸��Ǿ����ϴ�.");
					}

				} catch (Exception e2) {
					txtPool.setText("�ùٸ� ���̵�� ��ȭ��ȣ�� �Է��ϼ���!!!");
				}
			} else {
				txtPool.setText("���̵�� ��ȭ��ȣ�� �Է��ؾ� ������ �� �ֽ��ϴ�.");
			}
		} else if (e.getSource() == btnDelete) {   // ��ȭ��ȣ ����
			String ctel = txtCTel.getText().trim();
			if (!ctel.equals("")) {
				int result = dao.deleteCustomer(ctel);
				if (result == CustomerDao.SUCCESS) {
					txtPool.setText("ȸ��Ż�� �Ϸ�Ǿ����ϴ�.");
				} else {
					txtPool.setText(ctel +"��ȣ�� ���Ե� ȸ���� �����ϴ�.");
				}
			} else {
				txtPool.setText("��ȣ�� �Է��ϼ���");
			}
		} else if( e.getSource() == btnExit) {  // ����
			setVisible(false);
			dispose();
			System.exit(0);
		}

	}

	public static void main(String[] args) {
		new CustomerMain("���۸��� ����");
	}

}
