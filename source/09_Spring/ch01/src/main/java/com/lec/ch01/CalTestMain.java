package com.lec.ch01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CalTestMain {

	public static void main(String[] args) {
//		Calculation cal = new Calculation();
//		cal.setNum1(50);
//		cal.setNum2(10);
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
								// new Generi뭐시기는 applicationCTX.xml 이라는 파일을 파싱(읽고 해석한다)하고 거기있는것을 해석해서 bean을 생성
								//  xml을 파싱해서 빈을 만들어 놓은 것을 IOC 컨테이너라고 함
		Calculation cal = ctx.getBean("calculation",Calculation.class);
		cal.add();
		cal.sub();
		cal.mul();
		cal.div();
		System.out.println(cal);
		// getter, setter 들어왔는지 테스트하는 예제
		// CalTestMain이 Calculation 을 의존 
		ctx.close();
		// ctx.close는 주입받은 객체를 소멸? 시킨다. 
	}

}
