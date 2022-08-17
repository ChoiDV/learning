package com.lec.ex14_account;

// CreditLineAccount c2 = new CreditLineAccount("�̸�","���¹�ȣ","��","ī���ȣ");
public class CreditLineAccount extends CheckingAccount {
	private int creditLine; // ī�� �ѵ�
	private int sum; // ���� �ݾ�

	public CreditLineAccount(String ownerName, String accountNo, String cardNo, int creditLine) {
		super(ownerName, accountNo, cardNo);
		this.creditLine = creditLine;
		System.out.println("ī�� �ѵ��� : " + creditLine + " �� �Դϴ�.");
	}

	public CreditLineAccount(String ownerName, String accountNo, String cardNo, int creditLine, long balance) {
		super(ownerName, accountNo, balance, cardNo);
		this.creditLine = creditLine;
	}

	@Override
	public void pay(String cardNo, int amount) {
		if (cardNo.equals(getCardNo())) {
			if (amount < creditLine) {
				if (sum < creditLine) {
					sum += amount;
					System.out.println(getOwnerName() + " �� " + amount + "�� ���� �Ǽ̰�, �����ݾ� : " + sum + " �� �Դϴ�.");
				} else {
					System.out.println("�ѵ��ʰ� �Դϴ�.");
					}
			} else {
				System.out.println("�ѵ� �ʰ� �Դϴ�.");
				}
	} else {
		System.out.println("�ùٸ� ī�� ��ȣ�� �ƴմϴ�.");
	}
}

}
