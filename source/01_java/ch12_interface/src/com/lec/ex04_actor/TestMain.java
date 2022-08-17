package com.lec.ex04_actor;

public class TestMain {

	public static void main(String[] args) {
		// ��� �ں����� ������ �Ҽ� �ִ�.
		Actor park = new Actor("�ں���");
		park.canCatchCriminal();
		park.canSearch();
		park.outFire();
		park.saveMan();
		park.makePizza();
		park.makeSpaghetti();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		
		// ������
		// �丮�簡 �� �ں���
		IChef chefPark = new Actor("�ڿ丮��");
		chefPark.makePizza();
		chefPark.makeSpaghetti();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		// �ҹ���� �� �ں���
		IFireFighter firePark = new Actor("�ڼҹ��");
		firePark.outFire();
		firePark.saveMan();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		// �������� �� �ں���
		IPoliceMan policePark = new Actor("�ڰ�����");
		policePark.canCatchCriminal();
		policePark.canSearch();
		
		
	}

}
