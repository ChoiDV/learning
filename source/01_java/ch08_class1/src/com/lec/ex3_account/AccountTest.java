package com.lec.ex3_account;

public class AccountTest {

	public static void main(String[] args) {

		Account leesangmin = new Account("�̻��", "123-456789-01-010");

		leesangmin.deposit(50000, "�뵷");
														// ���� ���������� int �̱⶧���� ���� �ڿ� l�� �ٿ���� long���� �ȴ�.
		Account jungdongjin = new Account("������", "987-654321-01-010");
		jungdongjin.deposit(9999999999l,"���������� �Ա��ϼ̽��ϴ�.");
		jungdongjin.withdraw(500000);

		Account hong = new Account("ȫ�浿", "123-456789-01-010");

		hong.getBalance();

		hong.deposit(2000,"�뵷!");
		hong.withdraw(3000);
		hong.withdraw(1000);
		
		Account choijinyoung = new Account("������","503-038789-01-010",100000000000l);
		
		Account mo = new Account("100-12-123");
		mo.setOwnerName("������");
		mo.deposit(1000000,"ȭ����");
		
		Account choisun = new Account("�ּ�","112-112-112");
		choisun.deposit(10000000,"ȭ����");
		
		
	}

}
