package com.lec.ex08_book2;

import java.util.Scanner;

public class TestMain {

	public static void main(String[] args) {

		BookLib[] books = { new BookLib("123��-101-1��", "java", "ȫ�浿"), 
							new BookLib("456��-101-1��", "oracle", "�ű浿"),
							new BookLib("147��-101-1��", "mysql", "��浿"), 
							new BookLib("258��-101-1��", "web", "�̱浿"),
							new BookLib("789��-101-1��", "jsp", "���浿") };

		Scanner sc = new Scanner(System.in);
		int fn;
		int idx;
		String bTitle, borrower, checkOutDate;

		do {
			System.out.print("��ȣ�� �Է��ϼ��� (1: ���� | 2:�ݳ� | 3:å ����Ʈ | 0 : ����) : ");
			fn = sc.nextInt();
			switch (fn) {
			case 1:
				System.out.print("�����ϰ��� �ϴ� å �̸���? : ");
				bTitle = sc.next();
				for (idx = 0; idx < books.length; idx++) {
					if (books[idx].getBookTitle().equals(bTitle)) {
						break;
					}
				}
				if (idx == books.length) {
					System.out.println("���� ���������� �������� ���� �����Դϴ�.");
				} else {
					if (books[idx].getState() == BookLib.STATE_BORROWED) {
						System.out.println("���� �������� �����Դϴ�.");
						System.out.println("���� �Ұ��մϴ�.");
					} else {
						System.out.print("�������� ������? : ");
						borrower = sc.next();
						System.out.print("�������� ? : ");
						checkOutDate = sc.next();
						books[idx].checkOut(borrower, checkOutDate);
					}
				}
				break;
			case 2:
				System.out.print("�ݳ��ϰ��� �ϴ� å �̸���? : ");
				bTitle = sc.next();
				for (idx = 0; idx < books.length; idx++) {
					if (books[idx].getBookTitle().equals(bTitle)) {
						break;
					} 				
				}
				if( idx == books.length) {
					System.out.println("�ش� ������ �� �������� å�� �ƴմϴ�.");
				} else {
					books[idx].checkIn();
				}
				break;
			case 3:
				System.out.println("å ����Ʈ�� ������ �����ϴ�.");
				for(BookLib book : books) {
					book.printState();				
				}
				break;
			case 0:
				break;
			default:
				System.out.println("�ùٸ� ��ȣ�� �Է��ϼ���.");
				
			}
		} while (fn != 0);
			System.out.println("���� �Ǿ����ϴ�.");

	}

}
