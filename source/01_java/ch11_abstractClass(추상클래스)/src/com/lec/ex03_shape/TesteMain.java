package com.lec.ex03_shape;

public class TesteMain {

	public static void main(String[] args) {
		
		Shape[] shape = {new Rectangle(10,5), new Triangle(5,6), new Circle(5)};
		for(Shape s : shape) {
			s.draw();
			System.out.println("���� ���̴� " + s.computeArea());
	}

	}

}
