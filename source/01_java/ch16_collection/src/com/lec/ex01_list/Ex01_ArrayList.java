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

		arrayList.add("str0"); // 0�� �ε���
		arrayList.add("str1"); // 1�� �ε��� -> 2�� �ε���
		arrayList.add("str2"); // 2�� �ε��� -> 3�� �ε���
		System.out.println(arrayList);
		arrayList.add(1, "str111111"); // 1�� �ε���
		System.out.println(arrayList);
		arrayList.set(1, "11111"); // 1�� �ε��� ���� ����
		System.out.println(arrayList);

		System.out.println("\nfor��\n");

		for (String alist : arrayList) {
			System.out.print(alist + "\t");
		}
		System.out.println("\n - remove�� �Ŀ� -");
		arrayList.remove(1); // 1��° �ε����� ������ ����
		System.out.println(arrayList);
		arrayList.remove(arrayList.size() - 1);
		for (int idx = 0; idx < arrayList.size(); idx++) {
			System.out.println(idx+" ��° �ε��� ���� "+ arrayList.get(idx));
		}
		System.out.println("����~~~~~~~~~~~~~~~~~~~");
		arrayList.clear(); // arrayList�� ��� ������ ����
		if( arrayList.size() == 0) {
			System.out.println("arrayList�� �����ʹ� �����ϴ�.");			
		} 
		if ( arrayList.isEmpty()) {
			System.out.println("arrayList�� �����ʹ� �����ϴ�.");
		}
		System.out.println(arrayList);
		arrayList = null; // arrayList ��ü�� ����
		
		

	}
}
