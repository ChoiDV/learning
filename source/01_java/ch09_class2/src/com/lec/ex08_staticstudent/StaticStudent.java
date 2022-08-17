package com.lec.ex08_staticstudent;

public class StaticStudent {
	private String name;
	private int korean;
	private int english;
	private int math;
	private int sum;
	private int average;
	private int number; // 번호
	private static int count=0;
	
	

	public void fatLine() {
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
	}

	public void line() {
		System.out.println("-----------------------------------------------------");
	}

	public void subjectPrint() {
		System.out.println("   번호\t이름\t" + "국어\t" + "영어\t" + "수학\t" + "총점\t" + "평균\t"); // 이걸 배열에 넣어서 확장 for문으로 반복시켜서 해도댐
	}

	public StaticStudent() {
	}

	public StaticStudent(String name, int korean, int english, int math) {
		this.name = name;
		this.korean = korean;
		this.english = english;
		this.math = math;
		this.sum = (korean + english + math);
		this.average = (sum / 3);
		this.number = ++count;				
	}
	public void countPrint() {
		System.out.print("  "+number);
	}

	public void resultPrint() {
		System.out.printf("   \t%s\t%d\t%d\t%d\t%d\t%d\n",  name, korean, english, math, sum, average);
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

	public int getAverage() {
		return average;
	}

}
