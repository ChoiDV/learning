package com.lec.ex;

/* -------------- �β������
 * Hello, World!
 * --------------
 * Hello, Java!
 * ~~~~~~~~~~~~~~
 * Hello, Hone!
 * -------------- �β������  
 */
		
		// void = return Ÿ���� ���� �Ű������� ���� �޼ҵ�(�Լ�)

	
public class Ex05_line {
	private static void printLine() {
		for (int i=0; i <30; i++) {
			System.out.print('-');
		}	
		System.out.println();  // ���� '-' 30 �� ����ϰ� ����
	}
	private static void printLine(char c) {  // �Լ� �����ε�(�����̸��� �Լ��� �Ű������� �����Ѵ�.)
		for (int i=0; i <30; i++) {
			System.out.print(c);
		}	
		System.out.println();  // �Ű������� ���� c���ڸ� 30�� ����ϰ� ����
	}
	private static void printLine(int cnt) {
		for (int i=0; i < cnt; i++) {
			System.out.print('-');
		}	
		System.out.println();
	}
	private static void printLine(char c, int cnt) {
		for (int i=0; i < cnt; i++) {
			System.out.print(c);
		}	
		System.out.println();
	}
	
	
	public static void main(String[] args) {
		printLine('��',50);
		System.out.println("\tHello, World!");
		printLine(40);
		System.out.println("\tHello, Java!");
		printLine('~');
		System.out.println("\tHello, Hong!");
		printLine();
	}
	
}
