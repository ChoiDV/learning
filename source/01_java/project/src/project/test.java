package project;

import java.util.Scanner;

public class test {
	public static void main(String[] args) {

		//

		final int size = 10;
		int[] seats = new int[size];

		while (true) {
			System.out.println("------------------------------");
			for (int i = 0; i < size; i++)
				System.out.print(i + 1 + " ");
			System.out.println("\n------------------------------");
			for (int i = 0; i < size; i++)
				System.out.print(seats[i] + " ");
			System.out.println("\n------------------------------");
			System.out.println("���Ͻô� �¼���ȣ�� �Է��ϼ��� (����� -1) : ");
			Scanner scan = new Scanner(System.in);
			int s = scan.nextInt();
			if (s == -1) {
				System.out.println("���α׷��� ����Ǿ����ϴ�. ");
				break;
			}

			if (s <= 0 || s > size) {
				System.out.println("1���� 10������ ���ڸ� �Է��ϼ���. ");
				continue;

			}

			if (seats[s - 1] == 0) {
				seats[s - 1] = 1;
				System.out.println("���� �Ǿ����ϴ�. ");

			}

			else {
				System.out.println(" �̹� ����� �ڸ��Դϴ�. ");

			}

		}

	}
}
