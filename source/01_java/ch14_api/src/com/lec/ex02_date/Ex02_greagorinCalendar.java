package com.lec.ex02_date;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Ex02_greagorinCalendar {
	public static void main(String[] args) {
//		Calendar cal = Calendar.getInstance();
//		System.out.println(cal); // ������ ����
		GregorianCalendar cal = new GregorianCalendar();

		int year = cal.get(Calendar.YEAR); // ���� �����ö�
		int month = cal.get(Calendar.MONTH) + 1; // �� �������� (Calendar.MONTH); �� 0,1,2,3,...11�� �ý����� 0���� ���� �׷��� +1 �������
		int day = cal.get(Calendar.DAY_OF_MONTH); // ��
		int week = cal.get(Calendar.DAY_OF_WEEK); // ����  �Ͽ��� 1,��2,ȭ3,��4, ... �� 7 �� ��ȯ
		int hour24 = cal.get(Calendar.HOUR_OF_DAY); // 24�ð� ���� 
		int ampm = cal.get(Calendar.AM_PM);  //  ����(0)/����(1) 
		int hour = cal.get(Calendar.HOUR);   // 12�ð� ���� 
		int minute = cal.get(Calendar.MINUTE);  // ��
		int second = cal.get(Calendar.SECOND); // ��
		int millisec = cal.get(Calendar.MILLISECOND); // �� ����(��) ���� 1000�� 1�ʰ� �� 
		
		System.out.printf("%d��%d��%d��", year, month, day);
		
		switch (week) { // week ���Ϸ� �ٲٱ� 
		case 1:
			System.out.println("�Ͽ���");
			break;
		case 2:
			System.out.println("������");
			break;
		case 3:
			System.out.println("ȭ����");
			break;
		case 4:
			System.out.println("������");
			break;
		case 5:
			System.out.println("�����");
			break;
		case 6:
			System.out.println("�ݿ���");
			break;
		case 7:
			System.out.println("�����");
			break;
		}
		
		System.out.print(ampm == 0 ? "����" : "����");
		System.out.printf("%d�� %d�� %d�� %d",hour,minute,second,millisec);
		System.out.println();
		// %d(����) %f(�Ǽ�) %s(���ڿ�) %c(����) 
		// %tY(��) %tm(��) %td(��) %ta(����) %tH(24��) %tl(12��) %tM(��) %tS(��)
		System.out.printf("%tY�� %tm�� %td�� %ta���� %tp %tl�� %tM�� %tS��", cal,cal,cal,cal,cal,cal,cal,cal);
		System.out.println();
		System.out.printf("%1$tY�� %1$tm�� %1$td�� %1$ta���� %1$tp %1$tl�� %1$tM�� %1$tS��", cal);
		
		
		

	}
}
