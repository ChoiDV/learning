package com.lec.ex02_date;

import java.util.Calendar;
import java.util.Date;

public class Ex04_date {
	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date);
		int year = date.getYear(); // ���� �����ö�
		int month = date.getMonth()+1; // �� �������� (Calendar.MONTH); �� 0,1,2,3,...11�� �ý����� 0���� ���� �׷��� +1 �������
		int day = date.getDate(); // ��
		System.out.printf("%d�� %d�� %d�� \n",year,month,day);

		// %d(����) %f(�Ǽ�) %s(���ڿ�) %c(����) 
		// %tY(��) %tm(��) %td(��) %ta(����) %tH(24��) %tl(12��) %tM(��) %tS(��)
		System.out.printf("%tY�� %tm�� %td�� %ta���� %tp %tl�� %tM�� %tS��", date,date,date,date,date,date,date,date);
		System.out.println();
		System.out.printf("%1$tY�� %1$tm�� %1$td�� %1$ta���� %1$tp %1$tl�� %1$tM�� %1$tS��", date);
		
		
		

	}
}
