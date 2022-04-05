package com.lec.ex02_datastream;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Ex02_dataInputStream {
	public static void main(String[] args) {
		InputStream fis = null;
		DataInputStream dis = null;

		try {
			fis = new FileInputStream("txtFile/dataFile.dat");
			dis = new DataInputStream(fis); // ������Ʈ���� �⺻��Ʈ���� ���ؼ� ����
			while (true) {
				String name = dis.readUTF();
				int grade = dis.readInt();
				double score = dis.readDouble();
				System.out.print("�̸� : " + name + " \t" + grade + " �г�\t " + " ���� : " + score + " ��\n");

			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println("�̻� ������ ��");
		} finally {
			try {
				if (dis != null) {
					dis.close();
				}
				if (fis != null) {
					fis.close();
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}

}
