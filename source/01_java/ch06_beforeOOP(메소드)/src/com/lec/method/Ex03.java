package com.lec.method;

public class Ex03 {
// Arithmetic.sum/evenOdd = static �̰�   vs   abs = �Ϲ� 
	public static void main(String[] args) {
		int tot = Arithmetic.sum(10);
		System.out.println("1~10���� ���� : " + tot);
		System.out.println(Arithmetic.evenOdd(tot));

		Arithmetic ar = new Arithmetic();
		System.out.println("-4�� ���밪�� : " + ar.abs(-4));
	}

}
//  static �� �Ϲ� 
//  static�� ������(public �̳� private �̳� ���)���� ������ ��������ʰ� �ٷ� ����Ҽ� �ִ�.
// ex) ������ ����  sum, evenOdd ���� �޼ҵ���� �׳� �ٷ� Ŭ�����̸�.�޼ҵ� �ؼ� ����ϴµ�
// �Ϲ��� Arithmetic arith = new Arithmetic();
// �̷��� �ؼ� Arithmetic Ŭ������ �����ϰ� ����ؾ���.

// �׸��� �������� �����ִ°͵��� static�� ���� sum, out, evenOdd ���
