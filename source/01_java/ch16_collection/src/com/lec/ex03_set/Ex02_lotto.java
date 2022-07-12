package com.lec.ex03_set;

import java.util.HashSet;
import java.util.Random;
import java.util.TreeSet;

public class Ex02_lotto {
	public static void main(String[] args) {
		HashSet<Integer> lotto = new HashSet<Integer>();
		Random random = new Random();
		int cnt=0;  // �ߺ� Ƚ�� Ȯ���ϱ�
		while(lotto.size()<6) {
			cnt++;  // �ߺ� Ƚ�� Ȯ���ϱ�
			lotto.add(random.nextInt(45)+1); // 1~45 ������ ���� ���� add
		}
		System.out.println(cnt+" �� �̾� ���� �ζ� ��ȣ�� : "+ lotto);
		
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		// TreeSet �� �˾Ƽ� ������ ����
		// �����ͺ��� ū�ű��� ��������
		TreeSet<Integer> lotto2 = new TreeSet<Integer>();
		Random random2 = new Random();
		int cnt2=0;  // �ߺ� Ƚ�� Ȯ���ϱ�
		while(lotto2.size()<6) {
			cnt2++;  // �ߺ� Ƚ�� Ȯ���ϱ�
			lotto2.add(random2.nextInt(45)+1); // 1~45 ������ ���� ���� add
		}
		System.out.println(cnt2+" �� �̾� ���� �ζ� ��ȣ�� : "+ lotto2);
	
		
	}
}
