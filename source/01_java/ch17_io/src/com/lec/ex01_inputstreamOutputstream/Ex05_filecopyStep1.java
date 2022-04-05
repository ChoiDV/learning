package com.lec.ex01_inputstreamOutputstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

// 1. 스트림 객체 만들기(입력용, 출력용)
// 2. 읽고 쓴다 ( 읽은 파일이 -1이 나올때까지
// 3. 파일 닫는다 (스트림객체.close();)
public class Ex05_filecopyStep1 {
	public static void main(String[] args) {
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new FileInputStream("D:/자바 최진영/picture/bts.jpg"); // (1)
			os = new FileOutputStream("D:/자바 최진영/makepicture/bts2.jpg");
			int cnt = 0;
			while (true) { // (2)
				int i = is.read(); // 1바이트씩 읽기
				if (i == -1) {
					break; // 파일의 끝인지 여부
				}
				os.write(i);
				cnt++;
			}
			System.out.println(cnt + " 번 while문 실행하여 힘들게 복사 성공");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (os != null) {
					os.close();
				}
				if (is != null) {
					is.close();
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}

	}
}
