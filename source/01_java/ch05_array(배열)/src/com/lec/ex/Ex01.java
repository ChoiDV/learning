package com.lec.ex;

public class Ex01 {

	public static void main(String[] args) {
		// �迭   - ���۷��� ���� = ���� �����ִ°� �ƴ� �ּҰ��� �������ִ� �������� ���۷��� ������� ��.
		int i = 10; // ������ ����� �ʱ�ȭ
		i = 20;
		//  1. �迭 ������ ����� �ʱ�ȭ
		int[] iArr = {10,20,30,40,50};
		iArr[2] = 300;  // �迭�� index�� ���� 0������ ���� 0,1,2,3,4,5 ...  
		//�迭�� ���� ������  .length �� ��Ÿ��   iArr.length
		
		for(int idx = 0; idx < iArr.length; idx++) {
			System.out.println(iArr[idx]);
		}
		
		// 2. �迭 ���� ����� �迭 �޸� ���� Ȯ�� = �ѹ� ������ �迭�� ũ��� ���� �Ұ�.
		int[] iArr2 = new int[5];
		for(int idx =0; idx<iArr2.length; idx++) {
			System.out.printf("iArr2[%d] = %d\n", idx, iArr2[idx]);
		}
		iArr2[0] = 999; 
		iArr2[1] = 888;
		for(int idx =0; idx<iArr2.length; idx++) {
			System.out.printf("iArr2[%d] = %d\n", idx, iArr2[idx]);
		}
		
		// 3. �迭 ������ ���� ����
		int[] iArr3;
		iArr3 = new int[3];   // �迭 ���� Ȯ���ϰ� �� ���� ���� 0���� �ڵ� �ʱ�ȭ (���۷��� ����)
		for(int idx=0; idx<iArr3.length; idx ++) {
			System.out.printf("iArr3[%d] = %d\n", idx, iArr3[idx]);
		}
	
		
	}

}
