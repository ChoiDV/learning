//패키지명, 클래스명, 데이터, 생성자함수(오버로딩), 메소드, setter&getter
package com.lec.ex1_square;

public class Square {
	
	private int side;
	// 생성자 함수 자체가 없을 때는 JVM이 디폴트생성자를 만들어줌 (아무것도 하지않는 매개변수 없는 생성자
	public Square() { //생성자 함수 : return 타입이 없고, 클래스명과 같은 함수를 생성자 함수라고 부른다.  void 쓰면 안됌
		System.out.println("매개변수 없는 생성자 함수 호출됨");
	}
	// 디폴트 생성자
	// ex) Square s1 = new Square(); 이것을 사용할때 사실 컴파일 단계에서 컴퓨터가 자동으로 public Square라는 생성자함수를 만들었던것임.
	public Square(int side) { // 매개변수 있는 생성자 함수 용도 : 데이터 초기화
		this.side = side; // 아 여기에 정보들을 넣어서 하나하나 setter,getter 해줄필요없이 한번에 생성하면서 초기화까지 하려고
						 // 이거 사용함.
		System.out.println("매개변수 있는 생성자 함수 호출. side 초기화 " + side);
	}
	public int area() {
		return side*side;
		
	}
	public int getSide() {
		return side;
	}
	public void setSide(int side) {
		this.side = side;
	}

}
