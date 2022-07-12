package com.lec.ex01_inputstreamOutputstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

// (1) 파일을 연다
// (2) 데이터를 읽는다 : .read(); = 1byte씩 읽는다. 속도가 느림 / 그래서 read(byte[]) byte[]만큼 읽기
// (3) 파일 닫는다.
public class Ex02_inputStreamByteArray {
	public static void main(String[] args) {
		InputStream is = null;
		try {
			is = new FileInputStream("txtFile/inTest.txt"); // 파일 경로 적기 확장자까지 // 1.파일연다
			byte[] bs = new byte[10];
			while (true) { // 2.파일 읽는다
				int readByteCount = is.read(bs); // 10byte씩 읽기 (byte형 배열 10크기에 넣어서 갖고오니까 10byte씩 읽기)
				if (readByteCount == -1) { // 파일 끝인지 여부
					break;
				}
				for (int i = 0; i < readByteCount; i++) {
					System.out.print((char) bs[i]);
				}
			}

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {  // 파일 닫는다.
				if (is != null) {
					is.close();
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}

		}

	}
}
