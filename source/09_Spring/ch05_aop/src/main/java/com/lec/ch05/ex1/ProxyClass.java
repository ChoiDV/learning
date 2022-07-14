package com.lec.ch05.ex1;

import org.aspectj.lang.ProceedingJoinPoint;

public class ProxyClass {
	// aroundAdvice  : 핵심기능 전후로 공통기능 수행
	// 핵심기능의 리턴타입이 있을수도 있어서
	// 얘는 이거 수행하고 핵심기능 수행하고 다시 와서 이거 수행함
	public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
		String signatureName = joinPoint.getSignature().toString();  //  핵심기능 메소드명
		System.out.println(signatureName + " 가 시작되었습니다.");
		long startTime = System.currentTimeMillis(); // 시작시점 저장
		try {
			Object obj = joinPoint.proceed();  // proceed는 수행해라, joinPoint는 핵심기능을 의미 핵심기능을 수행해라 라는뜻
			// 실무에서는 여기에 할일들을 넣으면 됌.
			return obj;
		} finally {
			// finally 를 넣는이뉴는 핵심기능을 수행한후 return 해준뒤에도 수행해야할 일들이 있을수도 있어서 finally 절을 넣어서 핵심기능 이후의 기능들을 넣기위해서
			long endTime = System.currentTimeMillis();  // 핵심기능 수행 후 시점
			System.out.println(signatureName + " 가 수행되는 경과시간 : " + (endTime-startTime));
		}
	}
	// beforeAdvice
	public void beforeAdvice() {
		System.out.println("핵심기능 수행하기 전 알아서 beforeAdvice(공통기능) 수행");
	}
	// afterAdvice
	public void afterAdvice() {
		System.out.println("핵심기능 수행하고 알아서 afterAdvice(공통기능) 수행");
	}
	// after-returningAdvice
	public void afterReturningAdvice() {
		System.out.println("정상적으로(예외발생되지 않았을때) 핵심기능이 수행된 후 이 afterReturningAdvice(공통기능) 수행");
	}
	// after-throwing Advice
	public void afterThrowingAdvice(){
		System.out.println("예외가 발생된 핵심기능이 수행된 후 이 afterThrowingAdvice 수행");
	}
}
