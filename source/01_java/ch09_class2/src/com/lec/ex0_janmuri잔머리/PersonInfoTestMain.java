package com.lec.ex0_janmuri�ܸӸ�;

class PersonInfo {
	private String name;
	private int age;
	private String gender;

	public PersonInfo() {
	}

	public PersonInfo(String name, int age, String gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	public void print() {
		System.out.println("�̸� : " + name + "  ���� : " + age + "  ���� : " + gender);
		// System.out.printf("�̸�=%s\t����=%d\t����=%s\n", name, age,gender);
	}

	// setter&getter

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
}

public class PersonInfoTestMain {

	public static void main(String[] args) {

		PersonInfo choi = new PersonInfo("������", 24, "����");
		choi.print();
		PersonInfo[] person2 = { choi };

		PersonInfo[] person = { new PersonInfo("������", 28, "��"), 
								new PersonInfo("ȫ�浿", 26, "��") };
//		for (int idx = 0; idx < person.length; idx++) {
//			person[idx].print();
//		}
		for (PersonInfo p : person) {
			p.print();
		}
	}

}
