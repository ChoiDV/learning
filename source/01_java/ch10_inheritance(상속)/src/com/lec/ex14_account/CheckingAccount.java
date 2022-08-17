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
		if (this.cardNo.equals(cardNo)) { // 올바른 카드번호인지 확인
			if (getBalance() >= amount) { // 지불 가능한지 (잔액이 지불할 금액 이상인가?)
				setBalance(getBalance() - amount);
				System.out.printf("%s(%s)님 %d원 지불하여 잔액 %d원 남았습니다.\n\n", getOwnerName(), getAccountNo(), amount,
						getBalance());
			} else {
				System.out.println(getOwnerName() + " 님 잔액이 부족합니다. 현재 잔액 : "+getBalance()+"\n");
			}

		} else {
			System.out.println("올바른 카드 번호를 입력하세요.\n");
		}

	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	
	

}
