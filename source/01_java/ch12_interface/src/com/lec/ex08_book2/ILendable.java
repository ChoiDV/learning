package com.lec.ex08_book2;

public interface ILendable {
	public byte STATE_NORMAL = 0;	// ���� ������ ����
	public byte STATE_BORROWED = 1;  // ���� ���� ����
	
	public void checkOut(String borrower, String checkOutDate);
	
	public void checkIn();
	
	public void printState();
}
