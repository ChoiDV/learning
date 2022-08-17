package com.lec.ex01_inputstreamOutputstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

// 나중에 게시판 할떄 사용할 로직

public class Ex05_filecopyStep3 {
	public static void main(String[] args) {
		InputStream is = null;
		OutputStream os = null;
		try {
			File file = new File("D:/자바 최진영/picture/bts.jpg");
			is = new FileInputStream(file); // (1)
			os = new FileOutputStream("D:/자바 최진영/makepicture/bts2.jpg");
			int cnt = 0;
			byte[] bs = new byte[(int) file.length()]; // file의 크기만큼의 bs배열을 만들어서 사용하기
			while (true) { // (2)
				int readByteCount = is.read(bs);
				if (readByteCount == -1) {
					break; // 파일의 끝인지 여부
				}
				os.write(bs,0,readByteCount); // bs를 0번 index부터 readByteCount만큼 write 한다.
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
