package com.lec.ex07_book1;

// Book b = new Book("책 번호","책 제목","책 저자")
public class Book implements ILendable {
	private String bookNo; // 책 번호 890ㅁ-101-1ㄱ
	private String bookTitle; // 책 제목
	private String writer; // 책 저자
	private String borrower; // 대출인
	private String checkOutDate; // 대출 일(날짜)
	private byte state; // 대출 상태 대출중(1), 대출가능(0)

	public Book(String bookNo, String bookTitle, String writer) {
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
//		borrower = null;
//		checkOutDate = null;
//		state = STATE_NORMAL;
		// 대출인, 대출일, 대출 상태에는 자동으로 전부 null 과 0이 들어감
	}

	@Override
	public void checkOut(String borrower, String checkOutDate) { // 대출 메소드
		// b.checkOut("신길동","03-23"); 대출 : 상태를 확인해서 대출중이면 중단, 대출가능이면 대출처리
		if (state == STATE_BORROWED) { // 대출 중이면 메세지 뿌리고 끝
			System.out.println(bookTitle + " 도서는 대출중입니다.");
			// return;   이런식으로 하고 else를 지워도 똑같음.
		} else { // 대출 가능이면 대출 처리
			this.borrower = borrower;
			this.checkOutDate = checkOutDate;
			state = STATE_BORROWED; // 대출중 상태로 전환
			System.out.println(bookTitle + " 도서가 대출 처리되었습니다.");
			System.out.println("대출인 : " + borrower + "\t대출일 : " + checkOutDate);
		}
	}

	@Override
	public void checkIn() { // state 확인해서 대출가능(0)이면 메세지 뿌리고 중단, 대출중(1)이면 반납진행
		if(state == STATE_NORMAL) {
			System.out.println(bookTitle+" 도서는 반납완료된 책인데 이상합니다.예외발생");
			// return; 으로 if문 종료 이방법 사용시 else 지우고 진행
		} else {
			borrower = null;
			checkOutDate = null;
			state = STATE_NORMAL;
			System.out.println(bookTitle+" 도서가 반납 완료되었습니다.");
		}
	}

	@Override
	public void printState() { // 책 번호, 책 이름, 책 저자 , 대출가능여부 출력하기 
		if(state==STATE_NORMAL) {
			System.out.println(bookNo + "\t"+bookTitle+"("+writer+" 지음 ) 대출가능");
		} else if(state==STATE_BORROWED) {
			System.out.println(bookNo + "\t"+bookTitle+"("+writer+" 지음 ) 대출불가");
		} else {
			System.out.println(bookNo + "\t"+bookTitle+"("+writer+" 지음 ) 이상해");
		}
//		String msg = bookNo + "\t"+bookTitle+"("+writer+" 지음 )";
//		msg = msg +((state ==STATE_NORMAL)? "대출가능" : "대출 불가 (대출중)");
// 		msg = msg +((state ==STATE_NORMAL)? "대출가능" : (state==STATE_BORROWED) ? "대출중" : "오류");
//		System.out.println(msg);
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public byte getState() {
		return state;
	}
	

	
	
	

}
