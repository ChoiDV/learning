package com.lec.ex;

public class VarEx06 {

	public static void main(String[] args) {
		
		int i1 = 10;  			// 4byte
		long l = 2200000000L;	// 8byte
		
		double d1 = 10;  // 8byte = 4byte   �������� ����ȯ  =  �������� ū���� �ִ°��̰� ������  �ս��� ���� �Ͼ������
		System.out.println("d1 = "+ d1);   // ����ȯ�� ����.
		
		
		
		double d2 = 10.19;   
		int i2 = (int)d2;    
			// ������� ����ȯ   	=	4byte = 8byte  �������� ū���� �������� �ϸ� ������ �ս��� �߻��� 
		System.out.println("i2 = " + i2);
		
		
		
		
		
		
		
		

	}

}
