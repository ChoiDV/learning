package com.lec.ex;

public class Ex07 {

	public static void main(String[] args) {
		
		//  �Ҵ�(����) ������
		//  =   +=  -=   *=  /=   %=
		// �����ʿ� �ִ� ���� �������� ���鼭 ���
		//  1+=2 ��  2+1  ���� 3
		
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
