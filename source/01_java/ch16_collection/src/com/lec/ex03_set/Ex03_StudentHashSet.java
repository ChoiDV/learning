package com.lec.ex03_set;

import java.util.HashSet;

public class Ex03_StudentHashSet {
// hashSet은 중복안됌
	public static void main(String[] args) {
		HashSet<Student> students = new HashSet<Student>();
		Student s = new Student(6,"이순신");
		students.add(s);
		students.add(s);
		students.add(new Student(3,"홍길동"));
		students.add(new Student(3,"홍길동"));
		students.add(new Student(6,"이순신"));
		System.out.println(students);
		
		// HashSet은 자체적으로 해쉬코드를 비교해서 중복인지 아닌지 판단함 그래서 s와 14번줄의 이순신이 다르다고 판단하고 add해주는것임
		// 그래서 hashCode 와 equals를 오버라이드
		
	}

}