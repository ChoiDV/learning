package com.lec.ex;

public class Ex03_reference {

	public static void main(String[] args) {
		int i =10;
		int j =i;
		j= 99;
		System.out.printf("i=%d , j=%d\n",i,j);
		
		int[] score = {100,10,20,30,40};
		int[] s = score;       // ���������� score���� �ּҰ��� ���ֱ⶧���� s �� score�� ���� �ּҰ��� ������
							   // s�� �ٲٵ� score�� �ٲٵ� �ּҰ��� ã�ư��� �ȿ��ִ°��� �ٲٱ� ������ 
								// �ᱹ�� ���� ��� ���� ���� �����°��̴�.
								// �׷��� ���� �ٸ��� �Ϸ���
								// int[] score = {1,2,3,4,5};
								// int[] s = new int[score.length]; �̷� ������� �ؾ��� �ٸ� �ּҸ� ���� ���� �迭
		s[0]=99;
		for ( int idx =0; idx<score.length; idx++) {
			System.out.printf("score[%d] = %d\t s[%d] = %d\n", idx, score[idx],idx,s[idx]);
		}
		

	}

}
