package com.lec.loop_�ݺ���;

public class Ex05_breakContinue {
// break : ���� ������ ���� ����
// coninue : ���� ������ ���߰� �����κ����� ��
	
	public static void main(String[] args) {
		for(int i=0; i <=5 ; i++ ) {
			if (i==3) {
			//	break;  // ���ѹݺ������� break�� ����ؼ� ������.
				continue;
			}
			System.out.println(i + " . �ȳ�");
		}

	}

}
