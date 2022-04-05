package com.lec.ex01_string;

public class Ex10_StringBuffer {
	public static void main(String[] args) {
		
		// �޸������� ���� 
		// ��¦�� �����ص� �ƿ� ������ ���� ����⶧����
		String str = "abc";
		System.out.println(str.hashCode());
		str = str+"d";	
		System.out.println(str.hashCode());
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~\n");
				
		StringBuilder strBuilder = new StringBuilder("abc");
		System.out.println("strBuilder �ؽ��ڵ� ��� : " + strBuilder.hashCode());
		System.out.println("strBuilder : "+ strBuilder);
		
		strBuilder.append("def");  // ������ "abc"�� "def"�� �߰� : abcdef
		System.out.println("append �� strBuilder : " + strBuilder);  
		System.out.println("�߰� �� �ؽ��ڵ� ��� : " + strBuilder.hashCode());
		
		strBuilder.insert(3, "AAA"); // 3��°�� "AAA" �߰�   :  abcAAAdef
		System.out.println("inter �� strBuilder : "+strBuilder);
		System.out.println("�߰� �� �ؽ��ڵ� ��� : " + strBuilder.hashCode());
		// ������ ��� �ص� �ؽ��ڵ尪�� ������ ����
		strBuilder.delete(3, 5);  // 3��° ���� 5��° �ձ��� ���� : abcAdef
		System.out.println("strBuilder : "+ strBuilder);
		System.out.println("���� �� �ؽ��ڵ� ��� : " + strBuilder.hashCode());
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		strBuilder.deleteCharAt(3);  // 3��° ���ڸ� ���� delete(3,4) �� ����
		System.out.println("strBuilder : "+ strBuilder);
		System.out.println("���� �� �ؽ��ڵ� ��� : " + strBuilder.hashCode());
	}
	
}
