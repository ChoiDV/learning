package com.lec.ex01_string;

import java.util.Scanner;

// 배열에 있는 전화번호 찾아 전체 전화번호 출력
public class Ex07_searchTel {
	public static void main(String[] args) {
		
		String[] tels = {"010-4434-9878","010-7608-9878","010-4078-9887","031-123-4567"};
		Scanner sc = new Scanner(System.in);
		String searchTel;  // 사용자로부터 전화번호 뒷 번호 입력 받은 데이터 할당하는 변수
		boolean searchOk = false;
		System.out.print("검색하고자 하는 회원의 전화번호 뒷자리는 ? : ");
		searchTel = sc.next();  // 입력받은 전화번호 뒷자리를 searchTel 에 할당
		
		for(int idx=0; idx<tels.length; idx++) {
			// idx 전화번호 뒷자리 추출
			String post = tels[idx].substring(tels[idx].lastIndexOf('-')+1);
			if(post.equals(searchTel)) {
				System.out.println("검색하신 전화번호는 : "+ tels[idx] + " 입니다" );
				// break;  를 사용하면 뒷자리가 중복된게 여러개인데 한개만 찾아줌 그래서
				searchOk = true;
			} // if - 전화번호를 찾을 경우 더이상 검색하지 않고  for문 빠져나감.
		} // for
		if(! searchOk) { // searchTel이 배열 전화에 없어서 못찾고 idx가 끝까지 간 경우 즉 idx가 4가 된경우
			System.out.println("검색하신 전화번호는 없습니다.");
		}
		sc.close();
		
		
		
	}

}
