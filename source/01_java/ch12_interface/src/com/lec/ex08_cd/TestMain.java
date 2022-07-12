package com.lec.ex08_cd;

import java.util.Scanner;

import com.lec.ex08_book2.BookLib;


public class TestMain {

	public static void main(String[] args) {
		
		BookLib[] books = { new BookLib("b1","java", "ȫ�浿"), 
							new BookLib("b2", "oracle", "�ű浿"),
							new BookLib("b3", "mysql", "��浿"), 
							new BookLib("b4", "web", "�̱浿"),
							new BookLib("b5", "jsp", "���浿") };
		
		CDLib[] cds = { new CDLib("c01","java_cd","b1"),
						new CDLib("c02","oracle_cd","b2"),
						new CDLib("c03","mysql_cd","b3"),
						new CDLib("c04","web_cd","b4"),
						new CDLib("c05","jsp_cd","b5"),
		};
		
		Scanner sc = new Scanner(System.in);
		int fn, idx, icx;
		String bTitle,cTitle, borrower, checkOutDate;
		
		do {
			System.out.print("��ȣ�� �Է��ϼ���(1:å ���� | 2:CD ���� | 3:å �ݳ� | 4:CD�ݳ� | 5: å ����Ʈ | 6: CD ����Ʈ |  0:����) : ");
			fn = sc.nextInt();
			switch(fn) {
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
						
						int cdIdx;
						for( cdIdx = 0; cdIdx < cds.length; cdIdx++) {
							if(books[idx].getBookNo().equals(cds[cdIdx].getBookNo())){
								break;
							}
						}
						if(cdIdx != cds.length) {
							System.out.println("���� CD�� �ֽ��ϴ�. �����Ͻðڽ��ϱ�(y / n ) ? : ");
							String answer = sc.next();
							if (answer.equals("y")) {
								cds[cdIdx].checkOut(borrower, checkOutDate);
							}
						}
					}
				}
				break;
			case 2:
				System.out.print("�����ϰ��� �ϴ� CD �̸���? : ");
				cTitle = sc.next();
				for (icx = 0; icx < cds.length; icx++) {
					if (cds[icx].getCdTitle().equals(cTitle)) {
						break;
					}
				}
				if (icx == cds.length) {
					System.out.println("���� ���������� �������� ���� CD �Դϴ�.");
				} else {
					if (cds[icx].getState() == BookLib.STATE_BORROWED) {
						System.out.println("���� �������� CD�Դϴ�.");
						System.out.println("���� �Ұ��մϴ�.");
					} else {
						System.out.print("�������� ������? : ");
						borrower = sc.next();
						System.out.print("�������� ? : ");
						checkOutDate = sc.next();
						cds[icx].checkOut(borrower, checkOutDate);
					}
				}
				break;
			case 3:
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
			case 4:
				System.out.print("�ݳ��ϰ��� �ϴ� CD �̸���? : ");
				cTitle = sc.next();
				for (icx = 0; icx < cds.length; icx++) {
					if (cds[icx].getCdTitle().equals(cTitle)) {
						break;
					} 				
				}
				if( icx == cds.length) {
					System.out.println("�ش� CD�� �� �������� CD�� �ƴմϴ�.");
				} else {
					cds[icx].checkIn();
				}
				break;
			case 5:
				System.out.println("å ����Ʈ�� ������ �����ϴ�.");
				for(BookLib book : books) {
					book.printState();				
				}
				break;				
			case 6:
				System.out.println("CD ����Ʈ�� ������ �����ϴ�.");
				for(CDLib cd : cds) {
					cd.printState();			
				}
				break;
			case 0:
				break;
			default:
				System.out.println("�ùٸ� ��ȣ�� �Է��ϼ���.");
				
				
			
			}
			
		} while(fn != 0);
		System.out.println("���� �Ǿ����ϴ�.");

	}

}
