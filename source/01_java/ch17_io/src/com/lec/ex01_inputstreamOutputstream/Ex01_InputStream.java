package com.lec.ex01_inputstreamOutputstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

// 1byte �� �д°� �Ұ���
// (1) ������ ����(�Է¿� ��Ʈ����ü����)
// (2) �����͸� �д´�
// (3) ������ �ݴ´�
public class Ex01_InputStream {
	public static void main(String[] args) {
		
		InputStream is = null;
		try {
			is = new FileInputStream("txtFile/inTest.txt"); // 1. ������ ����
			while (true) { // 2. �����͸� �д´�.
				int i = is.read(); // 1byte �� �б�
				if (i == -1) {
					break; // ������ ���̸� �ݺ��� break;
					// ������ ������ ���̶�� �ǹ̷� -1�� �� �׷��� -1�� ������ break;
				}
				System.out.print((char) i + "("+i+")"); // i �� ����ϸ� �ƽ�Ű�ڵ�� ��µǱ⶧���� char�� ����ȯ�ؾ� ���ڷ� ����
				// println�� ��������ʴ������� ���������� \i\n�� �Ǿ�����
			}
			System.out.println("\n��"); 
			// try �ȿ� ���ϴݴ°��� ������ �ȉ�. ������ ������ ������ ���������°�쿡�� ���� catch�� ���⶧���� ������ ������ ����
		} catch (FileNotFoundException e) {
			System.out.println("������ �� ã�� ��� ���� : " + e.getMessage());
		} catch (IOException e) {
			System.out.println("������ ������ ���� ��� ���� : " + e.getMessage());
		} finally {
			// 3.������ �ݴ´�.
			try {
				if( is != null) {
					is.close();   // close �ݵ�� ������� ���ϸ� ������ �ȉ�.
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}

	}
}
