package com.lec.ex;

public class EX02 {

	public static void main(String[] args) {
		// �迭�� ����Ҷ��� �Ϲ� for������ Ȯ�� for���� ����Ѵ�.
		// �Ϲ� for�� vs Ȯ�� for�� ( �迭 ����Ҷ��� ����Ѵ�.)

		int[] arr = new int[3]; // int[] arr = {0,0,0}; �� ����
		for (int idx = 0; idx < arr.length; idx++) {
			System.out.printf("arr[%d] = %d\n", idx, arr[idx]);
		}
		for (int temp: arr) { 	// for( �ӽú��� : �迭���� ){ ����Ұ� };
			System.out.println(temp);   // Ȯ�� for���� �ε��� ��ȣ�� �� �ε�����ȣ�� �ʿ��Ҷ��� �Ϲ� for�� ���
		}
		
		for(int i =0; i< arr.length ; i++) {  // �Ϲ� for���� �̿��� �迭 ���� ����.
			arr[i] = 5;
			System.out.println(arr[i]);
		}
		
		for (int temp : arr) {  // Ȯ�� for���� �̿��� �迭 ����. �ٵ� �Ұ�����.
								// Ȯ��for���� �̿��� �迭 ������ 
			temp = 9;			// temp ��� �ӽú����� ��ġ�⶧���� ���� arr �迭���� ���� ������ �ȵǰ� 
								// temp�� �����ϴ°��� ��.
		}
		
	
	}
	
}
