//��Ű����, Ŭ������, ������, �������Լ�(�����ε�), �޼ҵ�, setter&getter
package com.lec.ex1_square;

public class Square {
	
	private int side;
	// ������ �Լ� ��ü�� ���� ���� JVM�� ����Ʈ�����ڸ� ������� (�ƹ��͵� �����ʴ� �Ű����� ���� ������
	public Square() { //������ �Լ� : return Ÿ���� ����, Ŭ������� ���� �Լ��� ������ �Լ���� �θ���.  void ���� �ȉ�
		System.out.println("�Ű����� ���� ������ �Լ� ȣ���");
	}
	// ����Ʈ ������
	// ex) Square s1 = new Square(); �̰��� ����Ҷ� ��� ������ �ܰ迡�� ��ǻ�Ͱ� �ڵ����� public Square��� �������Լ��� �����������.
	public Square(int side) { // �Ű����� �ִ� ������ �Լ� �뵵 : ������ �ʱ�ȭ
		this.side = side; // �� ���⿡ �������� �־ �ϳ��ϳ� setter,getter �����ʿ���� �ѹ��� �����ϸ鼭 �ʱ�ȭ���� �Ϸ���
						 // �̰� �����.
		System.out.println("�Ű����� �ִ� ������ �Լ� ȣ��. side �ʱ�ȭ " + side);
	}
	public int area() {
		return side*side;
		
	}
	public int getSide() {
		return side;
	}
	public void setSide(int side) {
		this.side = side;
	}

}
