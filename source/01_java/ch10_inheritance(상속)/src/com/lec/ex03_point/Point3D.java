package com.lec.ex03_point;
// Point3D가 Point 한테 상속받음  부모 : point , 자식 : point3d  화살표가 자식이 부모한테 가는 형태

// Point3D p1 = new Point3D(20,10,5);
// p1.pointPrint(); 하면 z 값이 출력이 안됌.

public class Point3D extends Point {
	private int z;
	
	// 생성자 함수 
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
	
	
	//  메소드 
	
	@Override
	public String toString() {
		return "3차원 좌표  : x =" +getX()+ ", y =" +getY()+", z ="+z;
	}
	public void poinht3DPrint() {
		System.out.println("3차원 좌표  : x =" +getX()+ ", y =" +getY()+", z ="+z);
	}
	public String info3DString() {
		return "3차원 좌표  : x =" +getX()+ ", y =" +getY()+", z ="+z;
	}
	
	
}
