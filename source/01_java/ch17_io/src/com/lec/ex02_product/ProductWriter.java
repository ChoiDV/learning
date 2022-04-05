package com.lec.ex02_product;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductWriter { // ����Է�

	public static void main(String[] args) {
		ArrayList<Product> list = new ArrayList<Product>();
		Scanner sc = new Scanner(System.in);
		String answer;
		OutputStream fos = null;
		DataOutputStream dos = null;
		try {
			fos = new FileOutputStream("src/com/lec/ex02_product/product.dat", true);
			dos = new DataOutputStream(fos);
			do {
				System.out.print("��� �Է��Ͻ÷��� Y | �����Ϸ��� N �� �������� : ");
				answer = sc.next();
				if (answer.equalsIgnoreCase("n")) {
					System.out.println("����Ǿ����ϴ�.");
					break;
				} else if (answer.equalsIgnoreCase("y")) {
					System.out.print("��ǰ���� �Է��ϼ��� : ");
					dos.writeUTF(sc.next());
					System.out.print("������ �Է��ϼ��� : ");
					dos.writeInt(sc.nextInt());
					System.out.print("��� ������ �Է��ϼ��� : ");
					dos.writeInt(sc.nextInt());
				}
			} while (true);

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (dos != null) {
					dos.close();
				}
				if (fos != null) {
					fos.close();
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}

	}

}
