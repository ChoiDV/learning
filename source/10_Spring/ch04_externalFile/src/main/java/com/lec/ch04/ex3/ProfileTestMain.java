package com.lec.ch04.ex3;

import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

public class ProfileTestMain {
	public static void main(String[] args) {
		String config = null;  // 어떤환경인지 받아올 변수   일단은 스캐너로 대체
		Scanner sc = new Scanner(System.in);
		System.out.println("dev중? run중? : ");
		String answer = sc.next();
		if(answer.equalsIgnoreCase("dev")) {
			config = "dev";
		} else if(answer.equalsIgnoreCase("run")){
			config="run";
		} else {
			System.out.println("제대로 된 환경이 입력되지 않았습니다.");
			System.exit(0);
		}
		sc.close();
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.getEnvironment().setActiveProfiles(config);  // profile값이  config 값인애만 파싱을 하겠다.
		ctx.load("classpath:META-INF/ex3/CTX_dev.xml","classpath:META-INF/ex3/CTX_run.xml" );
		ctx.refresh();
		ServerInfo info = ctx.getBean("serverInfo",ServerInfo.class);
		System.out.println("IP : " + info.getIpNum());
		System.out.println("port : " + info.getPortNum());
		
	}
}
