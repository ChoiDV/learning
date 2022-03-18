package com.lec.ex3_account;

public class Account {
	// 은행계좌 클래스 설계
	private String accountNo; // 계좌번호
	private String ownerName; // 예금주
	private long balance; // 잔액

	public Account() {
	};  // 계좌번호만 받는 생성자
	public Account(String accountNo) {
		this.ownerName = ownerName;
		this.accountNo = accountNo;
		System.out.println("예금주 : " + ownerName + " 님 ");
		System.out.println("계좌 번호 : " + accountNo);
		System.out.println(ownerName + " 님의 잔액은 : " + this.balance + " 원 입니다.");
		System.out.println(ownerName + " 님 계좌 개설 감사합니다.\n");
	} // 이름,계좌번호 받는 생성자
	public Account(String ownerName, String accountNo) {
		this.ownerName = ownerName;
		this.accountNo = accountNo;
		System.out.println("예금주 : " + ownerName + " 님 ");
		System.out.println("계좌 번호 : " + accountNo);
		System.out.println(ownerName + " 님의 잔액은 : " + this.balance + " 원 입니다.");
		System.out.println(ownerName + " 님 계좌 개설 감사합니다.\n");
	}

	public Account(String ownerName, String accountNo, long balance) {
		this.ownerName = ownerName;
		this.accountNo = accountNo;
		this.balance = balance;
		System.out.println("예금주 : " + ownerName + " 님 ");
		System.out.println("계좌 번호 : " + accountNo);
		System.out.println(balance + " 원 입금 되셨습니다.");
		System.out.println(ownerName + " 님의 잔액은 : " + this.balance + " 원 입니다.");
		System.out.println(ownerName + " 님 계좌 개설 감사합니다.\n");

	}
	public void deposit(long money) { // 예금 메소드
		if (money > 0) {
			this.balance += money;
		} else {
			System.out.println("죄송합니다.");
		}
		System.out.println(this.ownerName + " 님의 계좌 " + accountNo + " 로 " + money + " 원 입금 되었습니다.");
		System.out.println("현재 " + ownerName + " 님의 잔고는 : " + this.balance + " 원 입니다.\n");
	}
	
	public void deposit(long money, String msg) { // 예금 메소드 + 메시지
		if (money > 0) {
			this.balance += money;
		} else {
			System.out.println("죄송합니다.");
		}
		System.out.println(this.ownerName + " 님의 계좌 " + accountNo + " 로 " + money + " 원 입금 되었습니다."+"("+ msg + ")");
		System.out.println("현재 " + ownerName + " 님의 잔고는 : " + this.balance + " 원 입니다.\n");
	}

	public void withdraw(long money) { // 인출 메소드
		if (this.balance > money) {
			this.balance -= money;
			System.out.println(this.ownerName + " 님의 계좌에서 " + money + "원이 인출되었습니다.");
			System.out.println("현재 잔고는 : " + this.balance + " 원 입니다.\n");
		} else {
			System.out.println(ownerName +" 님의 잔고에 " + money + " 원이 없습니다.. 인출이 불가능합니다.\n");
		}
	}

	public void getBalance() { // 잔액조회 메소드
		System.out.println("현재 " + ownerName + " 님의 잔고는 : " + this.balance + " 원 입니다.\n");
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
