package com.lec.ch02.ex5_exam;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ExamConsoleImpl2 implements ExamConsole {
	private Exam exam;
	
	public void print() {
		System.out.println("-------------------------");
		System.out.println("이름 : " + exam.getName());
		System.out.println("-------------------------");
		System.out.println("총점 : " + exam.total());
		System.out.println("평균 : " + exam.avg());
		System.out.println("-------------------------");
	}
	
}
