package com.lec.ex03_set;

import java.util.HashSet;

public class Ex03_StudentHashSet {
// hashSet�� �ߺ��ȉ�
	public static void main(String[] args) {
		HashSet<Student> students = new HashSet<Student>();
		Student s = new Student(6,"�̼���");
		students.add(s);
		students.add(s);
		students.add(new Student(3,"ȫ�浿"));
		students.add(new Student(3,"ȫ�浿"));
		students.add(new Student(6,"�̼���"));
		System.out.println(students);
		
		// HashSet�� ��ü������ �ؽ��ڵ带 ���ؼ� �ߺ����� �ƴ��� �Ǵ��� �׷��� s�� 14������ �̼����� �ٸ��ٰ� �Ǵ��ϰ� add���ִ°���
		// �׷��� hashCode �� equals�� �������̵�
		
	}

}