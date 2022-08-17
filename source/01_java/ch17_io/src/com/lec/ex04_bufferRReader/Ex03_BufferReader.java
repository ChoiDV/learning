package com.lec.ex04_bufferRReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Ex03_BufferReader {
	public static void main(String[] args) {
		Reader reader = null;
		BufferedReader br = null;
		try {
			reader = new FileReader("txtFile/inTest.txt"); // 1.�⺻��Ʈ�� ����
			br = new BufferedReader(reader);  // ������Ʈ�� ����
			while(true) {
				String linedata = br.readLine(); // 2. ���پ� ������ �б� 
				if(linedata == null) { // ������ ���� ��� break;
					break;
				}
				System.out.println(linedata);
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if( br != null) {
					br.close();
				}
				if( reader != null) {
					reader.close();
				}			
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
			
		}
		
	}
}