package com.lec.ex3_account;

public class Account {
	// ������� Ŭ���� ����
	private String accountNo; // ���¹�ȣ
	private String ownerName; // ������
	private long balance; // �ܾ�

	public Account() {
	};  // ���¹�ȣ�� �޴� ������
	public Account(String accountNo) {
		this.ownerName = ownerName;
		this.accountNo = accountNo;
		System.out.println("������ : " + ownerName + " �� ");
		System.out.println("���� ��ȣ : " + accountNo);
		System.out.println(ownerName + " ���� �ܾ��� : " + this.balance + " �� �Դϴ�.");
		System.out.println(ownerName + " �� ���� ���� �����մϴ�.\n");
	} // �̸�,���¹�ȣ �޴� ������
	public Account(String ownerName, String accountNo) {
		this.ownerName = ownerName;
		this.accountNo = accountNo;
		System.out.println("������ : " + ownerName + " �� ");
		System.out.println("���� ��ȣ : " + accountNo);
		System.out.println(ownerName + " ���� �ܾ��� : " + this.balance + " �� �Դϴ�.");
		System.out.println(ownerName + " �� ���� ���� �����մϴ�.\n");
	}

	public Account(String ownerName, String accountNo, long balance) {
		this.ownerName = ownerName;
		this.accountNo = accountNo;
		this.balance = balance;
		System.out.println("������ : " + ownerName + " �� ");
		System.out.println("���� ��ȣ : " + accountNo);
		System.out.println(balance + " �� �Ա� �Ǽ̽��ϴ�.");
		System.out.println(ownerName + " ���� �ܾ��� : " + this.balance + " �� �Դϴ�.");
		System.out.println(ownerName + " �� ���� ���� �����մϴ�.\n");

	}
	public void deposit(long money) { // ���� �޼ҵ�
		if (money > 0) {
			this.balance += money;
		} else {
			System.out.println("�˼��մϴ�.");
		}
		System.out.println(this.ownerName + " ���� ���� " + accountNo + " �� " + money + " �� �Ա� �Ǿ����ϴ�.");
		System.out.println("���� " + ownerName + " ���� �ܰ�� : " + this.balance + " �� �Դϴ�.\n");
	}
	
	public void deposit(long money, String msg) { // ���� �޼ҵ� + �޽���
		if (money > 0) {
			this.balance += money;
		} else {
			System.out.println("�˼��մϴ�.");
		}
		System.out.println(this.ownerName + " ���� ���� " + accountNo + " �� " + money + " �� �Ա� �Ǿ����ϴ�."+"("+ msg + ")");
		System.out.println("���� " + ownerName + " ���� �ܰ�� : " + this.balance + " �� �Դϴ�.\n");
	}

	public void withdraw(long money) { // ���� �޼ҵ�
		if (this.balance > money) {
			this.balance -= money;
			System.out.println(this.ownerName + " ���� ���¿��� " + money + "���� ����Ǿ����ϴ�.");
			System.out.println("���� �ܰ�� : " + this.balance + " �� �Դϴ�.\n");
		} else {
			System.out.println(ownerName +" ���� �ܰ� " + money + " ���� �����ϴ�.. ������ �Ұ����մϴ�.\n");
		}
	}

	public void getBalance() { // �ܾ���ȸ �޼ҵ�
		System.out.println("���� " + ownerName + " ���� �ܰ�� : " + this.balance + " �� �Դϴ�.\n");
	}
	
	// setter&getter
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}

	
	
	
	
}
