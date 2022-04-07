package test2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class TestMain2 {

	public static void main(String[] args) {
		HashMap<String, Customer> person = new HashMap<String, Customer>();
		Scanner sc = new Scanner(System.in);
		String answer, name, phone, address;
		do {
			System.out.print("가입을 하시려면 아무키나 누르세요 (종료하시려면 n 를 누르세요 ) : ");
			answer = sc.next();
			if (answer.equalsIgnoreCase("n")) {
				System.out.println("종료되었습니다.");
				break;
			}
			System.out.print("이름을 입력하세요 : ");
			name = sc.next();
			System.out.print("핸드폰 번호를 입력하세요 : ");
			phone = sc.next();
			if(person.get(phone) != null) {
				System.out.println("이미 가입되어 있는 전화번호입니다.전화번호는 중복될 수 없습니다.");
				continue;
			}
			System.out.print("주소를 입력하세요 : ");
			sc.nextLine();
			address = sc.nextLine();
			person.put(phone, new Customer(name, phone, address));
			System.out.println();
		} while (true);

		Iterator<String> iterator = person.keySet().iterator();
		while (iterator.hasNext()) {
			String key = iterator.next();
			System.out.println(key + " 의 회원정보 :" + person.get(key));
		}
		System.out.println("\t\t.....");
	}
}
