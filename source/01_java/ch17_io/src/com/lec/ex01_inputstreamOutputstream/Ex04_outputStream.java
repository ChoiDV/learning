package com.lec.ex01_inputstreamOutputstream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

// (1) 파일을 연다(출력용 스트림 객체 생성)
// (2) write 한다
// (3) 파일을 닫는다
public class Ex04_outputStream {
	public static void main(String[] args) {
		OutputStream os = null;
		try {
			os = new FileOutputStream("txtFile/outTest.txt",true); // 얘는 폴더가 없을때 예외발생함 파일은 없으면 만들어서 작성해줌 ( 즉 경로를 잘 작성해야함)
			// true 사용시 outTest.txt 파일이 없으면 새로 만들어서 작성하고 있으면 있는파일에다가 추가로 작성한다는 의미 (append 의미)
			String str = "Hello, Java\n이 시국에 모두 건강하세요";
			byte[] bs = str.getBytes(); // 스트링을 byte 배열로 바꾸는 함수
//			for (int i = 0; i < bs.length; i++) { // (2) write
//				os.write(bs[i]);
//			}
			os.write(bs);
			System.out.println("파일 출력 성공");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {  // (3)
				if (os != null) {
					os.close();
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
