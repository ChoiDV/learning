package com.lec.ex03_set;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class Ex04_Iterator {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("STR");
		list.add("STR");
		System.out.println(list);
		Iterator<String> iterator1 = list.iterator();
		while (iterator1.hasNext()) {
			System.out.println(iterator1.next());
		}
		System.out.println("~~~~~~~~~~~~~~~~~~~~");
		for(String l : list) {
			System.out.println(l);
		}
		// map
		HashMap<String,String> map = new HashMap<String, String>();
		map.put("홍길동", "010-9999-9999");
		map.put("유길동", "010-8888-8888");
		Iterator<String> iterator2 = map.keySet().iterator();
		while(iterator2.hasNext()) {
			System.out.println(iterator2.next() + " 키의 데이터 : " + map.get(iterator2.next()));
		}
		System.out.println("~~~~~~~~~~~~~~~~~~~~");
		// set
		HashSet<String> set = new HashSet<String>();
		set.add("str0");
		set.add("str1");
		set.add("str1");
		Iterator<String> iterator3 = set.iterator();
		while(iterator3.hasNext()) {
 			System.out.println(iterator3.next());
		}
		
		
		
	}
}
