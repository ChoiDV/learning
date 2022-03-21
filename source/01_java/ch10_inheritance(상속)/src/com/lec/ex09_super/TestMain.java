package com.lec.ex09_super;

public class TestMain {

	public static void main(String[] args) {
		Person papa = new Person();
		papa.setName("¾Æºü°õ");
		papa.setCharacter("¶×¶×ÇØ");
		papa.intro();
		
		Person mom = new Person("¾ö¸¶°õ","³¯¾ÀÇØ");
		mom.intro();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		Baby child = new Baby();
		child.setName("¾Æ±â°õ1");
		child.setCharacter("±Í¿©¹Ì"); 
		child.intro();
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");
				
		Baby baby = new Baby("¾Ö±â°õ","³Ê¹« ±Í¿©¿ö");
		baby.intro(); 
		

	}

}
