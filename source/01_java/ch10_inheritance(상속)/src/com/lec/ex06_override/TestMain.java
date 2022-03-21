package com.lec.ex06_override;

public class TestMain {

	public static void main(String[] args) {
		ParentClass pObj1 = new ParentClass();
		ParentClass pObj2 = new ParentClass(1);
		if (pObj1.equals(pObj2)) {
			System.out.println("�� ��ü�� ����.");
		} else {
			System.out.println("�� ��ü�� �ٸ���.");
		}

		ChildClass cObj = new ChildClass(2);

		if (cObj.equals(pObj2)) { // .equals �� ������ �´ٰ� �������� ChildClass ����
			System.out.println("������ true��");
		}

		pObj1.method1();
		pObj1.method2();
// 		pObj1.method3();  ������ �Ұ���
		System.out.println("--------------------------------------");
		cObj.method1(); // ChildClass�� method1 // ��? ChildClass ���� �������̵� ���༭
		cObj.method2(); // ParentClass�� method2
		cObj.method3(); // ChildClass�� method3
		System.out.println("--------------------------------------");
		
		ParentClass cObj1 = new ChildClass(2);
		cObj1.method1(); // ChildClass�� method1 ����
		cObj1.method2(); // ParentClass�� method2 ����

		// �ؿ��� ���� cObj1 �� ����ִ��� ������ ChildClass�� ������ true ������ false 
		
		if (cObj1 instanceof ChildClass) { // ParentClass�� cObj1 ������ ChildClass ������ ��ȯ �����ϴ�? ����ȯ �ϱ����� �̷��� ����� if�� ����
			((ChildClass) cObj1).method3(); // �������� ���� �θ� �ڽĲ��� ���� ��� ������� �� ��ȯ�� ������� .
		} else {
			System.out.println("����ȯ �� ��.");
		}
	}

}
