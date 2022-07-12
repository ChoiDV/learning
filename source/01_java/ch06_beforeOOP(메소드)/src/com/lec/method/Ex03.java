package com.lec.method;

public class Ex03 {
// Arithmetic.sum/evenOdd = static 이고   vs   abs = 일반 
	public static void main(String[] args) {
		int tot = Arithmetic.sum(10);
		System.out.println("1~10까지 합은 : " + tot);
		System.out.println(Arithmetic.evenOdd(tot));

		Arithmetic ar = new Arithmetic();
		System.out.println("-4의 절대값은 : " + ar.abs(-4));
	}

}
//  static 과 일반 
//  static은 범위내(public 이냐 private 이냐 등등)에서 연산자 사용하지않고 바로 사용할수 있다.
// ex) 위에서 보면  sum, evenOdd 같은 메소드들은 그냥 바로 클래스이름.메소드 해서 사용하는데
// 일반은 Arithmetic arith = new Arithmetic();
// 이렇게 해서 Arithmetic 클래스를 생성하고 사용해야함.

// 그리고 변수들이 누워있는것들이 static임 보면 sum, out, evenOdd 등등
