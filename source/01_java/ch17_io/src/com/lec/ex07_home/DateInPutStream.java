package com.lec.ex07_home;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class DateInPutStream {

	public static void main(String[] args) {
		InputStream is = null;
		DataInputStream dis = null;

		try {
			is = new FileInputStream("homeFile/memberFile4.txt");
			dis = new DataInputStream(is);
			while (true) {
				String data = dis.readUTF();
				System.out.print(data);
			}

		} catch (FileNotFoundException e) {
			System.out.println("파일 찾을수 없음.");
		} catch (IOException e) {
			System.out.println("데이터 모두 가져오기 완료");
		} finally {

			try {
				if (dis != null) {
					dis.close();
				}
				if (is != null) {
					is.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
