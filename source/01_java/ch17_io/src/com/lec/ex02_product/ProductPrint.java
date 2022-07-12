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
				// Product p = new Product(); 만들고 p.set으로 넣어도됌.					
				String name = dis.readUTF(); // 상품명
				int price = dis.readInt(); // 가격
				int ps = dis.readInt(); // 재고량
				products.add(new Product(name, price, ps));	
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println("재고 데이터는 다음과 같습니다.");
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
				System.out.println("입력된 재고량이 없습니다.");
			} else {
				for(Product product : products) {
					System.out.println(product);
				}
				System.out.println("이상 물품 "+products.size() + " 가지 입력됨");
			}
		}

	}

}
