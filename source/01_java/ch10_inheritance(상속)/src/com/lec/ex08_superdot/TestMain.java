package com.lec.ex08_superdot;
// ParentClass  - i(private), method(), getI()
// ChildClass  - i(private), method(), getI()
public class TestMain {

	public static void main(String[] args) {
		ChildClass child = new ChildClass();
		System.out.println("-----------------------\n");
		System.out.println(child.getI());  // getI�� super.getI �� �θ���� getI�� �ҷ���.
										  // ���� child.getI�� getI��  �׳� return i; �� �ϸ� 99�� �ҷ���.
		child.method();
		

	}

}
