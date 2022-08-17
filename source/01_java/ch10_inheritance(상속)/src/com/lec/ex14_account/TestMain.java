package com.lec.ex14_account;

public class TestMain {

	public static void main(String[] args) {
//		Account a1 = new Account("최진영","111-1111");
//		a1.deposit(3000);
//		a1.deposit(6000);
//		a1.withdraw(10000);
//		a1.withdraw(5000);
//		a1.getBalance();
//		a1.balancePrint();
		
//		CheckingAccount a2 = new CheckingAccount("최진영","503-038789-01-010","123-456-789");
//		a2.deposit(9000);
//		a2.withdraw(20000);
//		a2.pay("123-456-789",1000);
//		a2.pay("123-456-789", 10000);
//		a2.pay("23132", 1000);
		
		CreditLineAccount a3 = new CreditLineAccount("최진영", "503-038789-01-010", "123-456-789", 10000000);
		a3.deposit(1000000);
		a3.pay("123-456-789", 9000000);
		a3.pay("123-456-789", 2000000);
		

	}

}