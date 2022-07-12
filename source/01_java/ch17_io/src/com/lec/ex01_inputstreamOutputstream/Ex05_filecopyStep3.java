package com.lec.ex01_inputstreamOutputstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

// ���߿� �Խ��� �ҋ� ����� ����

public class Ex05_filecopyStep3 {
	public static void main(String[] args) {
		InputStream is = null;
		OutputStream os = null;
		try {
			File file = new File("D:/�ڹ� ������/picture/bts.jpg");
			is = new FileInputStream(file); // (1)
			os = new FileOutputStream("D:/�ڹ� ������/makepicture/bts2.jpg");
			int cnt = 0;
			byte[] bs = new byte[(int) file.length()]; // file�� ũ�⸸ŭ�� bs�迭�� ���� ����ϱ�
			while (true) { // (2)
				int readByteCount = is.read(bs);
				if (readByteCount == -1) {
					break; // ������ ������ ����
				}
				os.write(bs,0,readByteCount); // bs�� 0�� index���� readByteCount��ŭ write �Ѵ�.
				cnt++;
			}
			System.out.println(cnt + " �� while�� �����Ͽ� ����� ���� ����");
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
