package com.lec.ex;

// 1~10���� ������ ���� ����ϰ� �� ���� ¦������ Ȧ������ ����ϱ�.
public class Ex02 {
	private static int sum(int from, int to) { // from ~ to ���� ������ ��� return
		int result = 0;						  // ��� ���� �ΰ� �޾ƾ� �����ϴ� �޼ҵ� 
		for (int i = from; i <= to; i++) {
			result += i; // result = result +i;
		}
		return result; // �޼ҵ� ���� �޼ҵ� = �Լ�
	}
	// �����̸��� �Լ��� �ΰ��̻� ����°��� �Լ��� �����ε��̶�� ��.
	// �̰��� �ڹ��� �����߿� �ϳ�.
	// static �� ���� �����Լ����� �ٷ� ����Ѵٴ°�. �� �����ڸ� ����ؼ� �������� �ʰ� �ٷ� Ŭ�����̸�.�޼ҵ��̸� ���� ����ϱ�
	// void �� return���� ��������.!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	// return ���� �������� void ��� x
	
	// ���������� [static] ����type �޼ҵ�� ([�Ű�����1],[�Ű�����2],...)
	private static int sum(int to) { // ���� �ϳ��� �޾Ƶ� �˾Ƽ� 1���� to���� ����ϴ� �޼ҵ�
		int result = 0;
		for (int i = 1; i <= to; i++) {
			result += i; // result = result +i;
		}
		return result;
	}

	private static String evenOdd(int value) {
		// ���׿����� ����ϸ� return value%2==0 ? "¦���Դϴ�." : "Ȧ���Դϴ�.";
		String result;
		if (value % 2 == 0) {
			result = "¦���Դϴ�. ";
		} else {
			result = "Ȧ���Դϴ�. ";
		}
		return result;

	}

	public static void main(String[] args) {
		// sum �Լ��� evenOdd �Լ� ȣ���ؼ� ����ϱ�.
		int tot = sum(1, 10); // sum(int,int) �޼ҵ带 ����Ѱ�
		System.out.println("1~10���� �������� : " + tot);
		System.out.println(evenOdd(tot));

		tot = sum(10, 100); // sum(int,int) �޼ҵ带 ����Ѱ�
		System.out.println("10~100���� �������� : " + tot);
		System.out.println(evenOdd(tot));
		
		tot = sum(50); // sum(int) �޼ҵ带 ����Ѱ�
		System.out.println("1���� 50������ �������� : " +tot);

	}

	// 5������ private �� ��������
	// int �� sum �Լ��� ���ϰ��� �ڷ����� ���ָ� ��.

}
