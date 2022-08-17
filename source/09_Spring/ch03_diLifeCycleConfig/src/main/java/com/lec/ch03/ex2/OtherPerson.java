package com.lec.ch03.ex2;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OtherPerson {
	private String name;
	private int age;
	
	@PostConstruct
	public void initMethod() {
		System.out.println("OtherPerson 형 Bean 생성하자마자 자동 호출 : initMethod() ");
	}
	@PreDestroy
	public void destroyMethod(){  // 여기서 메소드이름은 내맘대로 
		System.out.println("OtherPerson형 Bean 소멸 전 자동 호출 : destroyMethod() ");
	}
}
