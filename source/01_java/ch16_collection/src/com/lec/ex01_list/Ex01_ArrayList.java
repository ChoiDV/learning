package com.lec.ex01_list;

import java.util.ArrayList;

public class Ex01_ArrayList {
	public static void main(String[] args) {
		String[] array = new String[5];
		array[0] = "str0";
		array[1] = "str1";
		array[3] = "str3";
		for (int i = 0; i < array.length; i++) {
			System.out.print("array[" + i + "] = " + array[i] + "\t\t");
		}
		System.out.println();
		for (String a : array) {
			System.out.print(a + "\t");
		}
		System.out.println("\n~~~~~~~~~~~~~~~~~ ArrayList~~~~~~~~~~~~~~~~~");

		ArrayList<String> arrayList = new ArrayList<String>();
		ArrayList<Integer> intList = new ArrayList<Integer>();

		arrayList.add("str0"); // 0번 인덱스
		arrayList.add("str1"); // 1번 인덱스 -> 2번 인덱스
		arrayList.add("str2"); // 2번 인덱스 -> 3번 인덱스
		System.out.println(arrayList);
		arrayList.add(1, "str111111"); // 1번 인덱스
		System.out.println(arrayList);
		arrayList.set(1, "11111"); // 1번 인덱스 값을 수정
		System.out.println(arrayList);

		System.out.println("\nfor문\n");

		for (String alist : arrayList) {
			System.out.print(alist + "\t");
		}
		System.out.println("\n - remove한 후에 -");
		arrayList.remove(1); // 1번째 인덱스의 데이터 삭제
		System.out.println(arrayList);
		arrayList.remove(arrayList.size() - 1);
		for (int idx = 0; idx < arrayList.size(); idx++) {
			System.out.println(idx+" 번째 인덱스 값은 "+ arrayList.get(idx));
		}
		System.out.println("개행~~~~~~~~~~~~~~~~~~~");
		arrayList.clear(); // arrayList의 모든 데이터 삭제
		if( arrayList.size() == 0) {
			System.out.println("arrayList의 데이터는 없습니다.");			
		} 
		if ( arrayList.isEmpty()) {
			System.out.println("arrayList의 데이터는 없습니다.");
		}
		System.out.println(arrayList);
		arrayList = null; // arrayList 객체를 지움
		
		

	}
}
