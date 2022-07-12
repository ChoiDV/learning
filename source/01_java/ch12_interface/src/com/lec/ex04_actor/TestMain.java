package com.lec.ex04_actor;

public class TestMain {

	public static void main(String[] args) {
		// 배우 박보검은 모든것을 할수 있다.
		Actor park = new Actor("박보검");
		park.canCatchCriminal();
		park.canSearch();
		park.outFire();
		park.saveMan();
		park.makePizza();
		park.makeSpaghetti();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		
		// 다형성
		// 요리사가 된 박보검
		IChef chefPark = new Actor("박요리사");
		chefPark.makePizza();
		chefPark.makeSpaghetti();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		// 소방관이 된 박보검
		IFireFighter firePark = new Actor("박소방관");
		firePark.outFire();
		firePark.saveMan();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		// 경찰관이 된 박보검
		IPoliceMan policePark = new Actor("박경찰관");
		policePark.canCatchCriminal();
		policePark.canSearch();
		
		
	}

}
