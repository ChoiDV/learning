package com.lec.ex03_set;

public class Student {
	private int grade;
	private String name;

	public Student(int grade, String name) {
		this.grade = grade;
		this.name = name;
	}

	@Override
	public String toString() {
		return grade + " 학년 " + name;
	}

	// equals 와 hashcode override
	@Override
	public int hashCode() {
		return toString().hashCode();
	} // toString이 같으면 같은 hashCode를 리턴

	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Student) {
//			boolean gradeChk = grade == ((Student)obj).grade;
//			boolean nameChk = name.equals(((Student)obj).name);
//			return gradeChk && nameChk; 
			return toString().equals(obj.toString());   // 위에랑 같은 소리
		}
		return false;
	}

}
