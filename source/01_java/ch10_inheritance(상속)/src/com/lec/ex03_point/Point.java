package com.lec.ex03_point;

public class Point {
	private int x;
	private int y;
	
	// �����ε� (�Լ� �ߺ�����)
	public Point() {	// ����ϰ� ������ �Ű����� ���� ������ �Լ� ������ �־���� �ȱ׷��� ������.	
	}

	public Point(int x, int y) {		
		this.x = x;
		this.y = y;
	}
	// Point p = new Point(1,2);
	// p.pointPrint();                               1��
	// System.out.println(p.infoString());			 2��
	//  System.out.println(p); 						 3��	 // �̰� �ϱ����ؼ� �������̵� 
	//  �޼ҵ� 
	public void pointPrint() {
		System.out.println("2���� ��ǥ  : x =" +x+ ", y =" +y);
	}
	public String infoString() {
		return "2���� ��ǥ  : x =" +x+ ", y =" +y;
	}   // 2���� �Ϸ��� �̰� ����.
	
	@Override
	public String toString() {  // �������̵�  (toString �Լ� ������) = ��ӹ��� �Լ��� �Ű�����, ����Ÿ�� �����ϰ�
		return "2���� ��ǥ  : x =" +x+ ", y =" +y;		
	} 
	

	// setter&getter 
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	
	
}
