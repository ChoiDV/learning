package com.lec.ex2_human;

public class ManTest {
// int age ����, int height Ű, double weight ������, String phoneNum �ڵ��� ��ȣ
	public static void main(String[] args) {
		Man moon = new Man();
		Man kim = new Man(22,165,60.5);
		Man choi = new Man(24,179,77.7,"010-4434-9878");
		
		System.out.print(choi.getAge()+ " ��\t ");
		System.out.println(choi.getHeight()+ " cm ");
		System.out.print(choi.getWeight()+ " kg \t");
		System.out.println("��ȭ��ȣ : " +choi.getPhoneNum());
		System.out.println(choi.calculateBMI());
		
		Woman park = new Woman();
		
		
	} 

}
