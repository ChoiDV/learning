package com.lec.ex02_datastream;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
// 1. 스트림 객체 생성=파일을 연다
// 2. 데이터 쓴다. (메모장에 안보이게 쓴다)
// 3. 스트림 객체 닫는다.=파일을 닫는다.
public class Ex01_DataOutPutStream {
	public static void main(String[] args) {
		OutputStream fos = null;
		DataOutputStream dos = null;
		try {
			fos = new FileOutputStream("txtFile/dataFile.dat",true); // 기본스트림
			dos = new DataOutputStream(fos); // 보조 스트림은 기본 스트림을 통해서만 생성
			// 이름-학년-점수 write
			dos.writeUTF("홍길동"); // 스트링값 저장
			dos.writeInt(2);	  // 정수값 저장
			dos.writeDouble(90.5); // double값 저장
			
			dos.writeUTF("신길동"); 
			dos.writeInt(3);	  
			dos.writeDouble(99.5); 
			System.out.println("파일 저장 완료");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(dos != null) {
				dos.close();
				}
				if(fos != null) {
					fos.close();
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
