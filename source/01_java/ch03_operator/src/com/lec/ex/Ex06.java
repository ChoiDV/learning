package com.lec.ex;

public class Ex06 {

	public static void main(String[] args) {
	
		// ����(3��)���� :  ?:     ���ǽ� ?  ���ϰ�� : �����ϰ��
		// ���׿�����  :    (����) ? (���ϰ�� ���� �� or ��) : (�����ϰ�� ���� �� or ��)
		int h = 100;
		String result;
		
//		if ( h%2==0) {           // if ���� ����� Ȧ�� ¦�� ����
//			result = "¦��";
//		}
//		else 		 {
//			result = "Ȧ��";
//		}
		
		result = (h%2==0) ? "¦��" : "Ȧ��";   // ���׿����� ����ؼ� Ȧ�� ¦�� ����
		
		System.out.println(result);

	}

}
