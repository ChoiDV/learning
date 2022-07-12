package com.lec.ex07_book1;

import java.util.Scanner;

public class TestMain2 {
	public static void main(String[] args) {
		Book[] books = { new Book("123ㅁ-101-1ㄱ", "java", "홍길동"),
						 new Book("456ㅁ-101-1ㄱ", "oracle", "신길동"),
						 new Book("147ㅁ-101-1ㄱ", "mysql", "김길동"), 
						 new Book("258ㅁ-101-1ㄱ", "web", "이길동"),
						 new Book("789ㅁ-101-1ㄱ", "jsp", "유길동") };
		Scanner sc = new Scanner(System.in);
		int fn; // 기능번호(1: 대출, 2:반납 , 3:책 리스트, 0 : 종료)
		int idx; // 대출하거나 반납하려고 할때 조회된 책의 index
		// 밖에서 idx를 선언해준 이유는 do-while의 for문 안에서 선언하면 그 반복이 끝나면 idx는 없어짐
		// 그래서 그 idx를 계속 남기기 위해 밖에서 선언  (34번줄에서 이어서 사용할수있도록)
		String bTitle, borrower, checkOutDate; // 사용자에게 받을 책 이름, 대출인, 대출일

		do {
			System.out.print("번호를 입력하세요 (1: 대출 | 2:반납 | 3:책 리스트 | 0 : 종료) : ");
			fn = sc.nextInt();
			switch (fn) {
			case 1:// 대출
					// 1. 책이름 입력 2. 책조회 3. 책 상태 확인 4. 대출인 입력 5. 대출일 입력 6. 대출메소드 호출
					// 1. 책 이름 입력
				System.out.print("대출하고자 하는 책이름은? : ");
				bTitle = sc.next(); // 스페이스 포함하지 않는 스캐너
				// 2. 책 조회
				for (idx = 0; idx < books.length; idx++) {
					if (books[idx].getBookTitle().equals(bTitle)) {
						break; // 책 찾으면 break;
					}
				} // 책 조회 for
				if (idx == books.length) {
					System.out.println("저희 도서관에서 보유하지 않은 도서입니다.");
				} else { // books[idx] 도서를 대출처리
					// 3. 책상태 확인
					if (books[idx].getState() == Book.STATE_BORROWED) { // 대출불가 상태
						System.out.println("현재 대출중인 도서입니다.");
						System.out.println("대출 불가합니다.");
					} else { // 대출가능상태
						// 4. 대출인 입력, 5. 대출일 입력, 6. 대출 메소드 호출
						System.out.print("대출자의 성함은? : ");
						borrower = sc.next();
						System.out.print("대출일은 ? : ");
						checkOutDate = sc.next();
						books[idx].checkOut(borrower, checkOutDate);
					}
				}
				break;
			case 2:
				System.out.print("반납하고자 하는 책이름은? : ");
				bTitle = sc.next();
				// 있는 책인가 조회.
				for (idx = 0; idx < books.length; idx++) {
					if (books[idx].getBookTitle().equals(bTitle)) {
						break;
					} 
					
				}
				if(idx == books.length) {
					System.out.println("저희 도서관 책이 아닙니다.");
					break;
				} else {
					books[idx].checkIn();
				}
//				if (books[idx].getState() == Book.STATE_NORMAL) {
//					System.out.println("저희 도서관 책은 이미 있습니다.");
//					break;
//				} else { // 반납가능할때
//					books[idx].checkIn();
//				}  이미 만들어놓음.. Book 에서...
				break;

			case 3:
				System.out.println("책 리스트는 다음과 같습니다.");
				for (Book book : books) {
					book.printState();
				}
				break;
			case 0:
				break;
			default:
				System.out.println("올바른 번호를 입력하세요.");
			}
		} while (fn != 0);
		System.out.println("종료되었습니다.");

//		while(true) {
//			System.out.print("번호를 입력하세요 (1: 대출 | 2:반납 | 3:책 리스트 | 0 : 종료) : ");
//			fn = sc.nextInt();
//			if(fn ==0) {
//				System.out.println("종료되었습니다.");
//				break;
//			}
//		}

	} // main

} // Class

