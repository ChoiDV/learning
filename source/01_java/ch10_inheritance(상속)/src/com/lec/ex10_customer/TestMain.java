package com.lec.ex10_customer;

public class TestMain {
	public static void main(String[] args) {
		Customer customer = new Customer("최진영", "010-4434-9878", "수원시", "1999-12-03");
		customer.buy(100000);
		customer.buy(900000);
		System.out.println(customer.infoString()); 

		System.out.println("---------------------------------------------------------\n");
		Staff staff = new Staff("진영", "010-4434-9878", "2022-09-01", "개발팀");
		Person person = new Person("지녕 ", "010-7777-7777");
		Person[] personArr = { customer, staff, person };
		System.out.println("---------------------------------------------------------\n");
		for (int i = 0; i < personArr.length; i++) {
			System.out.println(personArr[i].infoString());
		}
		System.out.println("확장문 for문");

		for (Person p : personArr) { // 배열 0~끝방까지 infoString()
			System.out.println(p.infoString());
		}
		System.out.println("---------------------------------------------------------\n");
		// buy (1000)
		// 배열 0번~끝방까지 buy(1000)
		for (Person p : personArr) {
			if (p instanceof Customer) { // p 변수가 Customer형 객체인가?
				((Customer) p).buy(1000);
			} else {
				System.out.println("buy는 Customer만 가능합니다.");
			}
		}

	}

}
