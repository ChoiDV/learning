package com.lec.ex02_date;

import java.util.GregorianCalendar;

// 두 시점의 시간 계산
public class Ex03_gc_term {
	public static void main(String[] args) {
		GregorianCalendar gcNow = new GregorianCalendar(); // 지금 현재의 날짜와 시간을 gcNow 에 넣음
		GregorianCalendar gcThat = new GregorianCalendar(2022, 2, 11, 9,30);
		long start = gcThat.getTimeInMillis(); // 1970년부터~개강시점 사이의 밀리세컨
		long end = gcNow.getTimeInMillis(); // 1970년부터~ 현재 사이의 밀리세컨
		int day = (int)(end-start)/ (1000*60*60*24);  //  나누기 초,분,시,일
		System.out.println("개강일부터 현재까지 몇일 지났는지 = "+ day);
	}
}

