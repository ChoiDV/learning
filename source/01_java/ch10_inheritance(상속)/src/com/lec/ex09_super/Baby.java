package com.lec.ex09_super;
// Person�� ��ӹ޾� ���⿡�� �����Ͱ� ������  name, character �޼ҵ�� intro() �� �ִ»��� 
// Baby b = new Baby("ȫ�ư�","����");
// Baby b1 = new Baby(); 
public class Baby extends Person {
	public Baby() {
		System.out.println("�Ű� ���� ���� Baby");
	}
	public Baby(String name, String character) {
	// �̰� ���	setName(name); setCharacter(character);
		super(name, character);  // �θ���� (Person)�� �Ű����� �ΰ� ¥�� �����ڸ� �����ض�
		// �ݵ�� this�� super�� �޼ҵ��� ù�ٿ� ���´�.
		System.out.println("�Ű� ���� �ִ� Baby ������");
	}
	
	@Override
	public void intro() {
		System.out.print("���� ���� �� �ư���\t");
		super.intro(); // �� Ŭ������ �θ���� intro �� Person�� intro ����
	}
	
}
