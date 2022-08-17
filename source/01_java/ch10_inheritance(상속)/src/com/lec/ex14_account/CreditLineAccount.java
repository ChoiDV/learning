package com.lec.ex14_account;

// CreditLineAccount c2 = new CreditLineAccount("이름","계좌번호","돈","카드번호");
public class CreditLineAccount extends CheckingAccount {
	private int creditLine; // 카드 한도
	private int sum; // 누적 금액

	public CreditLineAccount(String ownerName, String accountNo, String cardNo, int creditLine) {
		super(ownerName, accountNo, cardNo);
		this.creditLine = creditLine;
		System.out.println("카드 한도는 : " + creditLine + " 원 입니다.");
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
					System.out.println(getOwnerName() + " 님 " + amount + "원 지불 되셨고, 누적금액 : " + sum + " 원 입니다.");
				} else {
					System.out.println("한도초과 입니다.");
					}
			} else {
				System.out.println("한도 초과 입니다.");
				}
	} else {
		System.out.println("올바른 카드 번호가 아닙니다.");
	}
}

}
