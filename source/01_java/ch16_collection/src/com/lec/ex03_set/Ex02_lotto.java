package com.lec.ex03_set;

import java.util.HashSet;
import java.util.Random;
import java.util.TreeSet;

public class Ex02_lotto {
	public static void main(String[] args) {
		HashSet<Integer> lotto = new HashSet<Integer>();
		Random random = new Random();
		int cnt=0;  // 중복 횟수 확인하기
		while(lotto.size()<6) {
			cnt++;  // 중복 횟수 확인하기
			lotto.add(random.nextInt(45)+1); // 1~45 사이의 정수 난수 add
		}
		System.out.println(cnt+" 번 뽑아 나온 로또 번호는 : "+ lotto);
		
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		// TreeSet 은 알아서 정렬을 해줌
		// 작은것부터 큰거까지 정렬해줌
		TreeSet<Integer> lotto2 = new TreeSet<Integer>();
		Random random2 = new Random();
		int cnt2=0;  // 중복 횟수 확인하기
		while(lotto2.size()<6) {
			cnt2++;  // 중복 횟수 확인하기
			lotto2.add(random2.nextInt(45)+1); // 1~45 사이의 정수 난수 add
		}
		System.out.println(cnt2+" 번 뽑아 나온 로또 번호는 : "+ lotto2);
	
		
	}
}
