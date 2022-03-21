package com.lec.ex11_final;

public class TestMain {

	public static void main(String[] args) {
		
		Animal[] animals = { new Dog(), new Rabbit()};
		
		animals[0].running();
		animals[0].running();
		animals[0].stop();
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		animals[1].running();
		animals[1].running();
		animals[1].stop();
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		for(Animal animal : animals) {
			animal.running();
			animal.running();
			animal.stop();
		}
	}

}
