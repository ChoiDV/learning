package com.lec.ex13_Person;

public class TestMain {

	public static void main(String[] args) {

		Person student1 = new Student("A01", "������", "JAVA��");
		Person student2 = new Student("A02", "������", "JAVA��");
		Person staff1 = new Staff("S01", "ȫ�浿", "�������");
		Person staff2 = new Staff("S02", "�̱浿", "���������");
		Person gangsa1 = new Gangsa("G01", "������", "��ü����");
		Person gangsa2 = new Gangsa("G01","�Ի���","����ü��");

		Person[] person = { student1, student2, staff1, staff2, gangsa1, gangsa2 };

		for (Person p : person) {
			p.print();
		}

	}

}
