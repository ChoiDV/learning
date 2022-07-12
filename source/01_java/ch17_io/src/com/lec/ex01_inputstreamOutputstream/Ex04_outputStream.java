package com.lec.ex01_inputstreamOutputstream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

// (1) ������ ����(��¿� ��Ʈ�� ��ü ����)
// (2) write �Ѵ�
// (3) ������ �ݴ´�
public class Ex04_outputStream {
	public static void main(String[] args) {
		OutputStream os = null;
		try {
			os = new FileOutputStream("txtFile/outTest.txt",true); // ��� ������ ������ ���ܹ߻��� ������ ������ ���� �ۼ����� ( �� ��θ� �� �ۼ��ؾ���)
			// true ���� outTest.txt ������ ������ ���� ���� �ۼ��ϰ� ������ �ִ����Ͽ��ٰ� �߰��� �ۼ��Ѵٴ� �ǹ� (append �ǹ�)
			String str = "Hello, Java\n�� �ñ��� ��� �ǰ��ϼ���";
			byte[] bs = str.getBytes(); // ��Ʈ���� byte �迭�� �ٲٴ� �Լ�
//			for (int i = 0; i < bs.length; i++) { // (2) write
//				os.write(bs[i]);
//			}
			os.write(bs);
			System.out.println("���� ��� ����");
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
