package com.lec.ch02.ex4_vehicle;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class VehicleTestMain {
	public static void main(String[] args) {
		String location = "classpath:applicationCTX4.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(location);
		Vehicle vh = ctx.getBean("vh", Vehicle.class);
		Vehicle car = ctx.getBean("car", Vehicle.class);
		Vehicle airplane = ctx.getBean("air", Vehicle.class);	
		Vehicle people = ctx.getBean("people", Vehicle.class);	
		vh.ride("최진영");
		car.ride("최진영");
		airplane.ride("최진영");  
		people.ride("최진영");
		ctx.close(); 
	}
}
