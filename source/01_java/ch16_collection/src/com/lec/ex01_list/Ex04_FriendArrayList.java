package com.lec.ex01_list;

import java.util.ArrayList;
import java.util.Date;

import com.lec.ex02_map.Friend;

public class Ex04_FriendArrayList {
	public static void main(String[] args) {
		Friend[] friends = new Friend[5];
		friends[0] = new Friend("ȫ","010-9999-9999");
		friends[1] = new Friend("��","010-8888-8888");
		for(int i = 0; i < friends.length; i++) {
			System.out.println(friends[i]);
		}
		/** ArrayList : index �� �ְ�, �ߺ���� ***/
		ArrayList<Friend> fs = new ArrayList<Friend>();
		// ArrayList �� �������� 0������ �־���� �������� �׾Ƴ־����
		// 0���ְ� 5���������� �ȉ�. 0,1,2,... ��������
		fs.add(new Friend("ȫ�浿","010-9999-9999"));  // 0�� �ε���
		fs.add(new Friend("���浿","010-7777-7777"));  // 1�� �ε���
		Friend temp = new Friend("��","010-6666-6666",new Date(95,11,12));
		fs.add(temp);  // 2�� �ε���
		// ������� 3,  �ε����� 0~2����
		for( int i = 0; i < fs.size(); i++) {
			System.out.println(fs.get(i));
		}
		
		
		 
		
	}
}
