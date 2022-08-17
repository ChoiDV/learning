package com.lec.ex07_friend;
// this.   : 내 객체의 .~~~ 
// this()  : 현 클래스의 생성자 함수 
public class Friend {
	private String name;
	private String tel;  // 전화번호 같은거 int 로 하면 01044349878 하면 맨앞의 0이 사라짐.
	
	public Friend() {
		System.out.println("매개 변수 없는 생성자 함수");
	}
	public Friend(String name) {
		this(); // 이거는 매개변수 없는 Friend() 생성자를 뜻함
		this.name = name;
		System.out.println("매개 변수 하나짜리 생성자 함수");
	}
	public Friend(String name, String tel) {
		this(name);   // Friend(name)을 호출    // 매개변수 name 하나짜리 생성자를 뜻함
		this.tel = tel;			
		System.out.println("매개 변수 두개짜리 생성자 함수");
	}
	public String infoString() {
		return "[이름]" + name + " [전화] " + tel;
	}
	
	

}
