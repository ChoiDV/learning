package com.lec.ex13_Person;

public class TestMain {

	public static void main(String[] args) {

		Person student1 = new Student("A01", "최진영", "JAVA반");
		Person student2 = new Student("A02", "오동준", "JAVA반");
		Person staff1 = new Staff("S01", "홍길동", "운영지원팀");
		Person staff2 = new Staff("S02", "이길동", "취업지원팀");
		Person gangsa1 = new Gangsa("G01", "선생님", "객체지향");
		Person gangsa2 = new Gangsa("G01","님생선","향지체객");

		Person[] person = { student1, student2, staff1, staff2, gangsa1, gangsa2 };

		for (Person p : person) {
			p.print();
		}

	}

}
