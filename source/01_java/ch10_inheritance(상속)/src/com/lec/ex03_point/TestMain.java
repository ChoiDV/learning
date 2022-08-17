package com.lec.ex03_point;

public class TestMain {

	public static void main(String[] args) {
		Point point = new Point();
		point.setX(10);
		point.pointPrint();
		System.out.println(point.infoString());
		System.out.println(point);  // Object�� toString() �� ȣ���.
		System.out.println(point.toString());
		// �׷��� point �� point.toString �� ������� �Ȱ��� ����.
		
		Point3D point3d = new Point3D(1,2,3);
		System.out.println(point3d);
		System.out.println(point3d.info3DString());
		System.out.println(point3d.infoString());  // ����� ������ ��� ����� �޼ҵ� �� ��ӹ���

	}

}
