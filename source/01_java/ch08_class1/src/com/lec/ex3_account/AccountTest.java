package com.lec.ex3_account;

public class AccountTest {

	public static void main(String[] args) {

		Account leesangmin = new Account("이상민", "123-456789-01-010");

		leesangmin.deposit(50000, "용돈");
														// 기초 데이터형이 int 이기때문에 숫자 뒤에 l을 붙여줘야 long형이 된다.
		Account jungdongjin = new Account("정동진", "987-654321-01-010");
		jungdongjin.deposit(9999999999l,"최진영님이 입금하셨습니다.");
		jungdongjin.withdraw(500000);

		Account hong = new Account("홍길동", "123-456789-01-010");

		hong.getBalance();

		hong.deposit(2000,"용돈!");
		hong.withdraw(3000);
		hong.withdraw(1000);
		
		Account choijinyoung = new Account("최진영","503-038789-01-010",100000000000l);
		
		Account mo = new Account("100-12-123");
		mo.setOwnerName("모혜림");
		mo.deposit(1000000,"화이팅");
		
		Account choisun = new Account("최선","112-112-112");
		choisun.deposit(10000000,"화이팅");
		
		
	}

}
