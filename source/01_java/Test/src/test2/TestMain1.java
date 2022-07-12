package test2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class TestMain1 {
	public static void main(String[] args) {
		ArrayList<Customer> person = new ArrayList<Customer>();
		OutputStream os = null;
		Scanner sc = new Scanner(System.in);
		String answer, name, phone, address;

		try {
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
				System.out.print("주소를 입력하세요 : ");
				sc.nextLine();
				address = sc.nextLine();
				person.add(new Customer(name, phone, address));
				System.out.println();
			} while (true);
			os = new FileOutputStream("test/customer.txt", true);
			if (person.isEmpty()) {
				System.out.println("가입한 사람이 없습니다.");
			} else {
				for (int i = 0; i < person.size(); i++) {
					String p = person.get(i).toString();
					String line = "\n";
					System.out.println(p);
					os.write(p.getBytes());
					os.write(line.getBytes());
				}
				System.out.println("\t\t.....");
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (os != null) {
					os.close();
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}

		}

	}
}
