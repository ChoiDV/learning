package com.lec.ex01_string;

import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		int i = 10;
		String str1 = "Java";
		String str2 = "Java";
		// String�� new�� �������� �ʰ� " " �� ����� ���ڿ� ����� �̿�. �ڵ����� �� �޸𸮿����� String ��ü�� �̹� �����ϴ��� Ȯ���ϰ�
		// ���࿡ �̹� �����ϴ� ���ڿ��̸� ��ü�� ����.  ������ �ִ��Ͱ� �������� ����Ű�� ���� �ּҰ��� ����
		// new�� ����ؼ� ����� ���� �ٸ�
		// �������������� String ��ü ����
		
		String str3 = new String("Java");
		Scanner sc = new Scanner(System.in);
		
		if(str1==str2) {
			System.out.println("str1�� str2�� ���� �ּҰ��� ����");
		} else {
			System.out.println("str1�� str2�� �ٸ� �ּҰ��� ����");
		}
			
		if(str1.equals(str2)) {
			System.out.println("���� ���ڿ�");
		} 
		System.out.println(str1 == str3 ? "str1��3�� ���� �ּ�" : " str1��3�� �ٸ��ּҰ�");
		System.out.println(str1.equals(str3)? "���� ���ڿ�" : "�ٸ� ���ڿ�");
		
		
	}
}
