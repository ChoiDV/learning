package com.lec.ex4_boxorrect;

public class BoxOrRect {
	private int width; // ����
	private int height; // ����
	private int depth; // ������ü(Box) �� ���� ����, ���簢��(rect) �� ���� 0
	private int volume; // box �� ���� ����, rect�� ��� ����
	
	// volume �� ���ϴ� �޼ҵ带 �ϳ� ������ִ��� �����ھȿ� volume�� �������൵ �ȴ�.

	public BoxOrRect() { // ����Ʈ ����
		super();
	}

	public BoxOrRect(int width, int height) { // rect�� ���
		this.width = width;
		this.height = height;
		// depth �� �˾Ƽ� 0�� ��.
		volume = width * height;
	}

	public BoxOrRect(int width, int height, int depth) { // box �� ���
		this.width = width;
		this.height = height;
		this.depth = depth;
		volume = width * height * depth;
	}

	public int getVolume() {
		return volume;
	}

	public void vPrint() {
		if (depth != 0) { // box ���Ҹ�
			System.out.println("���Ǵ� : " + volume);
		} else { // rect�� �Ҹ�
			System.out.println("���̴� : " + volume);
		}

	}
}
