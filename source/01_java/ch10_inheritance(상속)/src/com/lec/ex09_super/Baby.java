package com.lec.ex09_super;
// Person을 상속받아 여기에는 데이터가 없지만  name, character 메소드는 intro() 가 있는상태 
// Baby b = new Baby("홍아가","예뻐");
// Baby b1 = new Baby(); 
public class Baby extends Person {
	public Baby() {
		System.out.println("매개 변수 없는 Baby");
	}
	public Baby(String name, String character) {
	// 이거 대신	setName(name); setCharacter(character);
		super(name, character);  // 부모단의 (Person)의 매개변수 두개 짜리 생성자를 실행해라
		// 반드시 this나 super는 메소드의 첫줄에 적는다.
		System.out.println("매개 변수 있는 Baby 생성자");
	}
	
	@Override
	public void intro() {
		System.out.print("응애 응애 난 아가야\t");
		super.intro(); // 내 클래스의 부모단의 intro 즉 Person의 intro 실행
	}
	
}
