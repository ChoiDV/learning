package com.lec.ex14_account;

public class CheckingAccount extends Account {
	private String cardNo;

	public CheckingAccount(String ownerName, String accountNo, String cardNo) {
		super(ownerName,accountNo);
		this.cardNo = cardNo;
	}

	public CheckingAccount(String ownerName, String accountNo, long balance, String cardNo) {
		super(ownerName,accountNo, balance);
		this.cardNo = cardNo;
	}

	public void pay(String cardNo, int amount) {
		if (this.cardNo.equals(cardNo)) { // �ùٸ� ī���ȣ���� Ȯ��
			if (getBalance() >= amount) { // ���� �������� (�ܾ��� ������ �ݾ� �̻��ΰ�?)
				setBalance(getBalance() - amount);
				System.out.printf("%s(%s)�� %d�� �����Ͽ� �ܾ� %d�� ���ҽ��ϴ�.\n\n", getOwnerName(), getAccountNo(), amount,
						getBalance());
			} else {
				System.out.println(getOwnerName() + " �� �ܾ��� �����մϴ�. ���� �ܾ� : "+getBalance()+"\n");
			}

		} else {
			System.out.println("�ùٸ� ī�� ��ȣ�� �Է��ϼ���.\n");
		}

	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	
	

}
