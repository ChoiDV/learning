package com.lec.ex04_abc;

public class TestMain {

	public static void main(String[] args) {
		S s = new S();		
		S a = new A(); // ��ü�� A���� ������ Ÿ���� S�� ������ ����ؼ�
		
		S b = new B();   // ������ SŸ���� B��ü           
		S c = new C();
// �Ųٷδ� �ȉ�. ���� ���� ���� �� �о�� ���ذ���.
		
//        ����               		�Ϲ�ȭ
//	      ��         ��             �� 
//	   ����	           �Ĺ�         
//  ��   ��    ��    ��          ��   
//����  ������  ���  �缭��           		 Ư��ȭ

		S[] arr = {s,a,b,c}; // Ÿ���� ���Ͻ��Ѽ� �迭�� ������ ����  �ٵ� �迭�� �ִ°� ��������� ���϶����� �����
		
		for(S obj : arr) {
			System.out.println(obj.s);
		}
		
		
		
		

	}

}
