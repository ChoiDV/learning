package com.lec.ex10_customer;

public class TestMain {
	public static void main(String[] args) {
		Customer customer = new Customer("������", "010-4434-9878", "������", "1999-12-03");
		customer.buy(100000);
		customer.buy(900000);
		System.out.println(customer.infoString()); 

		System.out.println("---------------------------------------------------------\n");
		Staff staff = new Staff("����", "010-4434-9878", "2022-09-01", "������");
		Person person = new Person("���� ", "010-7777-7777");
		Person[] personArr = { customer, staff, person };
		System.out.println("---------------------------------------------------------\n");
		for (int i = 0; i < personArr.length; i++) {
			System.out.println(personArr[i].infoString());
		}
		System.out.println("Ȯ�幮 for��");

		for (Person p : personArr) { // �迭 0~������� infoString()
			System.out.println(p.infoString());
		}
		System.out.println("---------------------------------------------------------\n");
		// buy (1000)
		// �迭 0��~������� buy(1000)
		for (Person p : personArr) {
			if (p instanceof Customer) { // p ������ Customer�� ��ü�ΰ�?
				((Customer) p).buy(1000);
			} else {
				System.out.println("buy�� Customer�� �����մϴ�.");
			}
		}

	}

}
