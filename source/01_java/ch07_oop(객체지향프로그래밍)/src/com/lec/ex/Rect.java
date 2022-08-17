package com.lec.ex;
// ������ Ŭ�������� 1. ������(private �� �ܺο��� �ǵ������ϰ� private�� �����) -width/height
//  , 		   2.�޼ҵ�(�ܺο��� �����Ҽ��ְ� public) -area()
// 				3.setter&getter(private�� �⺻ �����Ϳ� ���ο� ������ �ֱ����ؼ�) �� �����Ѵ�.
public class Rect {
	// �⺻ ��������
	private int width; // ����
	private int height; // ���� 
	
	public int area() {
		return (width * height);
	}
	// setter
	public void setWidth(int width) {
		this.width = width;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	// getter
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
}
