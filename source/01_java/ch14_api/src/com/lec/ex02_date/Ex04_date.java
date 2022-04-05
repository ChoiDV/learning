package com.lec.ex02_date;

import java.util.Calendar;
import java.util.Date;

public class Ex04_date {
	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date);
		int year = date.getYear(); // 연도 가져올때
		int month = date.getMonth()+1; // 월 가져오기 (Calendar.MONTH); 는 0,1,2,3,...11월 시스템은 0부터 시작 그래서 +1 해줘야함
		int day = date.getDate(); // 일
		System.out.printf("%d년 %d월 %d일 \n",year,month,day);

		// %d(정수) %f(실수) %s(문자열) %c(문자) 
		// %tY(년) %tm(월) %td(일) %ta(요일) %tH(24시) %tl(12시) %tM(분) %tS(초)
		System.out.printf("%tY년 %tm월 %td일 %ta요일 %tp %tl시 %tM분 %tS초", date,date,date,date,date,date,date,date);
		System.out.println();
		System.out.printf("%1$tY년 %1$tm월 %1$td일 %1$ta요일 %1$tp %1$tl시 %1$tM분 %1$tS초", date);
		
		
		

	}
}
