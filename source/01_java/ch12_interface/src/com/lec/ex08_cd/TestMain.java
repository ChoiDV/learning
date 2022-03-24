package com.lec.ex08_cd;

import java.util.Scanner;

import com.lec.ex08_book2.BookLib;


public class TestMain {

	public static void main(String[] args) {
		
		BookLib[] books = { new BookLib("b1","java", "홍길동"), 
							new BookLib("b2", "oracle", "신길동"),
							new BookLib("b3", "mysql", "김길동"), 
							new BookLib("b4", "web", "이길동"),
							new BookLib("b5", "jsp", "유길동") };
		
		CDLib[] cds = { new CDLib("c01","java_cd","b1"),
						new CDLib("c02","oracle_cd","b2"),
						new CDLib("c03","mysql_cd","b3"),
						new CDLib("c04","web_cd","b4"),
						new CDLib("c05","jsp_cd","b5"),
		};
		
		Scanner sc = new Scanner(System.in);
		int fn, idx, icx;
		String bTitle,cTitle, borrower, checkOutDate;
		
		do {
			System.out.print("번호를 입력하세요(1:책 대출 | 2:CD 대출 | 3:책 반납 | 4:CD반납 | 5: 책 리스트 | 6: CD 리스트 |  0:종료) : ");
			fn = sc.nextInt();
			switch(fn) {
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
						
						int cdIdx;
						for( cdIdx = 0; cdIdx < cds.length; cdIdx++) {
							if(books[idx].getBookNo().equals(cds[cdIdx].getBookNo())){
								break;
							}
						}
						if(cdIdx != cds.length) {
							System.out.println("딸린 CD가 있습니다. 대출하시겠습니까(y / n ) ? : ");
							String answer = sc.next();
							if (answer.equals("y")) {
								cds[cdIdx].checkOut(borrower, checkOutDate);
							}
						}
					}
				}
				break;
			case 2:
				System.out.print("대출하고자 하는 CD 이름은? : ");
				cTitle = sc.next();
				for (icx = 0; icx < cds.length; icx++) {
					if (cds[icx].getCdTitle().equals(cTitle)) {
						break;
					}
				}
				if (icx == cds.length) {
					System.out.println("저희 도서관에서 보유하지 않은 CD 입니다.");
				} else {
					if (cds[icx].getState() == BookLib.STATE_BORROWED) {
						System.out.println("현재 대출중인 CD입니다.");
						System.out.println("대출 불가합니다.");
					} else {
						System.out.print("대출자의 성함은? : ");
						borrower = sc.next();
						System.out.print("대출일은 ? : ");
						checkOutDate = sc.next();
						cds[icx].checkOut(borrower, checkOutDate);
					}
				}
				break;
			case 3:
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
			case 4:
				System.out.print("반납하고자 하는 CD 이름은? : ");
				cTitle = sc.next();
				for (icx = 0; icx < cds.length; icx++) {
					if (cds[icx].getCdTitle().equals(cTitle)) {
						break;
					} 				
				}
				if( icx == cds.length) {
					System.out.println("해당 CD는 본 도서관의 CD가 아닙니다.");
				} else {
					cds[icx].checkIn();
				}
				break;
			case 5:
				System.out.println("책 리스트는 다음과 같습니다.");
				for(BookLib book : books) {
					book.printState();				
				}
				break;				
			case 6:
				System.out.println("CD 리스트는 다음과 같습니다.");
				for(CDLib cd : cds) {
					cd.printState();			
				}
				break;
			case 0:
				break;
			default:
				System.out.println("올바른 번호를 입력하세요.");
				
				
			
			}
			
		} while(fn != 0);
		System.out.println("종료 되었습니다.");

	}

}
