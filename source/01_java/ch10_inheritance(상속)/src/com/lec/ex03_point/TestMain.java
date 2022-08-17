package com.lec.ex03_point;

public class TestMain {

	public static void main(String[] args) {
		Point point = new Point();
		point.setX(10);
		point.pointPrint();
		System.out.println(point.infoString());
		System.out.println(point);  // Object의 toString() 이 호출됨.
		System.out.println(point.toString());
		// 그래서 point 와 point.toString 의 결과값이 똑같이 나옴.
		
		Point3D point3d = new Point3D(1,2,3);
		System.out.println(point3d);
		System.out.println(point3d.info3DString());
		System.out.println(point3d.infoString());  // 상속을 받으면 모든 멤버와 메소드 다 상속받음

	}

}
