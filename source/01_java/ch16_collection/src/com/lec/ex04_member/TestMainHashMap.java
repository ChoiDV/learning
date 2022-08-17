package com.lec.ex04_member;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class TestMainHashMap {
	public static void main(String[] args) {
		HashMap<String,Member> hashMap = new HashMap<String, Member>();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("등록을 하려면 Y | 종료하려면 X 를 누르세요 : ");
			String msg = sc.next();
			if(msg.equalsIgnoreCase("x")) {
				System.out.println("종료되었습니다.");
				break;
			}
			System.out.print("이름을 입력하세요 : ");
			String name = sc.next();
			System.out.print("번호를 입력하세요 : ");
			String tel = sc.next();
			System.out.print("주소를 입력하세요 : ");
			sc.nextLine();
			String address = sc.nextLine();
			hashMap.put(tel,new Member(name,tel,address));		
		}
		Iterator<String> iterator = hashMap.keySet().iterator();
		while(iterator.hasNext()) {
			String key = iterator.next();
			System.out.println(key + " 의 정보는 : "+ hashMap.get(key));
		}
		
	}
}
