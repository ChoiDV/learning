package com.lec.ex;

public class Ex07 {

	public static void main(String[] args) {
		
		//  할당(대입) 연산자
		//  =   +=  -=   *=  /=   %=
		// 오른쪽에 있는 값을 왼쪽으로 가면서 계산
		//  1+=2 는  2+1  값은 3
		
		int n1 = 10*3;
		System.out.println("n1 = " + n1);
		n1 +=10;    // n1 = n1+10;
		System.out.println("n1 = " + n1);
		n1++;
		++n1;
		n1 = n1+1;
		System.out.println("n1 = " + n1);
		n1 -=10;  // n1 = n1-10;
		n1 *=10;  // n1 = n1*10;
		n1 /=10;  // n1 = n1/10;
		
		int n2 = n1 = 10;
		System.out.println("n1 = "+ n1 + "\t n2= " + n2);
		
		
	}

}
