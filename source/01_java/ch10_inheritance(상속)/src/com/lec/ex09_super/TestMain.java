package com.lec.ex09_super;

public class TestMain {

	public static void main(String[] args) {
		Person papa = new Person();
		papa.setName("�ƺ���");
		papa.setCharacter("�׶���");
		papa.intro();
		
		Person mom = new Person("������","������");
		mom.intro();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		Baby child = new Baby();
		child.setName("�Ʊ��1");
		child.setCharacter("�Ϳ���"); 
		child.intro();
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");
				
		Baby baby = new Baby("�ֱ��","�ʹ� �Ϳ���");
		baby.intro(); 
		

	}

}
