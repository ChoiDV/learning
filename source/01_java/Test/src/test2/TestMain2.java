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
			System.out.print("������ �Ͻ÷��� �ƹ�Ű�� �������� (�����Ͻ÷��� n �� �������� ) : ");
			answer = sc.next();
			if (answer.equalsIgnoreCase("n")) {
				System.out.println("����Ǿ����ϴ�.");
				break;
			}
			System.out.print("�̸��� �Է��ϼ��� : ");
			name = sc.next();
			System.out.print("�ڵ��� ��ȣ�� �Է��ϼ��� : ");
			phone = sc.next();
			if(person.get(phone) != null) {
				System.out.println("�̹� ���ԵǾ� �ִ� ��ȭ��ȣ�Դϴ�.��ȭ��ȣ�� �ߺ��� �� �����ϴ�.");
				continue;
			}
			System.out.print("�ּҸ� �Է��ϼ��� : ");
			sc.nextLine();
			address = sc.nextLine();
			person.put(phone, new Customer(name, phone, address));
			System.out.println();
		} while (true);

		Iterator<String> iterator = person.keySet().iterator();
		while (iterator.hasNext()) {
			String key = iterator.next();
			System.out.println(key + " �� ȸ������ :" + person.get(key));
		}
		System.out.println("\t\t.....");
	}
}
