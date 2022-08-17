package com.lec.ex03_readerwriter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Ex02_Writer {
	public static void main(String[] args) {
		Writer writer = null;
		try {
			writer = new FileWriter("txtFile/inTest.txt", true);
//			char[] msg = {'��','��','��','��','��'};
			String msg = "\n\n�߰��� �ؽ�Ʈ �����Դϴ�. �ȳ��ϼ���";
			writer.write(msg);
			System.out.println("���� �Է� ����");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (writer != null) {
					writer.close();
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
