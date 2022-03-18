package com.lec.ex1_student;

public class Student {
	private String name;
	private int korean;
	private int english;
	private int math;
	private int sum;
	private double average;

	public void fatLine() {
		System.out.println("�������������������������������������������������������");
	}

	public void line() {
		System.out.println("-----------------------------------------------------");
	}

	public void subjectPrint() {
		System.out.println("    �̸�\t" + "����\t" + "����\t" + "����\t" + "����\t" + "���\t"); // �̰� �迭�� �־ Ȯ�� for������ �ݺ����Ѽ� �ص���
	}

	public Student() {
	}

	public Student(String name, int korean, int english, int math) {
		this.name = name;
		this.korean = korean;
		this.english = english;
		this.math = math;
		this.sum = (korean + english + math);
		this.average = (sum / 3.0);
		// System.out.println(" "+name
		// +"\t"+korean+"\t"+english+"\t"+math+"\t"+sum+"\t"+average);
		// System.out.printf("
		// %s\t%d\t%d\t%d\t%d\t%4.1f\n",name,korean,english,math,sum,average);
	}

	public void resultPrint() {
		System.out.printf("    %s\t%d\t%d\t%d\t%d\t%4.1f\n", name, korean, english, math, sum, average);
	}

	// getter

	public String getName() {
		return name;
	}

	public int getKorean() {
		return korean;
	}

	public int getEnglish() {
		return english;
	}

	public int getMath() {
		return math;
	}

	public int getSum() {
		return sum;
	}

	public double getAverage() {
		return average;
	}

}
