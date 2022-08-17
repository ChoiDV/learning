package com.lec.ex05_printwriter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;

public class Ex01_PrintWriter {

	public static void main(String[] args) {
		OutputStream os = null;
		Writer writer = null;
		PrintWriter printWriter = null;
		try {
			// 이렇게 쓸수도 있고
			os = new FileOutputStream("txtFile/outTest.txt",true);  // 기본 스트림
			printWriter = new PrintWriter(os); // 보조 스트림
			
			// 두번째 이렇게 쓸수도 있고
//			writer = new FileWriter("txtFile/outTest.txt",true); // 기본 스트림
//			printWriter = new PrintWriter(writer); // 보조스트림
			
			// 세번째  이렇게도 가능한데 
//			printWriter = new PrintWriter("txtFile/outTest.txt");  // 파일 append 불가( 덮어서 계속 쓰기 불가)
			
			System.out.println("안녕하세요\n반갑습니다.");
			printWriter.println("안녕하세요\n반갑습니다.");
			
			System.out.print("print는 자동 개행이 안되서 개행추가\n");
			printWriter.print("print는 자동개행이 안되서 개행추가\n");
			
			System.out.printf("%s \t %d \t %d \t %5.1f\n","홍길동",90,91,90.5);
			printWriter.printf("%s \t %d \t %d \t %5.1f\n","홍길동",90,91,90.5);
			
			System.out.printf("%s \t %3d \t %3d \t %5.1f\n","신길동",100,100,100.0);
			printWriter.printf("%s \t %3d \t %3d \t %5.1f\n","신길동",100,100,100.0);
			
					
		} catch (IOException e) {  // IOException 상위버전으로 exception 통일 가능 
			System.out.println(e.getMessage());
		} finally {
			printWriter.close();			
		}

	}

}
