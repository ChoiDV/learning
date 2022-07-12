package com.lec.ex02_date;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.lec.ex01_string_friend.Friend;

public class Ex06_FriendsSimpleDateFormat {

	public static void main(String[] args) {
		
		Friend[] friends = { new Friend("홍길동", "010-9999-9999", "05-22"),
				 new Friend("신길동", "010-8888-8888", "09-22"),
				 new Friend("마길동", "010-8888-9999", "08-22"), 
				 new Friend("윤길동", "010-7777-7777", "03-28"),
				 new Friend("김길동", "010-6666-7777", "03-28") };
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		boolean searchOk = false;
		
		for(int i =0; i < friends.length; i++) {
			String birth = friends[i].getBirthday();
			if(birth.equals(sdf.format(date))) {
				System.out.println(friends[i].getName()+" 님 생일 축하합니다");
				searchOk = true;
			} 
		}
		if( ! searchOk) {
			System.out.println("오늘 생일인 친구는 없습니다.");
		}
		
		
		/* 검색할 전화번호 뒷자리를 입력받아 => 시스템으로부터 날짜를 받아 "MM-dd" 스타일의 string으로 변환
		 * 0~끝방까지 해당 전화번호가 있으면 출력 => 0~끝방까지 해당 생일과 위에서 변환한 스트링 "03-28" 같으면 출력
		 * 검색이 되지 않아 출력 못하면 없는데 라고 출력 => 해당 생일자가 없어 출력을 못하면 없는데라고 출력
		 * 
		 */
	}

}
