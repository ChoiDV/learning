package com.lec.ex2_human.main;

import com.lec.ex2_human.Man;
import com.lec.ex2_human.Woman;

//  import ���� * �� com.lec.ex2_human �ؿ��ִ� ������ ����Ʈ�Ѵٴ� ��.

public class MainTest {

// com.lec.ex2_human ��  com.lec.ex2_human.main ��Ű���� ���� ��Ű�� �ΰ� �׽�Ʈ�ϴ���.
// import �ʿ���� �����Ǹ� ������Ű�� 
// import�� �ʿ��ϸ� �ٸ� ��Ű����� ����
	
// �� �ٸ���Ű�� �̴�.

	public static void main(String[] args) {
		
		// ���� ������ Ÿ��
		int i = 10;
		int j = 10;
		// ���ʵ����� Ÿ�Կ����� ������ �ٸ��� ���ϴ¹��.
		//System.out.println((i==j)? "����" : "�ٸ���");
		if(i==j) {
			System.out.println("i�� j�� ����.");
		}
		
		// ��ü������ Ÿ��
		String name = "ȫ�浿";      
		String name2 = "ȫ�浿";
		//System.out.println((name==name2) ? "����" : "�ٸ���");
		//���� ������ �޸����� ������?  ��ü�����ε� String�� ���ٰ� �ν��� 
		if(name.equals(name2)) {
			System.out.println("name�� name2�� ����");
		}
		
		Woman choi = new Woman();
		Woman choi2 = new Woman();
		// choi.method();
		if(choi.equals(choi2)) {  // ��ü������ ������ ���Ҷ��� ��  .equals �� ����ؾ��� �⺻������ �ڹٿ��� �����ϴ� ���Լ�
			System.out.println("choi�� choi2�� ����.");
		} else {
			System.out.println("choi�� choi2�� �ٸ���.");
		}
		
		
		Man park = new Man(22,165,60.2);
		Man park2 = new Man(22,185,80.2);
		Man park3;
		Man park4 = new Man(22,185,80.2);
		
		park3 = park2;
		if (park3.equals(park2)) {
			System.out.println("park3�� park2�� ����.(���� �ּҸ� ����Ų��.)");			
		} else {
			System.out.println("park3�� park2�� �ٸ���.");
		} // if ���ǹ� �ȿ� !�� ������ ���� �ݴ밡 �ȴ�.
		// ������ false ���� !�� ������ true �� �ȴ�.
		if(park2.equals(park4)) {
			System.out.println("park2�� park4�� ����.");
		} else {
			System.out.println("park2�� park4�� �ٸ���.");
		}
		
		park.setHeight(179);
		park.setWeight(78.5);  // �׳� 78�־ �����ȳ� ������ : �������� ����ȯ�� ���� double������.	
		if(park.calculateBMI() > 30) {
			System.out.println("�ǰ��ϼ���");
		} else {
			System.out.println("�ǰ��ϰڳ׿�");
		}
		
		
		

	}

}
