package com.lec.ex;

public class Ex04 {

	public static void main(String[] args) {
		
		// �� ������ : && (AND ����) , || ( OR ������)
		
		// && �� �Ѵ� ���ϰ�� ��
		// || �� �ϳ��� ���ϰ�� ��
		
		int i = 1;
		int j = 10;
		int h = 10;
		
		boolean result = ( (i>j) && (++j>h));
		System.out.println("result= " + result + "\t j = " + j);
		System.out.println(result); // �տ����� false �ڿ����� true  && �� �Ѵ� ���ϰ�� ���̴ϱ� ������� false
									//  && ������ ������ ������ false �϶��� ������ ���� ��ü�� ���Ѵ�.
		
		System.out.println();
		
		
		boolean result4 = ( (h==j) && (++j==h));   // �̰��� ������ ���̶� ���ױ��� ������ �������� ������� false������
		System.out.println(result4);			   //  j ���� �������ؼ� 11�� ���´�
		System.out.println("result= " + result4 + "\t j = " + j);
		
		System.out.println();		
		
		boolean result3 = ((i<j) || ( ++j>h));
		System.out.println("result= " + result3 + "\t j= " + j);
		System.out.println(result3);
		

	}

}
