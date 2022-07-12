package com.lec.ex08_book2;

public interface ILendable {
	public byte STATE_NORMAL = 0;	// 대출 가능인 상태
	public byte STATE_BORROWED = 1;  // 대출 중인 상태
	
	public void checkOut(String borrower, String checkOutDate);
	
	public void checkIn();
	
	public void printState();
}
