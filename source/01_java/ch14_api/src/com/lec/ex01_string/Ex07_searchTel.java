package com.lec.ex01_string;

import java.util.Scanner;

// �迭�� �ִ� ��ȭ��ȣ ã�� ��ü ��ȭ��ȣ ���
public class Ex07_searchTel {
	public static void main(String[] args) {
		
		String[] tels = {"010-4434-9878","010-7608-9878","010-4078-9887","031-123-4567"};
		Scanner sc = new Scanner(System.in);
		String searchTel;  // ����ڷκ��� ��ȭ��ȣ �� ��ȣ �Է� ���� ������ �Ҵ��ϴ� ����
		boolean searchOk = false;
		System.out.print("�˻��ϰ��� �ϴ� ȸ���� ��ȭ��ȣ ���ڸ��� ? : ");
		searchTel = sc.next();  // �Է¹��� ��ȭ��ȣ ���ڸ��� searchTel �� �Ҵ�
		
		for(int idx=0; idx<tels.length; idx++) {
			// idx ��ȭ��ȣ ���ڸ� ����
			String post = tels[idx].substring(tels[idx].lastIndexOf('-')+1);
			if(post.equals(searchTel)) {
				System.out.println("�˻��Ͻ� ��ȭ��ȣ�� : "+ tels[idx] + " �Դϴ�" );
				// break;  �� ����ϸ� ���ڸ��� �ߺ��Ȱ� �������ε� �Ѱ��� ã���� �׷���
				searchOk = true;
			} // if - ��ȭ��ȣ�� ã�� ��� ���̻� �˻����� �ʰ�  for�� ��������.
		} // for
		if(! searchOk) { // searchTel�� �迭 ��ȭ�� ��� ��ã�� idx�� ������ �� ��� �� idx�� 4�� �Ȱ��
			System.out.println("�˻��Ͻ� ��ȭ��ȣ�� �����ϴ�.");
		}
		sc.close();
		
		
		
	}

}
