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
			// �̷��� ������ �ְ�
			os = new FileOutputStream("txtFile/outTest.txt",true);  // �⺻ ��Ʈ��
			printWriter = new PrintWriter(os); // ���� ��Ʈ��
			
			// �ι�° �̷��� ������ �ְ�
//			writer = new FileWriter("txtFile/outTest.txt",true); // �⺻ ��Ʈ��
//			printWriter = new PrintWriter(writer); // ������Ʈ��
			
			// ����°  �̷��Ե� �����ѵ� 
//			printWriter = new PrintWriter("txtFile/outTest.txt");  // ���� append �Ұ�( ��� ��� ���� �Ұ�)
			
			System.out.println("�ȳ��ϼ���\n�ݰ����ϴ�.");
			printWriter.println("�ȳ��ϼ���\n�ݰ����ϴ�.");
			
			System.out.print("print�� �ڵ� ������ �ȵǼ� �����߰�\n");
			printWriter.print("print�� �ڵ������� �ȵǼ� �����߰�\n");
			
			System.out.printf("%s \t %d \t %d \t %5.1f\n","ȫ�浿",90,91,90.5);
			printWriter.printf("%s \t %d \t %d \t %5.1f\n","ȫ�浿",90,91,90.5);
			
			System.out.printf("%s \t %3d \t %3d \t %5.1f\n","�ű浿",100,100,100.0);
			printWriter.printf("%s \t %3d \t %3d \t %5.1f\n","�ű浿",100,100,100.0);
			
					
		} catch (IOException e) {  // IOException ������������ exception ���� ���� 
			System.out.println(e.getMessage());
		} finally {
			printWriter.close();			
		}

	}

}
