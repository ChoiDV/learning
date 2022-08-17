package com.lec.ex08_cd;

public class BookLib extends BookInfo implements ILendable {
	private String borrower;
	private String checkOutDate;
	private byte state;
	
	
	public BookLib(String bookNo, String bookTitle, String writer) {
		super(bookNo, bookTitle, writer);


	}

	@Override
	public void checkOut(String borrower, String checkOutDate) {
		if (state == STATE_BORROWED) {
			System.out.println(getBookTitle() + " 도서는 현재 대출 중 입니다.");
		} else {
			this.borrower = borrower;
			this.checkOutDate = checkOutDate;
			state = STATE_BORROWED;
			System.out.println(getBookTitle() + " 도서가 대출 처리되었습니다.");
			System.out.println("대출인 : " + borrower + "\t대출일 : " + checkOutDate);
		}
		
	}

	@Override
	public void checkIn() {
		if (state == STATE_NORMAL) {
			System.out.println(getBookTitle() + " 도서는 반납완료된 책인데 이상합니다.예외발생");
		} else {
			borrower = null;
			checkOutDate = null;
			state = STATE_NORMAL;
			System.out.println(getBookTitle() + " 도서가 반납 완료되었습니다.");
		}
		
	}

	@Override
	public void printState() {
		if (state == STATE_NORMAL) {
			System.out.println(getBookNo() + "\t" + getBookTitle() + "(" + getWriter() + " 지음 ) 대출가능");
		} else if (state == STATE_BORROWED) {
			System.out.println(getBookNo() + "\t" + getBookTitle() + "(" + getWriter() + " 지음 ) 대출불가");
		} else {
			System.out.println(getBookNo() + "\t" + getBookTitle() + "(" + getWriter() + " 지음 ) 이상해");
		}
		
		
	}

	public byte getState() {
		return state;
	}
	
	


	
}
