package com.lec.ex07_book1;

import java.util.Scanner;

public class TestMain {

	public static void main(String[] args) {
		Book[] books = { new Book("123��-101-1��","java","ȫ�浿"),
						 new Book("456��-101-1��","oracle","�ű浿"),
						 new Book("147��-101-1��","mysql","��浿"),
						 new Book("258��-101-1��","web","�̱浿"),
						 new Book("789��-101-1��","jsp","���浿")};
		Scanner sc = new Scanner(System.in);
		int fn; // ��ɹ�ȣ(1: ����, 2:�ݳ� , 3:å ����Ʈ, 0 : ����)
		int idx; // �����ϰų� �ݳ��Ϸ��� �Ҷ� ��ȸ�� å�� index
		String bTitle, borrower, checkOutDate; // ����ڿ��� ���� å �̸�, ������, ������
		
		do {
			System.out.print("��ȣ�� �Է��ϼ��� (1: ���� | 2:�ݳ� | 3:å ����Ʈ | 0 : ����) : ");
			fn = sc.nextInt();	
			switch (fn) {
			case 1:// ���� 
				// 1. å�̸� �Է� 2. å��ȸ 3. å ���� Ȯ�� 4. ������ �Է� 5. ������ �Է� 6. ����޼ҵ� ȣ��
				// 1. å �̸� �Է�
				System.out.print("�����ϰ��� �ϴ� å�̸���? : ");
				bTitle = sc.next(); // �����̽� �������� �ʴ� ��ĳ��
				// 2. å ��ȸ
				for(idx=0; idx <books.length; idx++) {
					if(books[idx].getBookTitle().equals(bTitle)) {
						break;  // å ã���� break;
					}		  									
				} // å ��ȸ for
				if ( idx ==books.length) {
					System.out.println("���� ���������� �������� ���� �����Դϴ�.");
				} else { // books[idx] ������ ����ó��
					// 3. å���� Ȯ��
					if(books[idx].getState() == Book.STATE_BORROWED) { // ����Ұ� ����
						System.out.println("���� �������� �����Դϴ�.");
						System.out.println("���� �Ұ��մϴ�.");
					}else { // ���Ⱑ�ɻ���
						// 4. ������ �Է�, 5. ������ �Է�, 6. ���� �޼ҵ� ȣ��
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
				for(Book book : books) {
					book.printState();				
				}
				break;
			case 0:
				break;
			default:
				System.out.println("�ùٸ� ��ȣ�� �Է��ϼ���.");
			}
		} while(fn != 0);
		System.out.println("����Ǿ����ϴ�.");
			
		
//		while(true) {
//			System.out.print("��ȣ�� �Է��ϼ��� (1: ���� | 2:�ݳ� | 3:å ����Ʈ | 0 : ����) : ");
//			fn = sc.nextInt();
//			if(fn ==0) {
//				System.out.println("����Ǿ����ϴ�.");
//				break;
//			}
//		}
		
	
		
	} // main

} // Class
