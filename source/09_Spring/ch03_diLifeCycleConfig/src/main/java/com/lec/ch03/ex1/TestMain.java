package com.lec.ch03.ex1;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TestMain {
	public static void main(String[] args) {
		String resourceLocation1 = "classpath:META-INF/ex1/applicationCTX1.xml";
		String resourceLocation2 = "classpath:META-INF/ex1/applicationCTX2.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(resourceLocation1, resourceLocation2); // 스프링컨테이너(IOC 컨테이너)
		
		Student student = ctx.getBean("student",Student.class);
		System.out.println("student : " + student);
		
		StudentInfo studentInfo = ctx.getBean("studentInfo",StudentInfo.class);
		System.out.println("studentInfo의 student : " + studentInfo.getStudent());
		
		if(student.equals(studentInfo.getStudent())) {
			System.out.println("두 객체는 같은 객체");
		}
		
		Family family = ctx.getBean("family",Family.class);
		System.out.println("family : " + family);
		ctx.close();
	}
}
