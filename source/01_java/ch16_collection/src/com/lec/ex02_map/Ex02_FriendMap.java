package com.lec.ex02_map;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

public class Ex02_FriendMap {
	public static void main(String[] args) {
		HashMap<String, Friend> friends = new HashMap<String, Friend>();
		friends.put("010-9999-9999", new Friend("ȫ�浿","010-9999-9999"));
		friends.put("010-8888-8888", new Friend("���浿","010-8888-8888",new Date(95,11,12)));
		friends.put("010-7777-7777", new Friend("���浿","010-7777-7777"));
		friends.put("010-6666-6666", new Friend("�ű浿","010-6666-6666"));
		friends.put("010-5555-5555", new Friend("�̱浿","010-5555-5555"));
		Iterator<String> iterator = friends.keySet().iterator();
		while(iterator.hasNext()) {
			String key = iterator.next();
			System.out.println(key + " �� �����ʹ� "+ friends.get(key));
		}
	}
}
