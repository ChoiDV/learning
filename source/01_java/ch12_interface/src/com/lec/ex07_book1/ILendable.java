package com.lec.ex07_book1;
// Book �۾���
public interface ILendable {
	// public static final byte STATE_BORROWED 
	// static final�� ����Ǿ����� (�������̽� �ȿ��ִ� �����ʹ� ������)
	public byte STATE_BORROWED = 1; // "������" �� �ǹ�
	public byte STATE_NORMAL = 0; // "���� ����" �� �ǹ�
	
	public void checkOut(String borrower, String checkoutDate);
	// ����� �����ΰ� ������ �̿�
	
	public void checkIn(); // �ݳ� 
	
	public void printState(); // ���������� ���� ���� ��� 
	
	
	
}
