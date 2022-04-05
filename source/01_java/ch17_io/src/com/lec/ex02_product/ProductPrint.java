package com.lec.ex02_product;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class ProductPrint {

	public static void main(String[] args) {
		ArrayList<Product> products = new ArrayList<Product>();
		InputStream fis = null;
		DataInputStream dis = null;
		try {
			fis = new FileInputStream("src/com/lec/ex02_product/product.dat");
			dis = new DataInputStream(fis);
			while (true) {
				// Product p = new Product(); ����� p.set���� �־��.					
				String name = dis.readUTF(); // ��ǰ��
				int price = dis.readInt(); // ����
				int ps = dis.readInt(); // ���
				products.add(new Product(name, price, ps));	
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println("��� �����ʹ� ������ �����ϴ�.");
		} finally {
			try {
				if (dis != null) {
					dis.close();
				}
				if (fis != null) {
					fis.close();
				}
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
			if(products.isEmpty()) {
				System.out.println("�Էµ� ����� �����ϴ�.");
			} else {
				for(Product product : products) {
					System.out.println(product);
				}
				System.out.println("�̻� ��ǰ "+products.size() + " ���� �Էµ�");
			}
		}

	}

}
