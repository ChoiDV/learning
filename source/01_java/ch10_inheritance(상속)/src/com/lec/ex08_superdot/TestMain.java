package com.lec.ex08_superdot;
// ParentClass  - i(private), method(), getI()
// ChildClass  - i(private), method(), getI()
public class TestMain {

	public static void main(String[] args) {
		ChildClass child = new ChildClass();
		System.out.println("-----------------------\n");
		System.out.println(child.getI());  // getI가 super.getI 라서 부모단의 getI를 불러옴.
										  // 만약 child.getI의 getI를  그냥 return i; 로 하면 99가 불려옴.
		child.method();
		

	}

}
