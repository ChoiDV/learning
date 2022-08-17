package com.lec.ch03.ex2;

import org.springframework.context.support.GenericXmlApplicationContext;

public class TestMain {
	public static void main(String[] args) {
		// 이렇게 하면 스프링 컨테이너(IOC 컨테이너) 만 생성(환경설정)
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		//파싱
		ctx.load("classpath:META-INF/ex2/applicationCTX.xml");
		ctx.refresh();  // 빈 생성
		System.out.println("------------------최진영씨 빈을 만드는 중입니다.---------------------");
		Person person = ctx.getBean("person",Person.class);   // 이렇게 타입을 같이 적어줘도 되고,
		System.out.println(person);
		OtherPerson otherPerson = (OtherPerson) ctx.getBean("otherPerson");  // 이렇게 형변환 해도 된다.
		System.out.println(otherPerson);
		System.out.println("----------- 오동오동오동준씨 빈 메롱 ------------------");
		ctx.close();
		System.out.println("빈 소멸");
		
	}
}
