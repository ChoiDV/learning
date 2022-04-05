package com.lec.ex01_list;

import java.util.ArrayList;
import java.util.Date;

import com.lec.ex02_map.Friend;

public class Ex04_FriendArrayList {
	public static void main(String[] args) {
		Friend[] friends = new Friend[5];
		friends[0] = new Friend("홍","010-9999-9999");
		friends[1] = new Friend("김","010-8888-8888");
		for(int i = 0; i < friends.length; i++) {
			System.out.println(friends[i]);
		}
		/** ArrayList : index 가 있고, 중복허용 ***/
		ArrayList<Friend> fs = new ArrayList<Friend>();
		// ArrayList 는 차례차례 0번부터 넣어야함 차곡차곡 쌓아넣어야함
		// 0번넣고 5번넣으려면 안됌. 0,1,2,... 차곡차곡
		fs.add(new Friend("홍길동","010-9999-9999"));  // 0번 인덱스
		fs.add(new Friend("유길동","010-7777-7777"));  // 1번 인덱스
		Friend temp = new Friend("이","010-6666-6666",new Date(95,11,12));
		fs.add(temp);  // 2번 인덱스
		// 사이즈는 3,  인덱스는 0~2까지
		for( int i = 0; i < fs.size(); i++) {
			System.out.println(fs.get(i));
		}
		
		
		 
		
	}
}
