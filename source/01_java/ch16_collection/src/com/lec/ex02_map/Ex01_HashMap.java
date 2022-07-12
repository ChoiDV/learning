package com.lec.ex02_map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Ex01_HashMap {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("aaa");
		list.add("bbb");
		System.out.println(list.get(0)); // list곙ㄹ의 collection은 index로 get함
		
		// HashMap< 키값의 자료형, 데이터 자료형>
		HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
		hashMap.put(11, "str11");  // 11 key 값에 매핑되는 데이터 "str11" 추가
		hashMap.put(20, "str12"); // 20 key 값에 매핑되는 데이터 "str20" 추가
		hashMap.put(33, "str33"); // 33 key 값에 매핑되는 데이터 "str33" 추가
		System.out.println(hashMap);
		System.out.println(hashMap.get(20)); // hashMap은 .get(key값); 으로 불러올수 있음
		
		System.out.println("remove 전 " + hashMap);
		hashMap.remove(20);
		System.out.println("remove 후 " + hashMap);
		hashMap.clear();
		System.out.println(hashMap.isEmpty() ? "데이터 모두 삭제" : "데이터 있음");
		hashMap.put(0, "Hong gildong");
		hashMap.put(10, "Kim dongil");
		hashMap.put(22, "Lee soonsin");
		hashMap.put(40, "Yu ain");
		System.out.println(hashMap);
		
		Iterator<Integer> iterator = hashMap.keySet().iterator();
		while(iterator.hasNext()) {
			Integer key = iterator.next();
			System.out.println(key + " 의 데이터는 " + hashMap.get(key));
		}
		
		
		
		
	}
}
