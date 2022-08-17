package com.lec.ex07_home;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Test {

	public static void main(String[] args) {
		InputStream is = null;
		
		try {
			is = new FileInputStream("homeFile/member.txt");
			while(true) {							
			int i = is.read();
			if( i ==-1) {
				break;
			}
			System.out.print((char)i);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		

	}

}
