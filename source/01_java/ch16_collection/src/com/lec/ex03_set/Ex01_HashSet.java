package com.lec.ex03_set;

import java.util.HashSet;
import java.util.Iterator;

public class Ex01_HashSet {
	// HashSet 은 인덱스가 없음 
	// 출력할때 iterator 사용
	// 중복이 안됌
	public static void main(String[] args) {
		HashSet<String> hashSet = new HashSet<String>();
		hashSet.add("str0");
		hashSet.add("str1");
		System.out.println(hashSet);
		hashSet.add("str1");
		System.out.println(hashSet);
		Iterator<String> iterator = hashSet.iterator();
		
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
	}
}
