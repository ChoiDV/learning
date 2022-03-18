package com.lec.ex4_boxorrect;

public class BoxOrRect {
	private int width; // 가로
	private int height; // 세로
	private int depth; // 직육면체(Box) 의 경우는 깊이, 직사각형(rect) 일 경우는 0
	private int volume; // box 의 경우는 부피, rect일 경우 넓이
	
	// volume 을 구하는 메소드를 하나 만들어주던가 생성자안에 volume을 정의해줘도 된다.

	public BoxOrRect() { // 디폴트 생성
		super();
	}

	public BoxOrRect(int width, int height) { // rect일 경우
		this.width = width;
		this.height = height;
		// depth 는 알아서 0이 됨.
		volume = width * height;
	}

	public BoxOrRect(int width, int height, int depth) { // box 일 경우
		this.width = width;
		this.height = height;
		this.depth = depth;
		volume = width * height * depth;
	}

	public int getVolume() {
		return volume;
	}

	public void vPrint() {
		if (depth != 0) { // box 란소리
			System.out.println("부피는 : " + volume);
		} else { // rect란 소리
			System.out.println("넓이는 : " + volume);
		}

	}
}
