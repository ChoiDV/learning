package com.lec.ex01_inputstreamOutputstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

// 1byte 씩 읽는거 할거임
// (1) 파일을 연다(입력용 스트림객체생성)
// (2) 데이터를 읽는다
// (3) 파일을 닫는다
public class Ex01_InputStream {
	public static void main(String[] args) {
		
		InputStream is = null;
		try {
			is = new FileInputStream("txtFile/inTest.txt"); // 1. 파일을 연다
			while (true) { // 2. 데이터를 읽는다.
				int i = is.read(); // 1byte 씩 읽기
				if (i == -1) {
					break; // 파일의 끝이면 반복문 break;
					// 파일의 끝에는 끝이라는 의미로 -1이 들어감 그래서 -1이 들어오면 break;
				}
				System.out.print((char) i + "("+i+")"); // i 만 출력하면 아스키코드로 출력되기때문에 char로 형변환해야 글자로 보임
				// println을 사용하지않는이유는 내부적으로 \i\n이 되어있음
			}
			System.out.println("\n끝"); 
			// try 안에 파일닫는것을 넣으면 안됌. 파일은 있지만 파일을 읽을수없는경우에는 밑의 catch로 가기때문에 파일을 닫을수 없음
		} catch (FileNotFoundException e) {
			System.out.println("파일을 못 찾은 경우 예외 : " + e.getMessage());
		} catch (IOException e) {
			System.out.println("파일을 읽을수 없는 경우 예외 : " + e.getMessage());
		} finally {
			// 3.파일을 닫는다.
			try {
				if( is != null) {
					is.close();   // close 반드시 해줘야함 안하면 저장이 안됌.
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}

	}
}
