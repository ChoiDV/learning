package com.lec.ex07_book1;

// Book b = new Book("å ��ȣ","å ����","å ����")
public class Book implements ILendable {
	private String bookNo; // å ��ȣ 890��-101-1��
	private String bookTitle; // å ����
	private String writer; // å ����
	private String borrower; // ������
	private String checkOutDate; // ���� ��(��¥)
	private byte state; // ���� ���� ������(1), ���Ⱑ��(0)

	public Book(String bookNo, String bookTitle, String writer) {
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
//		borrower = null;
//		checkOutDate = null;
//		state = STATE_NORMAL;
		// ������, ������, ���� ���¿��� �ڵ����� ���� null �� 0�� ��
	}

	@Override
	public void checkOut(String borrower, String checkOutDate) { // ���� �޼ҵ�
		// b.checkOut("�ű浿","03-23"); ���� : ���¸� Ȯ���ؼ� �������̸� �ߴ�, ���Ⱑ���̸� ����ó��
		if (state == STATE_BORROWED) { // ���� ���̸� �޼��� �Ѹ��� ��
			System.out.println(bookTitle + " ������ �������Դϴ�.");
			// return;   �̷������� �ϰ� else�� ������ �Ȱ���.
		} else { // ���� �����̸� ���� ó��
			this.borrower = borrower;
			this.checkOutDate = checkOutDate;
			state = STATE_BORROWED; // ������ ���·� ��ȯ
			System.out.println(bookTitle + " ������ ���� ó���Ǿ����ϴ�.");
			System.out.println("������ : " + borrower + "\t������ : " + checkOutDate);
		}
	}

	@Override
	public void checkIn() { // state Ȯ���ؼ� ���Ⱑ��(0)�̸� �޼��� �Ѹ��� �ߴ�, ������(1)�̸� �ݳ�����
		if(state == STATE_NORMAL) {
			System.out.println(bookTitle+" ������ �ݳ��Ϸ�� å�ε� �̻��մϴ�.���ܹ߻�");
			// return; ���� if�� ���� �̹�� ���� else ����� ����
		} else {
			borrower = null;
			checkOutDate = null;
			state = STATE_NORMAL;
			System.out.println(bookTitle+" ������ �ݳ� �Ϸ�Ǿ����ϴ�.");
		}
	}

	@Override
	public void printState() { // å ��ȣ, å �̸�, å ���� , ���Ⱑ�ɿ��� ����ϱ� 
		if(state==STATE_NORMAL) {
			System.out.println(bookNo + "\t"+bookTitle+"("+writer+" ���� ) ���Ⱑ��");
		} else if(state==STATE_BORROWED) {
			System.out.println(bookNo + "\t"+bookTitle+"("+writer+" ���� ) ����Ұ�");
		} else {
			System.out.println(bookNo + "\t"+bookTitle+"("+writer+" ���� ) �̻���");
		}
//		String msg = bookNo + "\t"+bookTitle+"("+writer+" ���� )";
//		msg = msg +((state ==STATE_NORMAL)? "���Ⱑ��" : "���� �Ұ� (������)");
// 		msg = msg +((state ==STATE_NORMAL)? "���Ⱑ��" : (state==STATE_BORROWED) ? "������" : "����");
//		System.out.println(msg);
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public byte getState() {
		return state;
	}
	

	
	
	

}
