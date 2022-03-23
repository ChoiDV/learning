package com.lec.ex07_book1;
// Book 작업명세
public interface ILendable {
	// public static final byte STATE_BORROWED 
	// static final이 내장되어있음 (인터페이스 안에있는 데이터는 무조건)
	public byte STATE_BORROWED = 1; // "대출중" 을 의미
	public byte STATE_NORMAL = 0; // "대출 가능" 을 의미
	
	public void checkOut(String borrower, String checkoutDate);
	// 대출시 대출인과 대출일 이용
	
	public void checkIn(); // 반납 
	
	public void printState(); // 도서정보와 대출 상태 출력 
	
	
	
}
