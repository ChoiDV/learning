package com.lec.ex03_point;
// Point3D�� Point ���� ��ӹ���  �θ� : point , �ڽ� : point3d  ȭ��ǥ�� �ڽ��� �θ����� ���� ����

// Point3D p1 = new Point3D(20,10,5);
// p1.pointPrint(); �ϸ� z ���� ����� �ȉ�.

public class Point3D extends Point {
	private int z;
	
	// ������ �Լ� 
	public Point3D() {
	}
	public Point3D(int x, int y , int z) {
		setX(x);
		setY(y);
		this.z = z;
	}
	// setter&getter
	
	public int getZ() {
		return z;
	}
	public void setZ(int z) {
		this.z = z;
	}
	
	
	//  �޼ҵ� 
	
	@Override
	public String toString() {
		return "3���� ��ǥ  : x =" +getX()+ ", y =" +getY()+", z ="+z;
	}
	public void poinht3DPrint() {
		System.out.println("3���� ��ǥ  : x =" +getX()+ ", y =" +getY()+", z ="+z);
	}
	public String info3DString() {
		return "3���� ��ǥ  : x =" +getX()+ ", y =" +getY()+", z ="+z;
	}
	
	
}
