package com.lec.ex08_book2;

import java.util.Scanner;

public class TestMain {

	public static void main(String[] args) {

		BookLib[] books = { new BookLib("123ㅁ-101-1ㄱ", "java", "홍길동"), 
							new BookLib("456ㅁ-101-1ㄱ", "oracle", "신길동"),
							new BookLib("147ㅁ-101-1ㄱ", "mysql", "김길동"), 
							new BookLib("258ㅁ-101-1ㄱ", "web", "이길동"),
							new BookLib("789ㅁ-101-1ㄱ", "jsp", "유길동") };

		Scanner sc = new Scanner(System.in);
		int fn;
		int idx;
		String bTitle, borrower, checkOutDate;

		do {
			System.out.print("번호를 입력하세요 (1: 대출 | 2:반납 | 3:책 리스트 | 0 : 종료) : ");
			fn = sc.nextInt();
			switch (fn) {
			case 1:
				System.out.print("대출하고자 하는 책 이름은? : ");
				bTitle = sc.next();
				for (idx = 0; idx < books.length; idx++) {
					if (books[idx].getBookTitle().equals(bTitle)) {
						break;
					}
				}
				if (idx == books.length) {
					System.out.println("저희 도서관에서 보유하지 않은 도서입니다.");
				} else {
					if (books[idx].getState() == BookLib.STATE_BORROWED) {
						System.out.println("현재 대출중인 도서입니다.");
						System.out.println("대출 불가합니다.");
					} else {
						System.out.print("대출자의 성함은? : ");
						borrower = sc.next();
						System.out.print("대출일은 ? : ");
						checkOutDate = sc.next();
						books[idx].checkOut(borrower, checkOutDate);
					}
				}
				break;
			case 2:
				System.out.print("반납하고자 하는 책 이름은? : ");
				bTitle = sc.next();
				for (idx = 0; idx < books.length; idx++) {
					if (books[idx].getBookTitle().equals(bTitle)) {
						break;
					} 				
				}
				if( idx == books.length) {
					System.out.println("해당 도서는 본 도서관의 책이 아닙니다.");
				} else {
					books[idx].checkIn();
				}
				break;
			case 3:
				System.out.println("책 리스트는 다음과 같습니다.");
				for(BookLib book : books) {
					book.printState();				
				}
				break;
			case 0:
				break;
			default:
				System.out.println("올바른 번호를 입력하세요.");
				
			}
		} while (fn != 0);
			System.out.println("종료 되었습니다.");

	}

}
