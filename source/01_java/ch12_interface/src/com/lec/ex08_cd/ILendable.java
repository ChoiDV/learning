package com.lec.ex08_cd;

public interface ILendable {
	public byte STATE_BORROWED = 1;
	public byte STATE_NORMAL = 0;
	
	public void checkOut(String borrower, String checkOutDate);
	
	public void checkIn();
	
	public void printState();
	
}
