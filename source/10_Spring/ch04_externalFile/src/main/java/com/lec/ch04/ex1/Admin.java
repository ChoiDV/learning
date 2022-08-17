package com.lec.ch04.ex1;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

import lombok.Data;

@Data
public class Admin implements EnvironmentAware, InitializingBean {
	private String adminId;
	private String adminPw;
	private Environment env;
	@Override
	public void setEnvironment(Environment environment) {
		env = environment;  // Bean 생성하고 가장 먼저 실행
	}
	@Override
	public void afterPropertiesSet() throws Exception { // Bean 생성하자마자 실행2
		adminId = env.getProperty("admin.id"); // 괄호안에 properties파일에 있는 이름 그대로 써야함.  
		adminPw = env.getProperty("admin.pw");  										  
	}
	
}
