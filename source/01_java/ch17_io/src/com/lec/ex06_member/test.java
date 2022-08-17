package com.lec.ex06_member;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class test {
	public static void main(String[] args) {
		InputStream is = null;
		
		try {
			is = new FileInputStream("memberFile/member.txt");
			while(true) {
				int s =is.read();
				if(s == -1) {
					break;
				}
				System.out.print((char)s);
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
