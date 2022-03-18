package com.lec.ex0_janmuri잔머리;

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
		System.out.println("이름 : " + name + "  나이 : " + age + "  성별 : " + gender);
		// System.out.printf("이름=%s\t나이=%d\t성별=%s\n", name, age,gender);
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

		PersonInfo choi = new PersonInfo("최진영", 24, "남자");
		choi.print();
		PersonInfo[] person2 = { choi };

		PersonInfo[] person = { new PersonInfo("오동준", 28, "남"), 
								new PersonInfo("홍길동", 26, "여") };
//		for (int idx = 0; idx < person.length; idx++) {
//			person[idx].print();
//		}
		for (PersonInfo p : person) {
			p.print();
		}
	}

}
