package com.lec.ex08_cd;

public class CDLib extends CDInfo implements ILendable {
	private String borrower;
	private String checkOutDate;
	private byte state;
	
	public CDLib(String cdNo, String cdTitle, String bookNo) {
		super(cdNo, cdTitle, bookNo);
		
	}

	@Override
	public void checkOut(String borrower, String checkOutDate) {
		if (state == STATE_BORROWED) {
			System.out.println(getCdTitle() + " ������ ���� ���� �� �Դϴ�.");
		} else {
			this.borrower = borrower;
			this.checkOutDate = checkOutDate;
			state = STATE_BORROWED;
			System.out.println(getCdTitle() + " ������ ���� ó���Ǿ����ϴ�.");
			System.out.println("������ : " + borrower + "\t������ : " + checkOutDate);
		}
		
	}

	@Override
	public void checkIn() {
		if (state == STATE_NORMAL) {
			System.out.println(getCdTitle() + " ������ �ݳ��Ϸ�� å�ε� �̻��մϴ�.���ܹ߻�");
		} else {
			borrower = null;
			checkOutDate = null;
			state = STATE_NORMAL;
			System.out.println(getCdTitle() + " ������ �ݳ� �Ϸ�Ǿ����ϴ�.");
		}
		
	}

	@Override
	public void printState() {
		if (state == STATE_NORMAL) {
			System.out.println(getCdNo() + "\t" + getCdTitle() + " (" + getBookNo() + " ������ CD ) ���Ⱑ��");
		} else if (state == STATE_BORROWED) {
			System.out.println(getCdNo() + "\t" + getCdTitle() + " (" + getBookNo() + " ������ CD ) ����Ұ�");
		} else {
			System.out.println(getCdNo() + "\t" + getCdTitle() + " (" + getBookNo() + " ������ CD ) �̻���");
		}
		
	}

	public byte getState() {
		return state;
	}
	
	

}
