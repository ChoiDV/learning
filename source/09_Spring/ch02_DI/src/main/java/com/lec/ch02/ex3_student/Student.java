package com.lec.ch02.ex3_student;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Student {  // 이게 dto? 
	private String name;
	private int age;
	private String gradeNum;
	private String classNum;
	
}
