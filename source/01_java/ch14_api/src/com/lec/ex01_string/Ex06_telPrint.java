package com.lec.ex01_string;

import java.util.Scanner;

// ��ȭ��ȣ �޾�, �Է¹��� ��ȭ��ȣ, ¦����° ����, �Ųٷ�, ��ȭ��ȣ ���ڸ�, ��ȭ��ȣ ���ڸ�
public class Ex06_telPrint {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		do {
		System.out.print("��ȭ��ȣ�� �Է��ϼ���(010-4434-9878 ����) : ");
		String tel = sc.next();
		if(tel.equalsIgnoreCase("x")) break;
		System.out.println("�Է��� ��ȭ��ȣ :"+ tel);
		System.out.print("¦����° ���ڿ� : ");
		
		for(int i=0; i < tel.length(); i++ ) {
			if(i%2 ==0) {
				System.out.print(tel.charAt(i));  // ¦����° ���� ���
			} else {
				System.out.print(" ");  // Ȧ����° ���ڿ� ��� ' '��� 
			}
		}
		System.out.println();  // ������ ���� ����
		
		System.out.print("��ȭ��ȣ�� �Ųٷ� : ");
		// �Ųٷ� ����ϱ�
		for(int i =tel.length()-1; i>=0; i--) {
			System.out.print(tel.charAt(i));
		}	
		
		System.out.println();
		//010-4434-9878
		int first = tel.indexOf('-');   // ù��° -�� ������ ��ġ   3 
		int last = tel.lastIndexOf('-'); // ������ -�� ������ ��ġ   8
		
		String pre = tel.substring(0, tel.indexOf('-'));
		String post = tel.substring(tel.lastIndexOf('-')+1);
		String mid = tel.substring(first+1,last);
		// ù��° -�� ������ ��ġ���� ������ -�� ��������ġ ������
		
		System.out.println("��ȭ��ȣ ���ڸ� : "+ pre);
		System.out.println("��ȭ��ȣ �߰� �ڸ� : "+ mid);
		System.out.println("��ȭ��ȣ ���ڸ� : "+ post);
		}while(true);
		
		

	}
}
